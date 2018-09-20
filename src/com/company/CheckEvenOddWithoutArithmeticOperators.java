package com.company;

public class CheckEvenOddWithoutArithmeticOperators {
    public static void main(String rags[]) {
        int i = -7;
        String binary = Integer.toBinaryString(i);
        if(binary.charAt(binary.length()-1) == '0') {
            System.out.println("Even");
        } else {
            System.out.println("Odd");
        }
    }
}
