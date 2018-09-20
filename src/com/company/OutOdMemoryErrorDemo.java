package com.company;

// This program demonstrates various errors

public class OutOdMemoryErrorDemo {
    public static void main(String args[]) throws Exception {
        IllegalAccessDemo();
    }

    // java.lang.OutOfMemoryError: Java heap space
    public static void createStringInterns(String s) {
        createStringInterns(new String(s+s));
    }
    //Exception in thread "main" java.lang.StackOverflowError
    public static int recurse(int i) {
        return recurse(i-1);
    }
    //Exception in thread "main" java.lang.IllegalAccessException: Class com.company.OutOdMemoryErrorDemo can not access a
    //member of class com.company.TestIllegalAccess with modifiers "private"
    public static void IllegalAccessDemo() throws Exception{
        // If we don't give fully qualified class name it throws ClassNotFoundException
        Class clazz = Class.forName("com.company.TestIllegalAccess");
        TestIllegalAccess obj = (TestIllegalAccess)clazz.newInstance();
    }
}

class TestIllegalAccess {
    private TestIllegalAccess(){

    }
}
