package com.company;

import java.io.*;
import java.util.Scanner;

public class DeleteSinglyLinkedListNodeAtGivenPosition {
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

        public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, PrintStream ps) throws IOException {
            while (node != null) {
                ps.write(String.valueOf(node.data).getBytes());

                node = node.next;

                if (node != null) {
                    ps.write(sep.getBytes());
                }
            }
        }
    static SinglyLinkedListNode deleteNode(SinglyLinkedListNode head, int position) {
        if(head == null) {
            return head;
        }
        SinglyLinkedListNode tmp = head;
        SinglyLinkedListNode prev = head;
        int i = 0;
        while(i < position && tmp.next != null) {
            prev = tmp;
            tmp = tmp.next;
            i++;
        }
        if(i == position) {
            if(position == 0) {
                head = head.next;
            } else {
                prev.next = tmp.next;
            }
        }
        return head;
    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        SinglyLinkedList llist = new SinglyLinkedList();

        int llistCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < llistCount; i++) {
            int llistItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            llist.insertNode(llistItem);
        }

        int position = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        SinglyLinkedListNode llist1 = deleteNode(llist.head, position);

        printSinglyLinkedList(llist1, " ", System.out);

        scanner.close();
    }
}
