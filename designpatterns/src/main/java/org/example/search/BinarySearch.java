package org.example.search;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BinarySearch {

    private static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        // base condition
        while (low <= high) {
            int medium = (low + high) / 2;
            System.out.println("medium:"+medium);
            if(arr[medium] == target){
                return medium;
            } else if (arr[medium] > target) {
                high = medium -1;
            }else if(arr[medium] < target){
                low = medium + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {2,5,1,7,3,65,33,11,77,45,23,89,63,24,18,4,90};
        Arrays.sort(arr);
        System.out.println("array:"+Arrays.toString(arr));
        Scanner scanner = new Scanner(System.in);
        System.out.println(binarySearch(arr,scanner.nextInt()));
    }

}
