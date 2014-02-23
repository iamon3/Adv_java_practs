package com.serialization.eg4NonSerializableSuperClass;

/**
 * If superclass is not serializable then it's preferable to have no argument constructor.
 */
public class Person {

    String name="default";
    String nationality;

    public Person()
    {
        System.out.println("Person:Constructor");
    }

    public Person(String name, String nationality) {
        super();
        this.name = name;
        this.nationality = nationality;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}