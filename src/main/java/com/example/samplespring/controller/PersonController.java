package com.example.samplespring.controller;

import com.example.samplespring.model.Person;
import com.example.samplespring.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/person")
public class PersonController {

    private static final Logger logger = LoggerFactory.getLogger(PersonController.class);
    @Autowired
    private PersonService personService;

    @PostConstruct
    private void init() {
        logger.info("==== initializing person controller ====");
    }

    @PreDestroy
    private void destroy() {
        logger.info("==== stopping person controller ====");
    }

    @GetMapping("/{id}")
    public Person getPerson(@PathVariable(value = "id") String id){
        return personService.findPerson();
    }
}
