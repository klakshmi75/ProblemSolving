package com.company;

public class CloneDemo implements Cloneable{
    private static int s = 4;
    private int i = 5;
    private CloneDemo() {

    }

    public CloneDemo clone() { // throws CloneNotSupportedException{ don't use this. instead catch this in method
        CloneDemo clone = null;
        try {
            clone = (CloneDemo) super.clone();
            clone.i =6;
        }  catch(CloneNotSupportedException e) {
            // log ex
        }
        return clone;
    }

    public int getData() {
        return i;
    }

    public static int getS() {
        return s;
    }

    public static void setS(int s1) {
        s = s1;
    }

    public static void main(String rags[]) throws CloneNotSupportedException {
        CloneDemo d = new CloneDemo();
        CloneDemo clone = d.clone();
        System.out.println(d.getData());
        System.out.println(clone.getData());
    }
}
