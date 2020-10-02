package com.example;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;

import javax.validation.Valid;

@Controller("/person")
public class PersonController {

    private final NameTransformer nameTransformer;

    public PersonController(NameTransformer nameTransformer) {
        this.nameTransformer = nameTransformer;
    }

    @Post
    public Person transform(@Body @Valid Person person) {
        return new Person(nameTransformer.transform(person.getName()));
    }
}
