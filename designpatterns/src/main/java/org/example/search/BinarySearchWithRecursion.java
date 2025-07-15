package org.example.search;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearchWithRecursion {

    private static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        return helper(arr, target, low, high);
    }

    private static int helper(int[] arr, int target, int low, int high) {
       // base condition
        if (low > high) {
            return -1;
        }

        int middle = (low + high) / 2;
        int middleElement = arr[middle];

        if (middleElement == target) {
            return middle;
        } else if (middleElement > target) {
            high = middle - 1;
            return helper(arr, target, low, high);
        } else if (middleElement < target) {
            low = middle + 1;
            return helper(arr, target, low, high);
        }
        return -1;
    }


    public static void main(String[] args) {
       int[] arr = {5,12,355,23,45,67,89,32,4,23,21,65,56,0,99,9};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        Scanner scanner = new Scanner(System.in);
        System.out.println(binarySearch(arr,scanner.nextInt()));
    }

}
