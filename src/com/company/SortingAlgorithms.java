package com.company;

import com.company.util.ArrayUtils;

import java.util.Arrays;

public class SortingAlgorithms {
    private static int[] arrOriginal = {1,-2,3,4,-1,5,8,6};
    private static int n = arrOriginal.length;

    private static void bubbleSort() {
        int[] arr = Arrays.copyOf(arrOriginal, n);
        boolean swapped;
        for(int i=0 ; i<n;i++) {
            swapped = false;
            for(int j = 0; j<n-i-1;j++) {
                if(arr[j] > arr[j+1]) {
                    ArrayUtils.swapArrItems(arr, j, j+1);
                    swapped = true;
                }
            }
            if(!swapped) {
                break; // break the loop since all the elements are already sorted
            }
        }
        ArrayUtils.printArray(arr);
    }

    private static void insertionSort() {
        int[] arr = Arrays.copyOf(arrOriginal, n);
        for(int i=1 ; i<n ; i++) {
            int key = arr[i];
            int j = i-1;
            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j>=0 && arr[j] > key)
            {
                arr[j+1] = arr[j];
                j = j-1;
            }
            arr[j+1] = key;
        }
        ArrayUtils.printArray(arr);
    }

    private static void quickSort() {
        int[] arr = Arrays.copyOf(arrOriginal, n);
        quickSortRec(arr, 0, n-1);
        ArrayUtils.printArray(arr);
    }

    private static void quickSortRec(int[] arr, int low, int high) {
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
            quickSortRec(arr, low, j);

        if (high > i)
            quickSortRec(arr, i, high);
    }


    public static void main(String args[]) {
        bubbleSort();
        insertionSort();
        quickSort();
    }
}
