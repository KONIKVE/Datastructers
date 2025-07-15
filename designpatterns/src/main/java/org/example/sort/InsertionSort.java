package org.example.sort;

import java.util.Arrays;

public class InsertionSort {
    private static void insertionSort(int[] arr){

        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int last = i - 1;
            while(last >= 0 && key < arr[last]){
                arr[last+1] = arr[last];
                last = last - 1;
            }
            arr[last + 1] = key ;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr ={6,5,7,4,8,3,9,2,1};
        insertionSort(arr);
    }
}
