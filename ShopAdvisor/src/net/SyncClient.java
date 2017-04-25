package net;

import data.User;
import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SyncClient extends Thread{
    
    String ip;
    User seller;

    public SyncClient(String ip, User seller) {
        this.ip = ip;
        this.seller = seller;
    }

    
    @Override
    public void run() {
        try {
            int filesize = 1022386;
            int bytesRead;
            int currentTot = 0;
            User seller = null;
            Socket socket = new Socket("127.0.0.1", 15123);
            
            PrintStream os = new PrintStream(socket.getOutputStream());
            String str = seller.getFullName();
            //String str = "hello";
            os.println(str);
            os.flush();
            System.out.println("Message sent to the server : " + str);
            
            byte[] bytearray = new byte[filesize];
            InputStream is = socket.getInputStream();
            FileOutputStream fos = new FileOutputStream("data/orders" + str + ".txt");
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            bytesRead = is.read(bytearray, 0, bytearray.length);
            currentTot = bytesRead;
            
            do {
                bytesRead
                        = is.read(bytearray, currentTot, (bytearray.length - currentTot));
                if (bytesRead >= 0) {
                    currentTot += bytesRead;
                }
            } while (bytesRead > -1);
            
            bos.write(bytearray, 0, currentTot);
            bos.flush();
            bos.close();
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(SyncClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
