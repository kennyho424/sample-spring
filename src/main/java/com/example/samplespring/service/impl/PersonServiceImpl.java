package com.example.samplespring.service.impl;

import com.example.samplespring.configuration.SpeechConfig;
import com.example.samplespring.model.Person;
import com.example.samplespring.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
public class PersonServiceImpl implements PersonService {

    private Logger logger = LoggerFactory.getLogger(PersonServiceImpl.class);

    @PostConstruct
    private void init() {
        logger.info("==== initializing person service ====");
    }

    @PreDestroy
    private void destroy() {
        logger.info("==== stopping person service ====");
    }

    @Override
    public Person findPerson() {
        Person person = new Person();
        person.setGender('M');
        person.setName("Kenny");
        return person;
    }

}
