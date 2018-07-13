package com.company;

/**
 * Created by lakshmik on 12/7/18.
 */
public class FizzBuzz {
    public static void solve() {
        for(int i = 1; i < 101 ; i ++) {
            boolean notDivisible = true;
            if(i%3 == 0){
                System.out.print("Fizz");
                notDivisible = false;
            }
            if(i%5 == 0) {
                System.out.print("Buzz");
                notDivisible = false;
            }
            if(notDivisible) {
                System.out.print(i);
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        solve();
    }
}
