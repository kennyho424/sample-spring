package com.example.samplespring.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.annotation.PostConstruct;

@Data
public class Student extends Person {
    private String studentId;
}
