package com.valeria.portafolioproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String inicio() {
        return "redirect:/catalogo";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
