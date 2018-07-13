package com.company;

import java.util.Arrays;

/**
 * Created by lakshmik on 13/7/18.
 */
public class ReverseArray {
    private static void reverseArray(int[] arr) {
        System.out.println("Given array : ");
        printArray(arr);
        System.out.println("Reversed array : ");
        printArray(reverse(arr));
    }
    private static int[] reverse(int[] arr) {
        if(arr.length == 0) {
            return arr;
        }
        int length = arr.length;
        for(int i = 0; i < length/2 ; i++) {
            swapElements(arr, i, length-i-1);
        }

        return arr;
    }

    private static void swapElements(int[] arr, int index1, int index2) {
        arr[index1] = arr[index1] + arr[index2];
        arr[index2] = arr[index1] - arr[index2];
        arr[index1] = arr[index1] - arr[index2];
    }

    private static void printArray(int[] arr) {
        int length = arr.length;
        if(length == 0) {
            System.out.println("[]");
        } else {
            StringBuffer arrString = new StringBuffer("[");
            for(int i =0 ; i < length ; i++) {
                arrString.append((i == 0 ? "" : ", ") + arr[i]);
            }
            arrString.append("]");
            System.out.println(arrString);
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {-1,2,-3,-4,2,6};
        reverseArray(arr1);
        reverseArray(arr2);
    }
}
