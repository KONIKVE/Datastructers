package org.example;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Integer> list = List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(list);
        System.out.println(list.reversed());
        System.out.println(list.subList(0, list.indexOf(5)));
        System.out.println(list);
        System.out.println(list.subList(list.indexOf(5) + 1, list.size()));
    }
}
