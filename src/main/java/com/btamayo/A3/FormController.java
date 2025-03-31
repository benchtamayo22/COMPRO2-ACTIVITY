package com.btamayo.A3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
public class FormController {

    @GetMapping("/form")
    public String showForm() {
        return "form"; // Points to src/main/resources/templates/forms/form.html
    }

    @PostMapping("/submitForm")
    public String handleFormSubmission(@RequestParam String name,
                                       @RequestParam String email,
                                       @RequestParam String password,
                                       @RequestParam String dob,
                                       @RequestParam(required = false) Integer age,
                                       @RequestParam String gender,
                                       @RequestParam String country,
                                       @RequestParam(required = false) String[] interests,
                                       @RequestParam(required = false) String comments,
                                       Model model) {

        System.out.println("Form Data Received:");
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Password: " + password);
        System.out.println("Date of Birth: " + dob);
        System.out.println("Age: " + (age != null ? age : "Not provided"));
        System.out.println("Gender: " + gender);
        System.out.println("Country: " + country);

        if (interests != null) {
            System.out.println("Interests: " + String.join(", ", interests));
        } else {
            System.out.println("Interests: None selected");
        }

        System.out.println("Comments: " + (comments != null ? comments : "No comments"));

        model.addAttribute("message", "Form submitted successfully!");
        return "forms/form";
    }
}


