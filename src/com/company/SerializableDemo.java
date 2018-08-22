package com.company;

import java.io.*;
import java.util.Scanner;

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
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(c);
        out.writeInt(t);
    }

    @Override
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
//        Integer i = 127;
//        Integer j = 127;
//        System.out.println(i == j);
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
