package com.app;

import java.util.Optional;

class HelloService {

    private final String substituteVariable = "World";

    public String prepareGreetings(String name) {
        return "Hello " + Optional.ofNullable(name).orElse(substituteVariable) + "!";
    }

}
