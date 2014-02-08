package com.reflection.privateConstructor;

/**
 * http://www.javaworld.com/article/2074753/core-java/object-hacking-in-java---power-of-reflection.html
 *
 * This is a class whose constructor is
 * made private so that it can not be
 * instantiated.
 *
 */
public class Student
{
    private Student()
    {
        super();
    }
}