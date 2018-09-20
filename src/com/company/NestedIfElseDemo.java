package com.company;

import java.util.Scanner;

public class NestedIfElseDemo {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        int da,ma,ya,de,me,ye, fine = 0;
        Scanner scanner = new Scanner(System.in);
        da = scanner.nextInt();
        ma = scanner.nextInt();
        ya = scanner.nextInt();
        scanner.nextLine();
        de = scanner.nextInt();
        me = scanner.nextInt();
        ye = scanner.nextInt();
        System.out.println(da + "/" + ma + "/" + ya + "&" + de + "/" + me + "/" + ye);
        if(ya > ye) {
            fine = 10000;
        } else if(ya == ye){
            if(ma > me) {
                fine = 500 * (ma - me);
            } else if(ma == me){
                if(da > de) {
                    fine = 15 * (da - de);
                }
            }
        }
        System.out.println(fine);
    }
}
