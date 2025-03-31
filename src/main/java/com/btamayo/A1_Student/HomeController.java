package com.btamayo.A1_Student;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;  // Correct import
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    private List<A1StudentApplication> students = new ArrayList<>();

    public HomeController() {
        students.add(new A1StudentApplication(1, "Bench", "Tamayo"));
        students.add(new A1StudentApplication(2, "Van Phillip", "Tamayo"));
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("students", students);  // No error here
        return "index";
    }

    @GetMapping("/delete")
    public String deleteStudent(@RequestParam int id) {
        students.removeIf(student -> student.getId() == id);
        return "redirect:/";
    }
}