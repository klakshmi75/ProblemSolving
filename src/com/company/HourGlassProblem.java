package com.company;

/**
 * Created by lakshmik on 9/7/18.
 */
public class HourGlassProblem {
    private static int[][] arr = new int[6][6];
    static {
        for(int i = 0; i < 6 ; i ++) {
            for(int j = 0; j < 6 ; j++) {
                arr[i][j] = i * j;
            }
        }
        for(int i = 0; i < 6 ; i ++) {
            for(int j = 0; j < 6 ; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.print("\n");
        }
    }

    public static void main(String rags[]) {
        System.out.print(getMaxHourGlassSum(arr));
    }

    public static int getMaxHourGlassSum(int[][] arr) {
        int maxSum = 0;
        boolean firstSum = true;
        int hourGlassSum;
        for(int i =0; i< 4 ; i++) {
            for(int j = 0; j < 4 ; j++) {
                hourGlassSum = getHourGlassSum(arr, i, j);
                if(firstSum) {
                    maxSum = hourGlassSum;
                    firstSum = false;
                } else if(hourGlassSum > maxSum) {
                    maxSum = hourGlassSum;
                }

            }
        }
        return maxSum;
    }

    public static int getHourGlassSum(int[][] arr, int rowIndex, int colIndex) {
        int sum = 0;
        for(int j = colIndex ; j < colIndex + 3 ; j ++) {
            sum += arr[rowIndex][j];
        }
        sum += arr[rowIndex +1][colIndex+1];
        for(int j = colIndex ; j < colIndex + 3 ; j ++) {
            sum += arr[rowIndex+2][j];
        }
        return sum;
    }
}
