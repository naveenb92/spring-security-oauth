package me.naveen.springsecurityoauth.controller;

import me.naveen.springsecurityoauth.model.Hello;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Naveen Babu on 05-05-2016.
 */
@RestController
public class HomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public Hello helloWorld(){
        return new Hello();
    }

}
