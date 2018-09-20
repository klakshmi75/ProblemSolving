package com.company;

// demo to test if we can catch stack overflow error
public class CatchErrorDemo {
    public static void main(String rags[]) {
        try {
            recurseive(10);
        } catch(StackOverflowError error) {
            System.out.println("Stach overflow error occured");
        }
        System.out.println("Recovered from stack overfloe error and exiting normally");
    }

    public static int recurseive(int i) {
        System.out.println(i);
        return i*recurseive(i-1);
    }
}
