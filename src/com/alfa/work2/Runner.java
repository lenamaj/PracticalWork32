package com.alfa.work2;

import com.alfa.work1.Employee;

import java.io.*;

public class Runner {


    public void run() throws IOException, ClassNotFoundException{

        User user1 = createUser("User1", "User1", 20);
        User user2 = createUser("User2", "User2", 25);
        writeUser(user1);
        writeUser(user2);
        readUsers(fp);

    }

    public User createUser(String firstName, String lastName, int age) {
        return new User(firstName, lastName, age);
    }

    File fp = new File("E:\\Документы\\КУРСЫ\\JavaCoreAdv\\users.ser");

    public void writeUser(User user) throws IOException {
//        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fp))) {
//            oos.writeObject(user);

            try (RandomAccessFile outputStream = new RandomAccessFile(fp, "rw")) {
                outputStream.seek(outputStream.length());
                outputStream.writeUTF(System.lineSeparator());
                outputStream.writeBytes(user.toString());
            }

        }

        public void readUsers(File file) throws IOException {
//            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fp))) {
//                User readUser = (User) ois.readObject();
//            }

            try (RandomAccessFile imputeStream = new RandomAccessFile(file, "rw")) {
                String string = null;
                while ((string = imputeStream.readLine()) != null) {
                    System.out.println(string);
                }
            }

        }

}
