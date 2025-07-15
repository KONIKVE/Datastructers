package org.example.sort;

import java.util.Arrays;

public class BubbleSort {

    public static int[] bubbleSort(int[] arr){
        int iter = 0;
        for (int iteration = 0; iteration < arr.length; iteration++) {
            for (int i = 0; i < arr.length - 1 - iteration ; i++) {
                    if (arr[i] > arr[i + 1]) {
                        int temp = arr[i];
                        arr[i] = arr[i + 1];
                        arr[i + 1] = temp;
                    }
                    System.out.println(Arrays.toString(arr)+":"+ (++iter));
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {6,2,9,1,7,5,3,4,8}; //9
        System.out.println(Arrays.toString(bubbleSort(arr)));
    }

}
