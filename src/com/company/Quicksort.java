package com.company;

import java.util.Arrays;

public class Quicksort {
    private static int[] arr = {6, 5, 3, 8, 8, 2};

    private static void quickSort(int[] arr, int low, int high) {
        if (arr == null || arr.length == 0)
            return;

        if (low >= high)
            return;

        // pick the pivot
        int middle = low + (high - low) / 2;
        int pivot = arr[middle];

        // make left < pivot and right > pivot
        int i = low, j = high;
        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }

            while (arr[j] > pivot) {
                j--;
            }

            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        // recursively sort two sub parts
        if (low < j)
            quickSort(arr, low, j);

        if (high > i)
            quickSort(arr, i, high);
    }

    public static void main(String args[]) {
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
        Integer i1 = new Integer("5");
        Integer i2 = new Integer(i1);
        Integer i3 = 5;
        System.out.println(i1 == i2);
        System.out.println(i1 == i3);
    }
}