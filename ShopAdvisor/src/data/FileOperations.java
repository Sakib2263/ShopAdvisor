package data;

import java.io.*;

public class FileOperations {
    
    dataMap record = new dataMap();


    public void addRecord(String name, String record1, String record2) {
        try {
            FileWriter fr = new FileWriter("data/" + name , true );
            fr.write(String.format("%s %s\n", record1,record2));
            fr.flush();
            //fr.close();
            System.out.println("record added");
        } catch (IOException ex) {
            System.err.println("Exception: " + ex + " File could not be found");
        } 
    }
    public void addRecord(String userName, String password, String type, String FullName, String email, String address) {
        try {
            FileWriter fr = new FileWriter("data/users.csv", true);
            fr.write(String.format("%s,%s,%s,%s,%s,%s\n",userName,password, type,FullName,email,address));
            fr.flush();
            System.out.println("record added");
        } catch (IOException ex) {
            System.err.println("Exception: " + ex + " File could not be found");
        } 
    }

}
