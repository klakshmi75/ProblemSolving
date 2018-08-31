package com.company;

public class VariableScopes {
    public static void main(String rags[]) {
        new Test().test();
    }
}

class Test {
    public void test() {
        for(int i=0; i<10;i++) {
            System.out.println("first loop");
            {
                int f = 1;
                System.out.println("first loop" + f);
            }
        }
        for(int i=0; i<10;i++) {

        }
    }
}
