package com.sara.springmvcdemomaven;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class FormController {

    // need a controller method to show the initial HTML form
    @RequestMapping("/show-form")
    public String showForm() {
        return "helloworld-form";
    }

    // need a controller method to process the HTML form
    @RequestMapping("/process-form")
    public String processForm() {
        return "helloworld";
    }

    @RequestMapping("/process-form-version-two")
    public String letsShoutDude(HttpServletRequest request, Model model) {
        // read the request parameter from the html form
        String theName = request.getParameter("studentName");

        // convert the data to all caps (capital letters)
        theName = theName.toUpperCase();

        // create the message
        String result = "Yo! " + theName;

        // add the message to the model
        model.addAttribute("message", result);

        return  "helloworld";
    }

    @RequestMapping("/process-form-version-three")
    public String processFormVersionThree(@RequestParam("studentName") String theName, Model model) {

        // convert the data to all caps (capital letters)
        theName = theName.toUpperCase();

        // create the message
        String result = "Hey my dear friend from v3! " + theName;

        // add the message to the model
        model.addAttribute("message", result);

        return  "helloworld";
    }
}
