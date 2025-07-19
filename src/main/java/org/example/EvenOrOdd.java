package org.example;

import java.util.Scanner;

public class EvenOrOdd {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.println((num % 2 == 0)?"EVEN":"ODD");
        int num1 = scanner.nextInt();
        System.out.println("entered number:"+num1);
    }
}