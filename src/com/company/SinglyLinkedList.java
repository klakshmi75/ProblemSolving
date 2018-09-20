package com.company;

import java.util.Scanner;

public class SinglyLinkedList {
    Node head;
    Node tail;
    static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            next = null;
        }
    }
    public void inserNodeAtHead(int data){
        Node node = new Node(data);
        node.next = head;
        head = node;
    }
    public void insertNodeAtTail(int data){
        Node node = new Node(data);
        if(head == null) {
            head = node;
        } else {
            tail.next = node;
        }
        tail = node;
    }
    public void printList(Node head) {
        Node tmp = head;
        while(tmp != null) {
            System.out.println(tmp.data);
            tmp = tmp.next;
        }
    }

    // Actual problem solving
    // Reverse list
    public Node reverseList(Node head) {
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
        return head;
    }

    // Find middle element
    public void findMiddleElement(Node node) {
        Node head = node;
        Node temp = node;
        while(temp != null && temp.next != null) {
            head = head.next;
            temp = temp.next.next;
        }
        if(head != null) {
            System.out.println("Middle item is : " + head.data);
        }
    }

    // Just print the list in reverse order. Do not reverse the actual list.
    public void printReverseListRecursive(Node head) {
        if(head != null) {
            if(head.next != null) {
                printReverseListRecursive(head.next);
            }
            System.out.println(head.data);
        }
    }

    // FindAndRemoveLoop
    public boolean findAndRemoveLoop(Node node) {
        Node slow=node, fast=node;
        while(slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                removeLoop(slow, node);
                return true;
            }
        }
        return false;
    }

    // Function to remove loop
    void removeLoop(Node loop, Node curr) {
        Node ptr1 = null, ptr2 = null;

        /* Set a pointer to the beging of the Linked List and
         move it one by one to find the first node which is
         part of the Loop */
        ptr1 = curr;
        while (1 == 1) {

            /* Now start a pointer from loop_node and check if it ever
             reaches ptr1 */
            ptr2 = loop;
            while (ptr2.next != loop && ptr2.next != ptr1) {
                ptr2 = ptr2.next;
            }

            /* If ptr2 reahced ptr1 then there is a loop. So break the
             loop */
            if (ptr2.next == ptr1) {
                break;
            }

            /* If ptr2 did't reach ptr1 then try the next node after ptr1 */
            ptr1 = ptr1.next;
        }

        /* After the end of loop ptr2 is the last node of the loop. So
         make next of ptr2 as NULL */
        ptr2.next = null;
    }

    public static Node removeDuplicates(Node head) {
        if(head == null) {
            return head;
        }

        Node prev = head;
        Node tmp = head.next;
        while(prev != null && tmp != null) {
            if(prev.data == tmp.data) {
                prev.next = tmp.next;
            } else {
                prev = prev.next;
            }
            tmp = tmp.next;
        }
        return head;
    }

    // Testing list methods
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
//        testListFunctions();
//        testListForLoop();
        testListToRemoveDuplicates();
    }

    public static void testListFunctions() {
        SinglyLinkedList list = new SinglyLinkedList();

        for (int i = 0; i < 4; i++) {
            int item = scanner.nextInt();
            list.insertNodeAtTail(item);
        }

        list.printList(list.head);
        list.printReverseListRecursive(list.head);
        list.printList(list.head);
        System.out.println("Middle element before reversing the list");
        list.findMiddleElement(list.head);
        list.head = list.reverseList(list.head);
        System.out.println("Middle element after reversing the list");
        list.findMiddleElement(list.head);

        scanner.close();
    }

    public static void testListForLoop() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(5);
        list.head.next.next.next.next.next = new Node(6);
        list.printList(list.head);
        System.out.println("Loop exists test before creating loop: " + list.findAndRemoveLoop(list.head));

        // create loop by pointing the next of last node to third node.
        // loop start is node with data 3.
        list.head.next.next.next.next.next.next = list.head.next.next;
        // This will enter infinite loop
        // list.printList(list.head);
        System.out.println("Loop exists test after creating loop: " + list.findAndRemoveLoop(list.head));

        System.out.println("Loop exists test after removing loop: " + list.findAndRemoveLoop(list.head));
    }

    public static void testListToRemoveDuplicates(){
        Scanner sc=new Scanner(System.in);
        SinglyLinkedList list = new SinglyLinkedList();
        int T=sc.nextInt();
        while(T-->0){
            int ele=sc.nextInt();
            list.insertNodeAtTail(ele);
        }
        System.out.println("Before removing duplicates");
        list.printList(list.head);
        list.head = removeDuplicates(list.head);
        System.out.println("After removing duplicates");
        list.printList(list.head);
    }
}

