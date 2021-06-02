package com.alfa.work1;

import java.io.*;

public class Runner {

    public void run() throws IOException, ClassNotFoundException {
        Employee employee = new Employee("Pertov", "Kiev", 777, 5);
        File fp = new File("E:\\Документы\\КУРСЫ\\JavaCoreAdv\\demo.ser");
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fp));
             ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fp))) {
            oos.writeObject(employee);
            System.out.println("Ok");
            Employee newEployee = (Employee) ois.readObject();
            System.out.println(newEployee);
        }
    }
}
