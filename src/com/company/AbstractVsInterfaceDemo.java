package com.company;
interface Interface {
    int i = 0;
    static void display() {
        System.out.println("static interface method");
    };
}
abstract class AbstractClass {

}
class ExtendAbstract extends AbstractClass {

}
class ImplementInterface implements Interface {
    public ImplementInterface() {
    }
    public void display() {
        System.out.println("i=" + i);
    }
}
public class AbstractVsInterfaceDemo {
    public static void main(String rags[]) {
        AbstractClass obj = new ExtendAbstract();
        System.out.println(obj);
        ImplementInterface i = new ImplementInterface();
        i.display();
    }
}
