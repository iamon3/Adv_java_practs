package com.reflection.singletonClassPrivateStaticField;

import java.util.Properties;

/**
 * This is a class which represents a singleton
 * design pattern. However it is a normal singleton
 * pattern.
 */
public class MySingleton
{
    private static MySingleton single = null;
    private static Properties deploymentConfigProperties = null;

    private MySingleton()
    {
        super();
    }

    private MySingleton(String a){

    }

    public static MySingleton getInstance()
    {
        if( single == null )
            single = new MySingleton();
        return single;
    }

    public String getProp(String key){
        return deploymentConfigProperties.getProperty(key);
    }
}