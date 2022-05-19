package com.greetingapp.demo.model;

public class Greeting {
	
	private String message;
    private long id;

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
}
