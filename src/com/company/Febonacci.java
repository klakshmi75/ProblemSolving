package com.company;

public class Febonacci {
    public static void main(String args[]) {

    }
    public static int nthFeboNonRecursive(int n) {
        int a = 0, b = 1, c = 0;
        if(n == 1) {
            return 0;
        } else if(n == 2) {
            return 1;
        }
        for(int i = 3; i <= n ; i++) {
            c= a+b;
            a = b;
            b = c;
        }
        return c;
    }

    public static int nthFeboRecursive(int n, int a, int b) {
        if(n == 0) {
            return a;
        }
        if(n == 1) {
            return b;
        }
        return nthFeboRecursive(n-1, b, a+b);
    }
}
