package com.company;

import java.io.IOException;

public class TryCatchFinallyDemo {
    public static void main(String...args) {
        for(int i =0; i <5 ; i++) {
            for(int j = 0; j< 5; j++) {
                System.out.println("i=" + i + ", j=" + j);
                System.out.println("i*j=" + callTryCatchDemo(i,j));
            }
        }
    }

    public static int callTryCatchDemo(int i, int j) {
        try {
            if(j ==0) {
                throw new IOException("InvalidException");
            }
            System.out.println("Try block before returning");
            return i/j;
        } catch(Exception e) {
            System.out.println("Catch block");
        } finally {
            System.out.println("Finally block");
        }
        return 0;
    }
}
