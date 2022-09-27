package com.example.samplespring.service.impl;

import com.example.samplespring.model.Student;
import com.example.samplespring.service.StudentService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private static final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);

    private final List<Student> students = new ArrayList<>();

    private static final ObjectMapper mapper = new ObjectMapper();

    @PostConstruct
    private void init() {
        logger.info("==== start to init Student List ====");
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource resource = resourceLoader.getResource("/student_list.json");
        try (InputStream in = resource.getInputStream()) {
            List<Student> _student = mapper.readValue(in, new TypeReference<List<Student>>() {
            });
            students.addAll(_student);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        logger.info("==== end of init Student List ====");
        logger.info("number of students in list : {}", students.size());
    }

    @Override
    public List<Student> getStudents() {
        return students;
    }
}
