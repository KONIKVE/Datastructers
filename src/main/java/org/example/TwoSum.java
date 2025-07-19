package org.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    //o(n^2)
    public static void twoSumBruteForce(int[] array,int target){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if(i==j){
                    continue;
                }
                if(array[i] + array[j] == target){
                    System.out.println(array[i]+":::"+array[j]);
                }
            }
        }
    }

   // most recommended approach
    public int[] twoSumHashTableApproach(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        // Return an empty array if no solution is found
        return new int[]{};
    }

    //O(nlogn)
    public static void twoSum(int[] array, int target) {
//        Arrays.sort(array);
        for (int i = 0; i < array.length; i++) {
            int searchElement = target - array[i];
            if (searchElement > 0) {
                int searchIndex = Arrays.binarySearch(array, searchElement);
                System.out.println("searchIndex:"+searchIndex);
                if (searchIndex > 0) {
                    System.out.println(array[i] + "::::" + array[searchIndex]);
                }
            }
        }
    }

    //O(n)
    public static void twoSumApproach(int[] array, int target) {
        int lowValue = array[0] + array[array.length - 1];
        int highValue = array[array.length - 2] + array[array.length - 1];
        if (!(target >= lowValue && target <= highValue)) {
            System.out.println(":::::There is no chance to form target by adding two numbers sum::::::"+target);
            return;
        }
        int i = 0;
        int j = array.length-1;
        while (i <= j) {
            if(array[i]+array[j] == target){
                System.out.println("index ::::::::i->"+i+"::::::::::j->"+j);
                break;
            }
            else if(array[i]+array[j] < target){
                i++;
            }
            else if(array[i]+array[j] > target){
                j--;
            }
        }
    }

    //O(n)
    private static void twoSumWithHashTable(int[] arr, int target) {
        System.out.println(Arrays.toString(arr));
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int result = target - arr[i];
            if (map.containsKey(result)) {
                int index = map.get(result);
                System.out.println(i + "::::::" + index);
                return;
            }
            map.put(arr[i], i);
        }
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9};
        int target = 10;
        twoSumWithHashTable(array,target);
    }

}
