package com.app;

import java.util.Optional;

class HelloService {

    static final String FALLBACK_NAME = "World";
    static final Lang FALLBACK_LANG = new Lang(1, "Hello", "en");

    private LangRepository repository;

    HelloService(){
        this(new LangRepository());
    }
    HelloService(LangRepository repository){
        this.repository = repository;
    }

    String prepareGreeting(String name) {
      return  prepareGreeting(name, null);
    }
    String prepareGreeting(String name, String lang){
        var langId = Optional.ofNullable(lang).map(Integer::valueOf).orElse(FALLBACK_LANG.getId());
        var welcomeMsg = repository.findById(langId).orElse(FALLBACK_LANG).getWelcomeMsg();
        var nameToWelcome = Optional.ofNullable(name).orElse(FALLBACK_NAME);
        return welcomeMsg + " " + nameToWelcome + " !";
    }
}
