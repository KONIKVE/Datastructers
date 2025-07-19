package org.example;

import java.util.Arrays;

public class ReverseString {

    public static void main(String[] args) {
        String s ="venkatkoniki";
        char[] arr = s.toCharArray();
        for (int i = 0,j=arr.length-1; i <= j  ; i++,j--) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        System.out.println(s);
        System.out.println(Arrays.toString(arr));
    }

}
