package org.example;

public class ArrayUtils {



    private static  void printAlternative(int[] arr){
        for (int i = 1; i < arr.length; i=i+2) {
            System.out.println(arr[i]);
        }
    }

    private static int linearSearch(int[] arr,int target){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == target){
                return i;
            }
        }
        return -1;
    }

    private static int larget(int[] arr){
        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > largest)
                largest = arr[i];
        }
        return largest;
    }

    private static int secondLargestElement(int[] arr){
        /*int firstLarge = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > firstLarge) {
                firstLarge = arr[i];
            }
        }
        System.out.println(firstLarge);
        int secondLarge = arr[0] != firstLarge ? arr[0] : Integer.MIN_VALUE ;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] > secondLarge && arr[i] != firstLarge){
                secondLarge = arr[i];
            }
        }

        System.out.println(secondLarge);
        return secondLarge;*/



        int firstLarge = Integer.MIN_VALUE;
        int secondLarge = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {

            if(arr[i] > firstLarge){
                secondLarge = firstLarge;
                firstLarge = arr[i];
            }

            else if(arr[i] > secondLarge && arr[i] != firstLarge){
                secondLarge = arr[i];
            }
        }

        System.out.println(firstLarge+":::::"+secondLarge);
        return secondLarge;


    }

    public static void main(String[] args) {
        int[] arr1 = {0,1,2,3,4,5,6,100,7,8,9,10};
        //System.out.println(linearSearch(arr1,1));
//        System.out.println(larget(arr1));
        secondLargestElement(arr1);
    }
}
