package com.serialization.eg4NonSerializableSuperClass;

import java.io.Serializable;

public class Employee extends Person implements Serializable{

    int employeeId;
    String department;

    public Employee(int employeeId,String name,String department,String nationality)
    {
        super(name,nationality);
        this.employeeId=employeeId;
        this.department=department;
        System.out.println("Employee:Constructor");
    }

    public int getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
}