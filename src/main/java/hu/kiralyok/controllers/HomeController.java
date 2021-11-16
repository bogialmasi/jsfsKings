package hu.kiralyok.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


    @Controller
    public class HomeController {
        @GetMapping("/")
        public String home() {
            return "index";
        } //templates mappában keresni fog egy "index" HTML fájlt
    }
