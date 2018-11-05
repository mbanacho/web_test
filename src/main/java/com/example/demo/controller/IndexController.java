package com.example.demo.controller;

import com.example.demo.service.SimpleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {

    private SimpleService service;

    @Autowired
    public IndexController(SimpleService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity getIndexPage(){
        service.aasfdg(100);
        return service.getIndexPage();
    }

}
