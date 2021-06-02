package com.alfa.work3;



import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Runner {
 public void run(){

     User[] users = new User[]{
         new User("User1", "User1", 20),
         new User("User2", "User3", 21),
     };

     File fp = new File("E:\\Документы\\КУРСЫ\\JavaCoreAdv\\demo3.ser");
     try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fp))) {

         for (int i = 0; i < users.length; i++) {
             users[i].writeExternal(out);
         }

     } catch (IOException e) {
         System.out.println(e);
     }


     List<User> list = new ArrayList<>();

     try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fp))) {
         User user ;
         while ((user = (User) in.readObject()) != null) {
             list.add(user);
         }
     } catch (IOException | ClassNotFoundException e) {

         System.out.println(e);
     }

     System.out.println(list);

 }

}
