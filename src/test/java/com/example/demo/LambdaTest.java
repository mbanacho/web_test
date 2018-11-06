package com.example.demo;

import org.junit.Assert;
import org.junit.Test;
import pl.mbanacho.cars.database.model.User;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LambdaTest {

    @Test
    public void concatElementsFromList() {
        Stream<String> textList = Stream.of("a","b","c");
        BinaryOperator<String> concatSrtingList = (s1, s2) -> s1.concat(s2);
        String result = textList.reduce("",concatSrtingList);
        Assert.assertEquals("abc",result);
    }

    @Test
    public void concatElementsFromList_v2() {
        Stream<String> textList = Stream.of("a","b","c");
        String result = textList.collect(Collectors.joining(""));
        Assert.assertEquals("abc",result);
    }

    @Test
    public void testUtilFunction() {
        Stream<String> stream_a = Stream.of("a","b","c");
        Function<String,String> func = (s1)->"aaaaa"+s1;
        stream_a.map(func).forEach(System.out::println);
    }

    @Test
    public void testDistinct() {
        Stream<String> stream_a = Stream.of("a","b","c","a","b","c");
        stream_a.distinct().forEach(System.out::println);
    }

    @Test
    public void testUtilConumerFunction() {
        Stream<String> stream_a = Stream.of("a","b","c","a","b","c");
        Consumer<String> printText = s1 -> System.out.print(" wynik: "+s1);
        stream_a.distinct().forEach(printText);
    }

    @Test
    public void test6() {
        Stream<String> stream_a = Stream.of("aasdfasd","basdfa","asdfca","aasdf","basdfafds","cadsfasds","a1asdf","basfdsafdsa1","casdfasasd1");
        System.out.println(stream_a.min(Comparator.comparing(String::length)));
    }

    @Test
    public void findShortestString() {
        Supplier<Stream<String>> stream_a = () -> Stream.of("aasdfasd","basdfa","asdfca","aasdf","basdfafds","cadsfasds","a1asdf","basfdsafdsa1","casdfasasd1");
        Optional<String> minLength = stream_a.get().min(Comparator.comparing(String::length));
        stream_a.get().filter(text -> text.length()<minLength.get().length())
                .forEach(System.out::println);
    }

    @Test
    public void test8() {
        Supplier<Stream<String>> stream_a = () -> Stream.of("aasdfasd","basdfa","asdfca","aasdf","basdfafds","cadsfasds","a1asdf","basfdsafdsa1","casdfasasd1");
        stream_a.get().forEachOrdered((s1)-> System.out.print(s1+"-"));
        System.out.println("");
        stream_a.get().parallel().forEach((s1)-> System.out.print(s1+"-"));
        System.out.println("");
        stream_a.get().forEach((s1)-> System.out.print(s1+"-"));
    }

    private List<User> getUsers(){
        List<User> users = new LinkedList<User>();

        User user = new User(1L, "imie", "nazwisko1", "email@email.com", "pass", Boolean.TRUE, Boolean.FALSE);
        users.add(user);
        User user1 = new User(2L, "imie1", "nazwisko5", "email1@email.com", "pass1", Boolean.TRUE, Boolean.FALSE);
        users.add(user1);
        User user2 = new User(3L, "imie2", "nazwisko3", "email2@email.com", "pass2", Boolean.TRUE, Boolean.FALSE);
        users.add(user2);
        User user3 = new User(4L, "imie3", "nazwisko1", "email3@email.com", "pass3", Boolean.TRUE, Boolean.FALSE);
        users.add(user3);
        User user4 = new User(5L, "imie1", "nazwisko5", "email4@email.com", "pass4", Boolean.TRUE, Boolean.FALSE);
        users.add(user4);
        User user5 = new User(6L, "imie2", "nazwisko3", "email5@email.com", "pass5", Boolean.TRUE, Boolean.FALSE);
        users.add(user5);
        User user6 = new User(7L, "imie3", "nazwisko4", "email6@email.com", "pass6", Boolean.TRUE, Boolean.FALSE);
        users.add(user6);
        User user7 = new User(8L, "imie4", "nazwisko5", "email7@email.com", "pass7", Boolean.TRUE, Boolean.FALSE);
        users.add(user7);
        User user8 = new User(9L, "imie5", "nazwisko6", "email8@email.com", "pass8", Boolean.TRUE, Boolean.FALSE);
        users.add(user8);
        User user9 = new User(10L, "imie6", "nazwisko6", "email9@email.com", "pass9", Boolean.TRUE, Boolean.FALSE);
        users.add(user9);

        return users;
    }


    @Test
    public void test9() {
        List<String> ll = getUsers().stream().map(user -> user.getFirstName()).distinct().collect(Collectors.toList());
        ll.stream().forEach(System.out::println);
    }

    @Test
    public void testPredicate() {
        Predicate<User> namePredicate = user -> user.getFirstName().contains("2");
        getUsers().stream().filter(namePredicate).collect(Collectors.toList()).forEach(user -> System.out.println(user.getFirstName()));
    }

    @Test
    public void test11() {
        Predicate<User> namePredicate = user -> user.getFirstName().contains("2");
        Map<User, Long> result =
                getUsers().stream().collect(
                        Collectors.groupingBy(
                                Function.identity(),Collectors.counting()
                        )
                );
        System.out.println(result);
    }

    @Test
    public void test12() {
        Predicate<User> namePredicate = user -> user.getFirstName().contains("2");
        Map<String, Long> result =
                getUsers().stream().collect(Collectors.groupingBy(
                                User::getFirstName,Collectors.counting()
                        )
                );
        System.out.println(result);
    }

    @Test
    public void summingIdValuesForEachKindOfName() {
        Predicate<User> namePredicate = user -> user.getFirstName().contains("2");
        Map<String, Long> result =
                getUsers().stream().collect(Collectors.groupingBy(
                                User::getFirstName,Collectors.summingLong(User::getId)
                        )
                );
        System.out.println(result);
    }
}