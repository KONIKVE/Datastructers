package org.example.sort;

import java.util.Arrays;

public class SelectionSort {

    private static int[] selectionSort(int[] arr){
        for (int iteration = 0; iteration < arr.length-1 ; iteration++) {
            int min = iteration;
            for (int i = iteration+1; i < arr.length; i++) {
                if (arr[i] < arr[min]) {
                    min = i;
                }
            }
            int temp =arr[iteration];
            arr[iteration] = arr[min];
            arr[min] = temp;
            System.out.println(Arrays.toString(arr));
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {7,8,9,6,5,4,3,2,1};
        System.out.println(Arrays.toString(selectionSort(arr)));
    }

}
