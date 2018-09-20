package com.company;

import java.util.Scanner;

public class PrimeCheck {
    public static void main(String args[]) {
        int[] numbers;
        int size;
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();

        numbers = new int[size];
        for(int i = 0; i < size;i++) {
            numbers[i] = sc.nextInt();
        }

        labelOuter: for(int i = 0; i<size;i++) {
            int num = numbers[i];
            if(num < 2) {
                System.out.println("Not prime");
            } else if(num == 2){
                System.out.println("Prime");
            } else {
                for(int j = 2; j <= num/2 ; j++) {
                    if(num%j == 0) {
                        System.out.println("Not prime");
                        continue labelOuter;
                    }
                }
                System.out.println("Prime");
            }
        }
    }
}
