package com.greetingapp.demo.controller;

import com.greetingapp.demo.model.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {
    private static final String template = "Hello %s %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting (@RequestParam(value = "firstName", defaultValue = "") String firstName,
    							@RequestParam(value = "lastName", defaultValue = "") String lastName) {
    	String defaultText1 = "World", defaultText2 = "";
    	if(firstName.contentEquals("") && lastName.contentEquals("")) {
    		return new Greeting(counter.incrementAndGet(), String.format(template, defaultText1, defaultText2));
    	}
        return new Greeting(counter.incrementAndGet(), String.format(template, firstName, lastName));
    }
    
}