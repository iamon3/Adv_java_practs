package com.serialization.eg3ObjectWithReferenceToNonSerizableObject;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * If you make address transient then during deserialization it will return null.
 * But what if you still want to have same state as when you have serialized address object.
 * Java serialization provides a mechnism such that if you have private methods with particular signature then they will get called during serialization
 * and deserialization so we will override writeObject and readObject method of employee class
 * and they will be called during serialization and deserialization of Employee object.
 */
public class Employee implements Serializable{

    int employeeId;
    String employeeName;
    String department;
    transient Address address;

    public int getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
    public String getEmployeeName() {
        return employeeName;
    }
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }

    private void writeObject(ObjectOutputStream os) throws IOException, ClassNotFoundException
    {
        try {
            os.defaultWriteObject();
            os.writeInt(address.getHomeNo());
            os.writeObject(address.getStreet());
            os.writeObject(address.getCity());
        }
        catch (Exception e)
        { e.printStackTrace(); }
    }

    private void readObject(ObjectInputStream is) throws IOException, ClassNotFoundException
    {
        try {
            is.defaultReadObject();
            int homeNo=is.readInt();
            String street=(String) is.readObject();
            String city=(String) is.readObject();
            address=new Address(homeNo,street,city);

        } catch (Exception e) { e.printStackTrace(); }
    }
}