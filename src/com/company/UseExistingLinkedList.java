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
        linkedList.add(5);
        linkedList.add(6);
        linkedList.add(7);
        linkedList.add(8);
        for(Integer i: linkedList) {
            System.out.println(i);
        }
        System.out.println("peek=" + linkedList.peek());
        for(Integer i: linkedList) {
            System.out.println(i);
        }
        System.out.println("poll=" + linkedList.poll());
        for(Integer i: linkedList) {
            System.out.println(i);
        }
        System.out.println("pollLast=" + linkedList.pollLast());
        for(Integer i: linkedList) {
            System.out.println(i);
        }
        System.out.println("pollLast=" + linkedList.pollLast());
        for(Integer i: linkedList) {
            System.out.println(i);
        }
        System.out.println("element=" + linkedList.element());
        for(Integer i: linkedList) {
            System.out.println(i);
        }
    }
}
