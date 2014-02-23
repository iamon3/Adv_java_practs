package com.serialization.eg1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
public class SerializeMain {

    public static void main(String[] args) {

        Employee emp = new Employee();
        emp.setEmployeeId(101);
        emp.setEmployeeName("Arpit");
        emp.setDepartment("CS");
        try
        {
            FileOutputStream fileOut = new FileOutputStream("employee.ser");
            ObjectOutputStream outStream = new ObjectOutputStream(fileOut);
            outStream.writeObject(emp);
            outStream.close();
            fileOut.close();
        }catch(IOException i)
        {
            i.printStackTrace();
        }
    }
}