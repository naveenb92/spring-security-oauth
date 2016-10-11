package me.naveen.springsecurityoauth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import me.naveen.springsecurityoauth.Service.ApplicationUserDetailsService;
import org.springframework.web.context.WebApplicationContext;
import me.naveen.springsecurityoauth.model.ApplicationUser;

/**
 * Created by Naveen Babu on 05-05-2016.
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean("currentUser")
    @Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
    public ApplicationUser applicationUser()
    {
        OAuth2Authentication oAuth2Authentication = (OAuth2Authentication) SecurityContextHolder.getContext().getAuthentication();
        return (ApplicationUser) oAuth2Authentication.getUserAuthentication().getPrincipal();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        return new ApplicationUserDetailsService();
    }

    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        System.out.println("Configuring Security Now");

        auth.userDetailsService(userDetailsService());
    }
}
