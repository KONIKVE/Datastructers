package org.example;

public class PalindromeString {

    public static void main(String[] args) {
        String s = "abcdefghhgfedcba";
        char[] arr = s.toCharArray();
        for (int i = 0,j= arr.length-1; i<=j ; i++,j--) {
            if(arr[i] != arr[j]){
                System.out.println("Not palindrome");
                return;
            }
            System.out.println("i:"+i+"j:"+j);
            System.out.println("i:"+arr[i]+"j:"+arr[j]);
        }
        System.out.println("Given String a  palindrome:"+s);
    }
}
