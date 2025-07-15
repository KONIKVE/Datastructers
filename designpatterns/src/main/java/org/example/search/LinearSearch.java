package org.example.search;

public class LinearSearch {

    private static int linearSearch(int[] arr,int target){

        for (int i = 0; i < arr.length ; i++) {
            if(arr[i] == target){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(linearSearch(new int[]{10,20,30,60,78,22,11,5,21},11));
    }

}
