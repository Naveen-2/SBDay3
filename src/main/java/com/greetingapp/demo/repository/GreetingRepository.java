package com.greetingapp.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.greetingapp.demo.model.Greeting;


public interface GreetingRepository extends JpaRepository<Greeting, Long> {

}
