package com.company;

import java.util.Scanner;

public class LinkedListDemo2 {
    static class Node {
        private int data;
        private Node next;
        public Node(int data) {
            this(data, null);
        }
        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
    static class SinglyLinkedListAddToTail {
        private Node head;
        private Node tail;
        public SinglyLinkedListAddToTail() {
            head = null;
            tail = null;
        }
        public void insertData(int data){
            Node node = new Node(data);
            if(head == null) {
                head = node;
            } else {
                tail.next = node;
            }
            tail = node;
        }
        public static void printList(Node head) {
            while(head != null) {
                System.out.println(head.data);
                head = head.next;
            }
        }

        public static void printMiddleElement(Node head) {
            Node temp = head;
            while(temp != null && temp.next != null) {
                head = head.next;
                temp = temp.next.next;
            }
            if(head != null) {
                System.out.println("Middle item is : " + head.data);
            }
        }

        public static void reverseList(Node head) {
            Node curr = head;
            Node prev = null;
            Node next = null;
            while(curr != null) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            head = prev;
            printList(head);
        }
    }
    static class SinglyLinkedListAddToHead {
        private Node head;
        public SinglyLinkedListAddToHead() {
            head = null;
        }
        public void insertData(int data){
            Node node = new Node(data, head);
            head = node;
        }
        public static void printList(Node head) {
            while(head != null) {
                System.out.println(head.data);
                head = head.next;
            }
        }

        public static void printMiddleElement(Node head) {
            Node temp = head;
            while(temp != null && temp.next != null) {
                head = head.next;
                temp = temp.next.next;
            }
            if(head != null) {
                System.out.println("Middle item is : " + head.data);
            }
        }

        public static void reverseList(Node head) {
            Node curr = head;
            Node prev = null;
            Node next = null;
            while(curr != null) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            head = prev;
            printList(head);
        }
    }

    private static Scanner scan = new Scanner(System.in);

    public static void main(String rags[]) {
        int n;
        System.out.println("Input list size");
        n = scan.nextInt();
        SinglyLinkedListAddToTail listAddingAtTail = new SinglyLinkedListAddToTail();
        SinglyLinkedListAddToHead listAddingAtHead = new SinglyLinkedListAddToHead();
        System.out.println("Insert list elements");
        int data;
        for(int i = 0; i < n; i++) {
            data = scan.nextInt();
            listAddingAtTail.insertData(data);
            listAddingAtHead.insertData(data);
        }
        System.out.println("List operations with new node at head");
        listAddingAtHead.printList(listAddingAtHead.head);
//        listAddingAtHead.printMiddleElement(listAddingAtHead.head);
//        listAddingAtHead.reverseList(listAddingAtHead.head);
        System.out.println("List operations with new node at tail");
        listAddingAtTail.printList(listAddingAtTail.head);
//        listAddingAtTail.printMiddleElement(listAddingAtTail.head);
//        listAddingAtTail.reverseList(listAddingAtHead.head);
    }
}
