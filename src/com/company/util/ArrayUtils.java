package com.company.util;

public class ArrayUtils {
    public static void printArray(int[] arr) {
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
    public static void swapArrItems(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
