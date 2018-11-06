package com.example.demo.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SimpleService {

    public ResponseEntity getIndexPage() {

        return ResponseEntity.ok("abc");
    }

    public String aasfdg(Integer a){
        if(a==100){
            return "a";
        }
        return "b";
    }

    public String aasfcbcdg(){


        return "azb";
    }
}
