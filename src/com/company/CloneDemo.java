package com.company;

public class CloneDemo implements Cloneable{
    private static int s = 4;
    private int i = 5;
//    private CloneDemo() {
//
//    }

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

    public static void main(String rags[]) {
        CloneDemo d = new CloneDemo();
        CloneDemo clone = d.clone();
        System.out.println(d.getData());
        System.out.println(clone.getData());

        // demo for clone of child when parent is not cloneable
        Child c1 = new Child(6, 7);
        Child c2 = c1.clone();
        System.out.println("c1=" + c1.getI() + c1.getJ());
        System.out.println("clone=" + c2.getI() + c2.getJ());
    }


    static class Parent {
        int i;
        public Parent(int i) {
            this.i = i;
        }
        public int getI() {
            return i;
        }
    }

    static class Child extends Parent implements Cloneable {
        int j;
        public Child(int i, int j) {
            super(i);
            this.j = j;
        }
        public Child clone() {
            try {
                return (Child) super.clone();
            } catch(CloneNotSupportedException e) {
                return null;
            }
        }
        public int getJ() {
            return j;
        }
    }
}
