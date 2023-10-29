package com.example.project7.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class apiController {

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String welcome() {
        return "This is the API welcome page";
    }

    @RequestMapping(value = "/getUserDetails", method = RequestMethod.GET)
    public String getDetails() {
        System.out.println("Hello");
        return "{\"name\":\"shubham\"}";
    }
}
