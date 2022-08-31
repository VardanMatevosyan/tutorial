package ru.matevosyan.oop_breakers.method_extraction.builder;

import ru.matevosyan.oop_breakers.method_extraction.domain.User;

public class UserBuilder {
    private final User user = new User();

    public UserBuilder predefineAll() {
        user.setCountry("UA");
        user.setName("Nazar");
        return this;
    }

    public UserBuilder name(String name) {
        user.setName(name);
        return this;
    }

    public UserBuilder country(String country) {
        user.setName(country);
        return this;
    }


    public User build() {
        return user;
    }

}
