package com.company;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lakshmik on 13/7/18.
 */
public class NumberToWords {
    private static Map<Integer, String> placeValueMap = new HashMap<>();
    private static Map<Integer, String> unitMap = new HashMap<>();
    private static Map<Integer, String> tensMap = new HashMap<>();
    static {
        placeValueMap.put(1, "");
        placeValueMap.put(2, "thousand");
        placeValueMap.put(3, "million");
        placeValueMap.put(4, "billion");

        unitMap.put(1, "one");
        unitMap.put(2, "two");
        unitMap.put(3, "three");
        unitMap.put(4, "four");
        unitMap.put(5, "five");
        unitMap.put(6, "six");
        unitMap.put(7, "seven");
        unitMap.put(8, "eight");
        unitMap.put(9, "nine");

        tensMap.put(1, "ten");
        tensMap.put(2, "twenty");
        tensMap.put(3, "thirty");
        tensMap.put(4, "forty");
        tensMap.put(5, "fifty");
        tensMap.put(6, "sixty");
        tensMap.put(7, "sventy");
        tensMap.put(8, "eightty");
        tensMap.put(9, "ninety");
    }
    // accepts upto 3 digits
    private static String getWordsFor3DigtNumber(int num) {
        if(num > 999) {
            return "Number exceeds max limit";
        } else {
            StringBuffer sbf = new StringBuffer("");
            if(num/100 > 0) {
                sbf.append(" " + unitMap.get(num/100) + " hundred");
                num = num%100;
            }
            if(num/10 > 0) {
                sbf.append(" " + tensMap.get(num/10));
                num = num %10;
            }
            if(num > 0) {
                sbf.append(" " + unitMap.get(num));
            }
            return sbf.toString();
        }
    }

    public static String getWords(int number) {
        if(number == 0) {
            return "Zero";
        }
        StringBuffer sbf = new StringBuffer("");
        String sign = "";
        int placeValueTracker = 1;
        int numComponent;
        if(number < 0) {
            number = number * -1;
            sign = "minus";
        }
        while(number > 0) {
            numComponent =  number % 1000;
            number = number / 1000;
            sbf.insert(0, getWordsFor3DigtNumber(numComponent) + " " + placeValueMap.get(placeValueTracker) + " ");
            placeValueTracker++;
        }
        sbf.insert(0, sign + " ");
        return sbf.toString();
    }

    public static void main(String[] args) {
        // number should be between -2,147,483,648 and 2,147,483,647
        System.out.println(getWords(-1201190909));
        System.out.println(getWords(70000));
    }
}
