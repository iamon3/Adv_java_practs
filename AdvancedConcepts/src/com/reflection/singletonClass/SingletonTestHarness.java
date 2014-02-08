package com.reflection.singletonClass;

import java.lang.reflect.Constructor;
/**
 * This testharness class is used for the class
 * MySingleton. This class is used to create
 * multiple instance using reflection.
 *
 */
public class SingletonTestHarness
{
    public static void main(String[] args)
    {
        try
        {
            Class cls = Class.forName("com.reflection.singletonClass.MySingleton");
            Constructor[] constructors = cls.getDeclaredConstructors();
            System.out.println("Constructor Name--->>>"+constructors[0].getName());
            constructors[0].setAccessible(true);
            /*
                * Object creation using reflection
                */
            System.out.println("Object creation using reflection--->>>"
                    + constructors[0].newInstance());
            /*
                * Create another instance
                */
            System.out.println("Another object creation using reflection--->>>"
                    + constructors[0].newInstance());
            /*
                * Normal object creation
                */
            MySingleton single = MySingleton.getInstance();
            System.out.println("Normal object creation--->>>"+single);
        }
        catch( Exception e )
        {
            e.printStackTrace();
        }
    }
}