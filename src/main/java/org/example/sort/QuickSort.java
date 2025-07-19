package org.example.sort;

import java.util.Arrays;

public class QuickSort {

    private static void quickSort(int[] arr) {
        helper(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void helper(int[] arr, int start, int end) {

        if (start >= end)
            return;

        int pivot = start;
        int left = start + 1;
        int right = end;

        while (right >= left) {
            if (arr[left] > arr[pivot] && arr[right] < arr[pivot]) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }

            if (arr[left] < arr[pivot]) {
                left += 1;
            }

            if (arr[right] > arr[pivot]) {
                right -= 1;
            }
        }
        int temp = arr[right];
        arr[right] = arr[pivot];
        arr[pivot] = temp;

        helper(arr, start, right - 1);
        helper(arr, right + 1, end);
    }

    public static void main(String[] args) {
        int[] arr = {99,4, 3, 6, 5, 7, 9, 2, 8, 1};
        quickSort(arr);

    }

}
