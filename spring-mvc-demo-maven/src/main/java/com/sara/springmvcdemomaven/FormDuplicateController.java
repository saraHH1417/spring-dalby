package com.sara.springmvcdemomaven;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/duplicate")
public class FormDuplicateController {

    @RequestMapping("/show-form")
    public String displayTheForm() {
        return "form-duplicate";
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
