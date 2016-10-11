package me.naveen.springsecurityoauth.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import me.naveen.springsecurityoauth.model.ApplicationUser;
import me.naveen.springsecurityoauth.model.Hello;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Naveen Babu on 05-05-2016.
 */
@RestController
public class HomeController {

    @Autowired
    public UserDetailsService userDetailsService;

    @Autowired
    private ApplicationUser currentUser;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public Hello helloWorld(){


        System.out.print(currentUser.getUsername() + currentUser.getId() + currentUser.getTenantId());
        return new Hello();
    }

}
