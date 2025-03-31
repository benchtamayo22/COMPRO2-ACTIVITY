package com.btamayo.A2_Coffee;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    private List<A2CoffeeApplication> coffees = new ArrayList<>();

    public HomeController() {
        coffees.add(new A2CoffeeApplication(1, "Espresso", "Strong"));
        coffees.add(new A2CoffeeApplication(2, "Latte", "Mild"));
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("coffees", coffees);
        return "index";
    }

    @GetMapping("/add")
    public String addCoffeeForm() {
        return "new";
    }

    @PostMapping("/save")
    public String saveCoffee(@RequestParam String name, @RequestParam String type) {
        int newId = coffees.get(coffees.size() - 1).getId() + 1;
        coffees.add(new A2CoffeeApplication(newId, name, type));
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String editCoffee(@RequestParam int id, Model model) {
        for (A2CoffeeApplication coffee : coffees) {
            if (coffee.getId() == id) {
                model.addAttribute("coffee", coffee);
                return "edit";
            }
        }
        return "redirect:/";
    }

    @PostMapping("/update")
    public String updateCoffee(@RequestParam int id, @RequestParam String name, @RequestParam String type) {
        for (A2CoffeeApplication coffee : coffees) {
            if (coffee.getId() == id) {
                coffee.setName(name);
                coffee.setType(type);
                break;
            }
        }
        return "redirect:/";
    }
}
