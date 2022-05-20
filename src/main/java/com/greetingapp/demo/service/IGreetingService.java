package com.greetingapp.demo.service;

import com.greetingapp.demo.model.Greeting;
import com.greetingapp.demo.model.User;

import java.util.List;

public interface IGreetingService {
	Greeting addGreeting(User user);
    Greeting getGreetingById(long id);

    Greeting greetUser(User user);

    List<Greeting> getGreetings();

    Boolean deleteGreeting(long id);

    Greeting updateGreeting(long id, User user);
}
