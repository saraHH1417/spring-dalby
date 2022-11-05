package com.sara.springmvcdemomaven.FormTagsDataBinding;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

@Controller
@RequestMapping("/student")
public class StudentController {

    @RequestMapping("/show-form")
    public String showForm(Model theModel)
    {
        Student theStudent = new Student();
        theModel.addAttribute("student", theStudent);

        return "student-form";
    }

    @RequestMapping("/process-form")
    public String processForm(@ModelAttribute("student") Student theStudent) {
        // log the input data
        System.out.println("The Student: " + theStudent.getFirstName() + " " + theStudent.getLastName());
        System.out.println(Arrays.toString(theStudent.getOperatingSystems()));
        return "student-confirmation";
    }
}
