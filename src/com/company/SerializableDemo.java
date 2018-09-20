package com.company;

import java.io.*;
import java.util.Scanner;
/**** Observations ***
        If superclass is serializable then subclass is automatically serializable
        If a superclass is not serializable then subclass can still be serialized
Serialization: At the time of serialization, if any instance variable is inheriting from non-serializable
        superclass, then JVM ignores original value of that instance variable and save default value
        to the file.
De- Serialization: At the time of de-serialization, if any non-serializable superclass is present,
        then JVM will execute instance control flow in the superclass. To execute instance control
        flow in a class, JVM will always invoke default(no-arg) constructor of that class. So every non-serializable superclass must necessarily contain default constructor, otherwise we will get runtime-exception.
 If the superclass is serializable but we don’t want the subclass to be serialized : There is no direct
 way to prevent subclass from serialization in java. One possible way by which a programmer can achieve
 this is by implementing the writeObject() and readObject() methods in the subclass and needs
 to throw NotSerializableException from these methods.

 *** You can not have default constructor for child if parent has not default constructor

 default constructor is mandatory to be able to implement externalizable
 it is not required to have default constructor to implement serializable.
 If parent implements serializable child can be serializable automatically. Child need not implement Serializable explicitly*/
class Parent implements Serializable {
    protected int p;
    public Parent() {

    }
    public Parent(int p) {
        this.p = p;
    }
    public int getP() {
        return p;
    }
    private void writeObject(ObjectOutputStream os) throws IOException{
        os.defaultWriteObject();
    }
    private void readObject(ObjectInputStream is) throws ClassNotFoundException, IOException {
        is.defaultReadObject();
    }
}
class Child extends Parent implements Externalizable {
    private int c;
    private transient int t;
    public Child() {

    }
    public Child(int p, int c, int t) {
        super(p);
        this.c = c;
        this.t = t;
    }
    public int getC() {
        return c;
    }
    public int getT() {
        return t;
    }
    private void writeObject(ObjectOutputStream os) throws IOException{
        os.writeInt(t);
        os.defaultWriteObject();
    }
    private void readObject(ObjectInputStream is) throws ClassNotFoundException, IOException{
        t = is.readInt();
        is.defaultReadObject();
    }
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(c);
        out.writeInt(t);
    }

    public void readExternal(ObjectInput in)
            throws IOException, ClassNotFoundException {
        this.c = in.readInt();
        this.t = in.readInt();
    }
}


public class SerializableDemo {
    public static void main(String args[]) throws Exception{
        serializeParent();
        serializeChild();
    }

    public static void serializeParent() throws Exception{
        Parent p = new Parent(5);
        FileOutputStream fos = new FileOutputStream("temp.out");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(p);
        FileInputStream fis = new FileInputStream("temp.out");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Parent p1 = (Parent)ois.readObject();
        System.out.println(p1.getP());
    }
    public static void serializeChild() throws Exception{
        Child c = new Child(5,6, 7);
        FileOutputStream fos = new FileOutputStream("temp.out");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(c);
        FileInputStream fis = new FileInputStream("temp.out");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Child c1 = (Child)ois.readObject();
        System.out.println(c1.getP() + " " + c1.getC() + " " + c1.getT());
    }

}
