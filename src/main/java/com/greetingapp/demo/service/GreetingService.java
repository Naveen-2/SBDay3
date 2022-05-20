package com.greetingapp.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.greetingapp.demo.model.Greeting;
import com.greetingapp.demo.model.User;
import com.greetingapp.demo.repository.GreetingRepository;

@Service
public class GreetingService implements IGreetingService{
	private static final String TEMPLATE = "Hello %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    GreetingRepository greetingRepository;

    @Override
    public Greeting getGreetingById(long id) {
        return greetingRepository.findById(id).get();
    }

    @Override
    public Greeting addGreeting(User user) {
        String message = String.format(TEMPLATE, (user.toString().contains("null")) ? "World" : user.toString());
        return greetingRepository.save(new Greeting(counter.incrementAndGet(), message));
    }

    @Override
    public Greeting greetUser(User user) {
        String message = String.format(TEMPLATE, (user.toString().contains("null")) ? "World" : user.toString());
        return new Greeting(counter.incrementAndGet(), message);
    }

    @Override
    public List<Greeting> getGreetings() {
        return greetingRepository.findAll();
    }

    @Override
    public Boolean deleteGreeting(long id) {
        greetingRepository.deleteById(id);
        return true;
    }

    @Override
    public Greeting updateGreeting(long id, User user) {
        Optional<Greeting> greetingObj = greetingRepository.findById(id);
        if (greetingObj.isPresent()) {
            Greeting greeting = greetingObj.get();
            String message = String.format(TEMPLATE, (user.toString().contains("null")) ? "World" : user.toString());
            greeting.setMessage(message);
            return greetingRepository.save(greeting);
        }
        return null;
    }
}
