package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUsageExamples {
    public static void main(String rags[]) {
        String str1 = "345E8";
        Pattern pat = Pattern.compile("\\d+E*\\d+");
        Matcher mat = pat.matcher(str1);
        if(mat.matches()) {
            System.out.println("Matched");
        } else {
            System.out.println("Not matched");
        }
        // should contain only lowercase and less than 20 chars
        String firstName = "july";
        // should allow only small case, @ and dot.
        String emailID = "lakshmi.k@gmail.com";

        if(firstName.matches("[a-z]{1,21}")) {
            System.out.print("firstName matches");
        } else {
            System.out.print("firstName does not match.");
        }

        if(emailID.matches("[a-z,.]+@gmail(.[a-z]+)+") && emailID.length() <= 50) {
            System.out.println("emailId matches");
        } else {
            System.out.println("emailId does not match.");
        }
    }
}
