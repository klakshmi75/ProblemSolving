package com.company;
interface Interface {
    int i = 0;
    static void display() {
        // can not assign a value to a final variable
        // i++;
        System.out.println("static interface method");
    };
}

class ImplementInterface implements Interface {
    public ImplementInterface() {
    }
    public void display() {
        System.out.println("i=" + i);
    }
}
public class InterfaceDemo {
    public static void main(String rags[]) {
        ImplementInterface i = new ImplementInterface();
        i.display();
    }
}
