package com.company;

import java.util.Scanner;

public class DecimalToBinaryAndMaxConsecutiveInts {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int given = n;
        int rem;
        int consecOnes = 0;
        int max = 0;
        // use this only if you want to print binary number along with max consecutive ones.
        StringBuilder sb = new StringBuilder();
        while (n > 0){
            rem = n%2;
            n = n/2;
            sb.insert(0, rem + "");
            if(rem == 1) {
                if(max == 0) {
                    max = 1;
                }
                consecOnes++;
            } else {
                if(consecOnes > max) {
                    max = consecOnes;
                }
                consecOnes = 0;
            }
        }
        if(consecOnes > max) {
            max = consecOnes;
        }
        System.out.println("Binary of " + given + " is " + sb.toString() + " and max consecutive ints is " + max);
        scanner.close();
    }
}
