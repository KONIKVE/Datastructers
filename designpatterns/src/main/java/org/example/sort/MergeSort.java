package org.example.sort;

import java.util.Arrays;

public class MergeSort {

    public static void merge(
            int[] a, int[] l, int[] r, int left, int right) {
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            } else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }

    private static void merge(int[] arr,int[] l,int[] r){
        System.out.println("left:"+Arrays.toString(l));
        System.out.println("right:"+Arrays.toString(r));
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
            k++;
            i++;
        }

        while(j < r.length){
            arr[k] = r[j];
            k++;
            j++;
        }

    }

    private static void split(int[] arr) {
        System.out.println("subarray:"+Arrays.toString(arr));
        // base condition
        if (arr.length <= 1) {
            return;
        }

        int mid = arr.length / 2;
//        System.out.println("mid:" + mid);
        int[] l = new int[mid];
        int[] r = new int[arr.length - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = arr[i];
        }
        for (int i = mid; i < arr.length; i++) {
            r[i - mid] = arr[i];
        }
        split(l);
        split(r);
        merge(arr,l,r);
    }

    public static void main(String[] args) {
        int[] arr = {100,90,80,70,60,50,40,30,20,10};
        split(arr);
        System.out.println(Arrays.toString(arr));
    }
}
