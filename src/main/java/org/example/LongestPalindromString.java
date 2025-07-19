package org.example;

import java.util.Arrays;

public class LongestPalindromString {

    private static String findLargestPalindromeString(String str) {
        char[] arr = str.toCharArray();
        String longestPalindrome = "";
        for (int i = 0; i < arr.length; i++) {
            String string = helper(arr, i, i);
            String string1 = helper(arr, i, i + 1);
            string = string.length() > string1.length() ? string : string1;
            if (longestPalindrome.length() < string.length()) {
                longestPalindrome = string;
            }
        }
        return longestPalindrome;
    }

    private static String helper(char[] ch, int left, int right) {
        String longestPalindrome = "";
        while ((left >= 0 && right <= ch.length - 1) && (ch[left] == ch[right])) {
            longestPalindrome = new String(Arrays.copyOfRange(ch, left, right + 1));
            left -= 1;
            right += 1;
        }
        return longestPalindrome;
    }

    public static void main(String[] args) {
        String s = "qwertyuioppoiuytrewq";
        System.out.println(findLargestPalindromeString(s));
    }

}
