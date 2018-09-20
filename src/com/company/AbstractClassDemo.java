package com.company;

import java.util.Scanner;

// abstract class can implement cloneable.
// the subclass is also eligible for cloning
abstract class Book implements Cloneable {
    String title;
    String author;
    // Even though we can instantiate abstract class we can have a constructor
    // as it can hold state
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    // If we don't override Object's clone()
    // we will get compile time error saying
     // Object's clone() method has protected access
    public Book clone() throws CloneNotSupportedException{
        return (Book)super.clone();
    }

    abstract void display();
}
class MyBook extends Book {
    int price;
    public MyBook(String title, String author, int price) {
        super(title, author);
        this.price = price;
    }
    public void display() {
        System.out.printf("Title: %s\n", title);
        System.out.printf("Author: %s\n", author);
        System.out.printf("Price: %d", price);
    }
}
public class AbstractClassDemo {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();
        String author = scanner.nextLine();
        int price = scanner.nextInt();
        scanner.close();

        Book book = new MyBook(title, author, price);
        book.display();

        Book cloned = book.clone();
        cloned.display();
    }
}