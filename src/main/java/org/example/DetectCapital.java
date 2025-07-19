package org.example;

import java.util.Scanner;

public class DetectCapital {

    private static boolean detectCapital(String word) {

        int count = 0;
        for (char ch : word.toCharArray()) {
            if (((byte) ch) >= 65 && ((byte) ch) <= 90) {
                count++;
            }
        }

        if (count == word.length()) {
            return true;
        } else if (count == 0) {
            return true;
        } else if (count == 1 && (((byte) word.charAt(0)) >= 65 && ((byte) word.charAt(0)) <= 90)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println((byte)'A');
        System.out.println((byte)'Z');
        Scanner sc =new Scanner(System.in);
        System.out.println(detectCapital(sc.nextLine()));

    }


}
