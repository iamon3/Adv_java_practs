package com.reflection.staticFields;

import java.lang.reflect.Field;


/**
 * http://www.javaworld.com/article/2074753/core-java/object-hacking-in-java---power-of-reflection.html
 *
 * This testharness class is used for
 * the class FieldChanger to change the
 * value of the field using reflection.
 * @author Debadatta Mishra(PIKU)
 *
 */
public class FieldChangerTestharness
{
    public static void main(String[] args)
    {
        try
        {
            Class cls = Class.forName("com.dds.core.FieldChanger");
            Object obj = cls.newInstance();
            Field[] fields = cls.getDeclaredFields();
            fields[0].setAccessible( true );
            System.out.println(FieldChanger.getName());
            fields[0].set( null ,"Horse" );
            System.out.println(FieldChanger.getName());
        }
        catch( Exception e )
        {
            e.printStackTrace();
        }
    }
}