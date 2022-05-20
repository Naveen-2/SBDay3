package com.greetingapp.demo.controller;

import com.greetingapp.demo.model.Greeting;
import com.greetingapp.demo.model.User;
import com.greetingapp.demo.service.IGreetingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/greeting")
public class GreetingController {
	 	
		@Autowired
	    private IGreetingService greetingService;

		/**
	     * Method: GET
	     * URL: http://localhost:8081/greeting/{id}
	     * @param id
	     * @return { "id": value, "message": value }
	     */
	    @GetMapping("/{id}")
	    public Greeting greetUser(@PathVariable(value="id") Long id) {
	        return greetingService.getGreetingById(id);
	    }
	    
	    /**
	     * Method: GET
	     * URL: http://localhost:8081/greeting/
	     * @return JSON Object
	     */
	    @GetMapping("/")
	    public List<Greeting> getGreetings() {
	        return greetingService.getGreetings();
	    }
	    
	    /**
	     * Method: DELETE
	     * URL: http://localhost:8081/greeting/{id}
	     * @param id
	     * @return boolean
	     */
	    @DeleteMapping("/{id}")
	    public Boolean deleteGreeting(@PathVariable(value="id") Long id) {
	        return greetingService.deleteGreeting(id);
	    }

	    /**
	     * Method: POST
	     * URL: http://localhost:8081/greeting/
	     * @param user
	     * @return { "id": value, "message": value }
	     */
	    @PostMapping("/")
	    public Greeting createGreeting(@RequestBody User user) {
	        return greetingService.addGreeting(user);
	    }

	    /**
	     * Method: PUT
	     * URL: http://localhost:8081/greeting/{id}
	     * @param id
	     * @param user
	     * @return
	     */
	    @PutMapping("/{id}")
	    public Greeting updateGreeting(@PathVariable(value="id") Long id, @RequestBody User user) {
	        return greetingService.updateGreeting(id, user);
	    }
}