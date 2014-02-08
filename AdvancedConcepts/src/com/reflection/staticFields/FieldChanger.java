package com.reflection.staticFields;

/**
 * http://www.javaworld.com/article/2074753/core-java/object-hacking-in-java---power-of-reflection.html
 *
 * This is a class where there is only one
 * private static field and public static
 * method.
 */
public class FieldChanger
{
    private static String name = "John" ;

    public static String getName()
    {
        return name ;
    }
}