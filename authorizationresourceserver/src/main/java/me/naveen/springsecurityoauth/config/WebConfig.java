package me.naveen.springsecurityoauth.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Naveen Babu on 05-05-2016.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"me.naveen.springsecurityoauth"})
public class WebConfig extends WebMvcConfigurerAdapter {



}
