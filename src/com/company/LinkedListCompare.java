package com.company;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class LinkedListCompare {
    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }
    // Complete the compareLists function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static boolean compareLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        while(head1 != null && head2 != null) {
            if(head1.data != head2.data) {
                break;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        if(head1 != null || head2 != null) {
            return false;
        } else {
            return true;
        }

    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        SinglyLinkedList list1 = createList(10);
        SinglyLinkedList list2 = createList(10);
        System.out.println("Lists are equal : " + compareLists(list1.head, list2.head));

        SinglyLinkedList list3 = createList(10);
        SinglyLinkedList list4 = createList(0);
        System.out.println("Lists are equal : " + compareLists(list3.head, list4.head));

        SinglyLinkedList list5 = createList(10);
        SinglyLinkedList list6 = createList(20);
        System.out.println("Lists are equal : " + compareLists(list5.head, list6.head));
    }

    public static SinglyLinkedList createList(int size) {
        SinglyLinkedList list = new SinglyLinkedList();
        for (int i = 0; i < size; i++) {
            list.insertNode(i+10);
        }

        return list;
    }
}

