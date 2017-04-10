
package data;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

public class dataMap {
    public static HashMap<String, User> recordMap;
    
    public dataMap(){
        recordMap = new HashMap<>();
    }
    public dataMap(String fileName){
        recordMap = new HashMap<>();
        loadMap(fileName);
    }
    
    public void updateMap(String userName, String password, String type, String FullName, String email, String address){
        recordMap.put(userName, new User(userName,password,type,FullName,email,address));
    }

    static HashMap loadMap(String fileName) {
        try {
            FileReader fr = new FileReader("data/" + fileName);
            Scanner sc = new Scanner(fr);
            while(sc.hasNext()){
                String temp = sc.nextLine();
                String holder[] = temp.split(",");
                recordMap.put(holder[0] , new User(holder[0], holder[1],holder[2],holder[3],holder[4],holder[5]));
                
            }
        } catch (FileNotFoundException ex) {
            System.err.println("Exception: " + ex + " File could not be found");

        }
        return recordMap;
    }
    
}
