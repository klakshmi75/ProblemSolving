package com.company;

class Generic<T> {
    T var;
    public void setVar(T var) {
        this.var = var;
    }
    public void print() {
        System.out.println(var);

    }
    public T getVar() {
        return var;
    }
}
public class GenericClass {
    public static void main(String rags[]) {
        Generic<String> g = new Generic<>();
        g.setVar("string");
        g.print();

        Generic<Integer> gInt = new Generic<>();
        gInt.setVar(345);
        int i1 = gInt.getVar();
        System.out.println(i1);

        Generic<Integer> g2 = new Generic();
        g2.setVar(3);
        int i2 = g2.getVar();
        System.out.println(i2);
    }
}