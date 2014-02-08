package com.reflection.privateMethods;

import java.lang.reflect.Method;

/**
 * This is a testharness class is used for the class
 * Lover. This class displays you how to access the values
 * of the private methods.
 */
public class LoverTestharness
{
    public static void main(String[] args)
    {
        try
        {
            Class cls = Class.forName("com.dds.core.Lover");
            Object obj = cls.newInstance();
            Method[] methods =  cls.getDeclaredMethods();
            for( int i = 0 ; i < methods.length ; i++ )
            {
                System.out.println("Method Name--->>>"+methods[i].getName());
                System.out.println("Method Return Type--->>>"+methods[i].getReturnType());
                methods[i].setAccessible(true);
                System.out.println("Method Value--->>>"+methods[i].invoke(obj));
            }
        }
        catch( Exception e )
        {
            e.printStackTrace();
        }
    }
}