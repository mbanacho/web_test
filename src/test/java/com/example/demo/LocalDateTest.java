package com.example.demo;

import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class LocalDateTest {

    @Test
    public void test1() {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
    }

    @Test
    public void test2() {
        LocalDateTime localDateTime = LocalDateTime.now();
        
    }


}
