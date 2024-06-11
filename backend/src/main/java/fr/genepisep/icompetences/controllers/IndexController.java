package fr.genepisep.icompetences.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("/")
    public String index() {
        System.out.println("Index controller called");
        return "index";
    }
}
