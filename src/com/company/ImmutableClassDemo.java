package com.company;

class Composition {
    private int i = 0;
    public Composition(int i) {
        this.i = i;
    }
    public int getI() {
        return i;
    }
    public  void setI(int i) {
        this.i = i;
    }
}
class ContainerWithDeepCopyForMutableVariables {
    private final Composition inner;
    public ContainerWithDeepCopyForMutableVariables(Composition c) {
        this.inner = new Composition(c.getI());
    }
    public Composition getInner() {
        return inner;
    }
}
class ContainerWithShallowCopyForMutableVariables {
    private final Composition inner;
    public ContainerWithShallowCopyForMutableVariables(Composition c) {
        this.inner = c;
    }
    public Composition getInner() {
        return inner;
    }
}

public class ImmutableClassDemo {

    public static void main(String[] args) throws CloneNotSupportedException {
        Composition inner = new Composition(5);
        // create immutable instance with deep copy
        ContainerWithDeepCopyForMutableVariables immutableWithDeepCopy = new ContainerWithDeepCopyForMutableVariables(inner);
        System.out.println(immutableWithDeepCopy.getInner().getI());
        inner.setI(6);
        System.out.println(immutableWithDeepCopy.getInner().getI());

        ContainerWithShallowCopyForMutableVariables immutableWithShallowCopy = new ContainerWithShallowCopyForMutableVariables(inner);
        System.out.println(immutableWithShallowCopy.getInner().getI());
        inner.setI(7);
        System.out.println(immutableWithShallowCopy.getInner().getI());
    }
}
