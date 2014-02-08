package com.reflection.privateConstructor;

import java.lang.reflect.Constructor;

/**
 * http://www.javaworld.com/article/2074753/core-java/object-hacking-in-java---power-of-reflection.html
 *
 * This is a testharness class for the class Student.
 * This class shows you how to create an instance of
 * a class whose constructor is private.
 */
public class StudentTestharness
{
    public static void main(String[] args)
    {
        try
        {
            Class cls = Class.forName("com.reflection.privateConstructor.Student");
            Constructor[] constructors = cls.getDeclaredConstructors();
            System.out.println("Constructor Name--->>>"+constructors[0].getName());
            constructors[0].setAccessible(true);
            Student std = (Student) constructors[0].newInstance( );
            std.setName("Free");
            System.out.println("Student created --->>>" + std.getName());
        }
        catch( Exception e )
        {
            e.printStackTrace();
        }
    }
}