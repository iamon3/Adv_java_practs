package com.reflection.privateFields;

import java.lang.reflect.Field;

/**
 * This is a testharness class for the class
 * Emp. This class displays how to access the
 * private field value.
 *
 */
public class EmpTestharness
{
    public static void main(String[] args)
    {
        try
        {
            Class cls = Class.forName("com.reflection.privateFields.Emp");
            Object obj = cls.newInstance();
            Field[] fields = cls.getDeclaredFields();
            for( int i = 0 ; i < fields.length ; i++ )
            {
                fields[i].setAccessible(true);
                System.out.println("Field Name-->"+fields[i].getName()+"\t"
                        +"Field Type-->"+ fields[i].getType().getName()+"\t"
                        +"Field Value-->"+ fields[i].get(obj));

                // Change the name
                if(fields[i].get(obj).equals("John")){
                    fields[i].set(obj,"Free");
                    System.out.println("Changed ==>  Field Name-->"+fields[i].getName()+"\t"
                            +"Field Type-->"+ fields[i].getType().getName()+"\t"
                            +"Field Value-->"+ fields[i].get(obj));

                }
            }
        }
        catch( Exception e )
        {
            e.printStackTrace();
        }
    }
}