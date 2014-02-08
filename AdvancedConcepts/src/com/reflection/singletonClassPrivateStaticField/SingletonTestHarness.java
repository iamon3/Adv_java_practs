package com.reflection.singletonClassPrivateStaticField;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

/**
 * Objective is to change private static field in the singleton class.
 */
public class SingletonTestHarness
{
    private static String k1 = "Cricket";
    private static String k2 = "football";
    private static String v1 = "cricket.com";
    private static String v2 = "football.com";

    public static void main(String[] args)
    {
        try
        {
            Class cls = Class.forName("com.reflection.singletonClassPrivateStaticField.MySingleton");
           // printConstructors(cls);
            printFields1(cls);
            System.out.println("k1: " + k1 + ", v1 : " + MySingleton.getInstance().getProp(k1));
            System.out.println("k2: "+k2+", v2 : " + MySingleton.getInstance().getProp(k2));
        }
        catch( Exception e )
        {
            e.printStackTrace();
        }
    }

    private static void printFields(Class cls) throws InvocationTargetException, IllegalAccessException, InstantiationException {
        Field[] fields = cls.getDeclaredFields();
        Constructor[] constructors = cls.getDeclaredConstructors();
        constructors[0].setAccessible(true);
        Object obj = constructors[0].newInstance();
        for( int i = 0 ; i < fields.length ; i++ )
        {
            fields[i].setAccessible(true);
            System.out.println("Field Name-->"+fields[i].getName()+"\t"
                    +"Field Type-->"+ fields[i].getType().getName()+"\t"
                    +"Field Value-->"+ fields[i].get(obj));

            if(fields[i].getName().equals("deploymentConfigProperties")){
                System.out.println("Going to set prop------");
                fields[i].set(null, getMockProp());
            }
        }
    }

    private static void printFields1(Class cls) throws InvocationTargetException, IllegalAccessException, InstantiationException {

        Object obj = null;
        Constructor[] constructors = cls.getDeclaredConstructors();
        for(int i =0 ; i< constructors.length ; i++){
            constructors[i].setAccessible(true);
            Class[] pTypes = constructors[i].getParameterTypes();
            if(pTypes.length == 0){
                System.out.println("No parameter Constructor.");
                obj = constructors[0].newInstance();
                break;
            }
        }

        Field[] fields = cls.getDeclaredFields();
        for( int i = 0 ; i < fields.length ; i++ )
        {
            fields[i].setAccessible(true);
            System.out.println("Field Name-->"+fields[i].getName()+"\t"
                    +"Field Type-->"+ fields[i].getType().getName()+"\t"
                    +"Field Value-->"+ fields[i].get(obj));

            if(fields[i].getName().equals("deploymentConfigProperties")){
                System.out.println("Going to set prop------");
                fields[i].set(null,getMockProp());
            }
        }
    }

    private static void printConstructors(Class cls) throws InvocationTargetException, IllegalAccessException, InstantiationException {
        Constructor[] constructors = cls.getDeclaredConstructors();
        for(int i =0 ; i< constructors.length ; i++){
            System.out.println("Constructor : "+constructors[i].getName()+", modifiers : " + constructors[i].getModifiers() + ", isSynthetic : " + constructors[i].isSynthetic());

            Class[] pTypes = constructors[i].getParameterTypes();
            if(pTypes.length == 0){
                System.out.println("No parameter.");
                constructors[i].setAccessible(true);
                MySingleton mySingletons  = (MySingleton) constructors[i].newInstance();
                Field[] fields = cls.getDeclaredFields();
                for( int k = 0 ; k < fields.length ; k++ )
                {
                    fields[i].setAccessible(true);
                    System.out.println("Field Name-->"+fields[i].getName()+"\t"
                            +"Field Type-->"+ fields[i].getType().getName()+"\t"
                            +"Field Value-->"+ fields[i].get(mySingletons));
                }
            }
        }
    }

    private static Properties getMockProp(){
        Properties properties = new Properties();
        properties.put(k1, v1);
        properties.put(k2,v2);
        return properties;
    }
}