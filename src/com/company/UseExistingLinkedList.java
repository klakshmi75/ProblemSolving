package com.company;

import java.util.LinkedList;
import java.util.List;

public class UseExistingLinkedList {
    public static void main(String str[]) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        for(Integer i: linkedList) {
            System.out.println(i);
        }
        int i1 = linkedList.peek();
        for(Integer i: linkedList) {
            System.out.println(i);
        }
        int i2 = linkedList.pollLast();
        for(Integer i: linkedList) {
            System.out.println(i);
        }
    }
}
