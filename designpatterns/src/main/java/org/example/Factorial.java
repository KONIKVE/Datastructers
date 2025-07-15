package org.example;

import java.util.Scanner;

public class Factorial {

    private static int factorial(int n) {
        // base condition
        if (n==1 || n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(factorial(scanner.nextInt()));
    }

}
