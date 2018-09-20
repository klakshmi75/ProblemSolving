package com.company;

public class PalindromeTest {
    public static void main(String args[]) {
        System.out.println("abcddcba=" + isPalindrome("abcddcba"));
        System.out.println("abcdfdcBA="+ isPalindrome("abcdfdcba"));
        System.out.println("abcdfdcfa="+ isPalindrome("abcdfdcfa"));
        System.out.println("f="+ isPalindrome("f"));
        System.out.println("aa="+ isPalindrome("aa"));
    }
    public static boolean isPalindrome(String str) {
        String tmp = str.toLowerCase();
        int len = str.length();
        for(int i = 0; i <= len/2 ; i++ ) {
            if(str.charAt(i) != str.charAt(len-1-i)) {
                return false;
            }
        }
        return true;
    }
}
