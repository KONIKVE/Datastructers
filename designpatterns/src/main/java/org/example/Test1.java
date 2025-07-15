package org.example;

import java.util.Arrays;

public class Test1 {

    private static void split(int[] arr){
        System.out.println(Arrays.toString(arr));
        //base condition
        if(arr.length <= 1){
            return ;
        }
        int mid = arr.length / 2;
        int[] l = new int[mid];
        int[] r = new int[arr.length - mid];

        for (int i = 0; i < mid; i++) {
             l[i] = arr[i];
        }
        for (int i = mid; i < arr.length; i++) {
            r[i-mid] = arr[i];
        }
        split(l);
        split(r);
        merge(arr,l,r);
    }



    private static void merge(int[] arr,int[] l,int[] r){
        int i = 0,j=0,k=0;

        while(i < l.length && j < r.length){
            if(l[i] <= r[j]){
                arr[k] = l[i];
                i++;
            }else{
                arr[k] = r[j];
                j++;
            }
            k++;
        }

        while(i < l.length){
            arr[k] = l[i];
            i++;
            k++;
        }

        while(j < r.length){
            arr[k] = r[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] arr = {100,90,80,70,60,50,40,30,20,10};
        split(arr);
        System.out.println(Arrays.toString(arr));
    }

}
