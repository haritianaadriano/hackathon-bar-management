package com.hackathon.gestion_bar.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Ping {

    @CrossOrigin
    @GetMapping("/ping")
    public String ping(){
        return "pong";
    }
}
