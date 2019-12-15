package com.cbolije.nexsysbackend.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.logging.Logger;

@Controller
public class HomeController {

    @GetMapping("/")
    public String showHome() {
        Logger.getLogger(HomeController.class.toString()).info("Show");
        return "home";
    }

}
