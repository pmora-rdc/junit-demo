package com.reputation.junit.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class ImportantController {
    @GetMapping
    public String getIndex() {
        return "Hello World!";
    }
}
