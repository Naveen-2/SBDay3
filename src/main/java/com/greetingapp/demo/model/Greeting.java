package com.greetingapp.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Greeting {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	private String message;

	public Greeting() {
        super();
    }
	
    public  Greeting(long id, String message) {
        this.id = id;
        this.message = message;
    }
    
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    @Override
    public String toString() {
        return "Greeting{" +
                "message='" + message + '\'' +
                ", id=" + id +
                '}';
    }
}
