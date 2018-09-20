package com.company;

import java.util.HashSet;
import java.util.Set;

public class OptimizesWayToFindIfStringHasDuplicates {
    public static void main(String rags[]) {
        String str = "abchdretsikfbg";
        Set<Character> charSet = new HashSet<>();
        boolean found = false;
        for(int i = 0 ; i < str.length();i++) {
            System.out.println(str.charAt(i));
            if(charSet.add(str.charAt(i)) == false) {
                found = true ;
                break;
            }
        }
        if(found) {
            System.out.println("Duplicate found");
        } else {
            System.out.println("No duplicates found");
        }
    }
}
