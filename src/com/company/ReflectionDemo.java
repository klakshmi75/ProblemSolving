package com.company;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReflectionDemo {
    public static void main(String args[]) throws Exception{
        Class targetClass = Class.forName("com.company.ReflectionTarget");
        Class[] cArg = new Class[1];
        cArg[0] = Integer.class;
        Constructor<ReflectionTarget> cons = targetClass.getDeclaredConstructor(cArg);
//        cons.setAccessible(true);
        // works if we ave public constructor
        //        ReflectionTarget targetObj = (ReflectionTarget)targetClass.newInstance();
        ReflectionTarget targetObj = cons.newInstance(7);
        System.out.println(targetObj);

        // making methods public
        Method m = targetClass.getDeclaredMethod("show");
        m.setAccessible(true);
        m.invoke(targetObj);
    }
}

class ReflectionTarget {
    int i;
    // We can not create object with private constructor even with Class.forName().newInstance
    // First we need to make constructor public then create object
    private ReflectionTarget(){i = 5;}

    public ReflectionTarget(Integer i) {
        this.i = i;
    }
    private void show() {
        System.out.println("Calling private method from outside the class using reflection");
    }

}
