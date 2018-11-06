package com.example.demo;

import org.junit.Assert;
import org.junit.Test;

import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public class LambdaTest {

    @Test
    public void contextLoads() {
       Stream<String> textList = Stream.of("a","b","c");

       BinaryOperator<String> concatSrtingList = (s1, s2) -> s1.concat(s2);

       String result = textList.reduce("",concatSrtingList);
        Assert.assertEquals("abc",result);
    }
}

