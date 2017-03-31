
package data;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

public class dataMap {
    public HashMap<String, String> recordMap;
    
    public dataMap(){
        recordMap = new HashMap<>();
    }
    
    public void loadMap(String fileName) {
        
        try {
            FileReader fr = new FileReader("data/" + fileName);
            Scanner sc = new Scanner(fr);
            String holder[] = new String[2];
            while(sc.hasNext()){
                String temp = sc.nextLine();
                holder = temp.split(" ");
                recordMap.put(holder[0], holder[1]);
                
            }
        } catch (FileNotFoundException ex) {
            System.err.println("Exception: " + ex + " File could not be found");

        }
    }
    
    public void updateMap(String record1, String record2){
        recordMap.put(record2, record2);
    }
    
}
