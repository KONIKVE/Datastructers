package org.example;

import java.util.Scanner;

public class SlidingWindow {

    // sliding window technique
    // O(n)
    private static int slidingWindowApproach(int[] arr, int size) {
        int MAX_SIZE = Integer.MIN_VALUE;
        int WINDOW_SIZE = 0;
        for (int i = 0; i < size; i++) {
            WINDOW_SIZE = WINDOW_SIZE + arr[i];
        }

        //base condition
        for (int i = size; i < arr.length; i++) {
            WINDOW_SIZE = WINDOW_SIZE + arr[i] - arr[i - size];
            if (WINDOW_SIZE > MAX_SIZE) {
                MAX_SIZE = WINDOW_SIZE;
            }
        }
        return MAX_SIZE;
    }


    //brute force approach
    // naive approach
    //0(n^2)
    private static int sumOfSubArray(int[] arr,int size){
        int MAX_SIZE = Integer.MIN_VALUE;
        for (int i = 0; i <= arr.length-size; i++) {
            int SUB_ARRAY_SIZE = 0;
            for (int j = i; j < i + size; j++) {
                SUB_ARRAY_SIZE = SUB_ARRAY_SIZE + arr[j];
            }
            if(SUB_ARRAY_SIZE > MAX_SIZE){
                MAX_SIZE = SUB_ARRAY_SIZE;
            }
        }
        return MAX_SIZE;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        System.out.println(" Please enter the sub array size :");
        Scanner sc = new Scanner(System.in);
        int subArraySize = sc.nextInt();
        System.out.println("Brute Force Approach : "+sumOfSubArray(arr,subArraySize));
        System.out.println("Sliding Window Approach : "+slidingWindowApproach(arr,subArraySize));
    }

}
