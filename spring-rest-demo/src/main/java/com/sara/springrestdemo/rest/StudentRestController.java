package com.sara.springrestdemo.rest;

import com.sara.springrestdemo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    @GetMapping("/students")
    public List<Student> getStudents() {
        List<Student> theStudents = new ArrayList<>();
        theStudents.add(new Student("sara", "gfg"));
        theStudents.add(new Student("mary" , "blue"));
        theStudents.add(new Student("john", "grey"));

        return theStudents;
    }
}
