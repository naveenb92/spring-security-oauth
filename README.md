# Securing REST Api's using Spring Security OAuth
An example template for using spring security oauth to secure your REST Api.

# Dependencies
  * javax.servlet-api
  * spring-webmvc
  * spring-security-web
  * spring-security-config
  * spring-security-oauth2
  * spring-security-jwt
  * jackson-databind
  
*javax.servlet-api* and *spring-webmvc dependencies* are required for Spring Web MVC using which we will create the Rest Controllers. If you are deploying your application to a Java EE Container, you will not need the *javax.servlet.api* dependency. *spring-security-web* and *'spring-security-config* are the core Spring security packages. *spring-security-oauth2* enables OAUTH (No s\*\*t). *spring-security-jwt* enables us to use [JWT (Json Web Tokens)](https://jwt.io/).

# The Basics
I assume you are fairly comfortable with [Spring Security](http://docs.spring.io/spring-security/site/docs/4.1.3.RELEASE/reference/htmlsingle/). Please understand how [OAuth Authorization Server](https://aaronparecki.com/2012/07/29/2/oauth2-simplified) and [OAuth Resource Server](https://www.oauth.com/) work together. Once that is out of the way, gather a little knowledge about [JWT](https://jwt.io/introduction/).

# Assumptions
In the projects i work, we generally have the authorization and resource server in the same application, and that is the configuration i  will be using. There are certain scenarios where you might need a separate authorization server. In that case you can refer to the official spring security oauth examples. You can even strip of the resource server configuration from this example and use it as a standalone authorization server (more on this later).

# SecurityConfig.java
The *SecurityConfig.java* will be our starting point for configuring spring security. 

We expose the authenticationManager bean by overriding the method in WebSecurityConfigurerAdapter. The only purpose of overriding the method is to expose the authentication manager as a bean. Other than the @Bean annotation, nothing else is changed.

The *@EnableAuthorizationServer* annotation is used to enable the OAuth 2.0 Authorization Server mechanism. We will further configure it *AuthServerOAuth2Config.java*. 

We also use *@EnableResourceServer* to make our application serve resources that are protected by the OAuth2 token. Since the Authorization server and Resource server are the same application, we configure a TokenStore bean and AccessTokenConvertor bean to use JWT. The token is signed with a secret key, if you will be using a separate Authorization Server and Resource Server, you can enable Encryption using public/private key pair.

We also register an AuthorizationServerConfigurer bean to configure the authorization server as mentioned in the [Developer's Guide](https://projects.spring.io/spring-security-oauth/docs/oauth2.html)

# AuthServerOAuth2Config.java

This 'AuthServerOAuth2Config.java' is used to configure the OAuth authorization server.

You will atleast need to configure a client and since we are using JWT, we will also configure the token store. We register the authenticationManager, the tokenStore and the accessTokenConverter in the 'configure(AuthorizationServerEndpointsConfigurer endpoints)' method.

The 'allowFormAuthenticationForClients()' in 'configure(AuthorizationServerSecurityConfigurer security)' method enables us to obtain access token without specifying a client secret (ie. client authentication is not enforced which is otherwise enforced by default). 

In my case we use a SPA in front of an API. There is no way for the web app to maintain a client secret without exposing it. Hence the client secret is basically pointless.
