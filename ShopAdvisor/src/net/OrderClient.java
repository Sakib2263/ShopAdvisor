
package net;

import data.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javafx.collections.ObservableList;

public class OrderClient extends Thread {
    
    private Socket clientSocket;
    private final int port;
    private final String serverip;
    FileOutputStream fileOut;
    ObjectOutputStream outServer;
    ObjectOutputStream outFile;
    ObservableList<Product> p;
    User user;

    public OrderClient(ObservableList<Product> p, User user,String serverip, int port) {
        this.p = p;
        this.user = user;
        this.port = port;
        this.serverip = serverip;
    }
    
    public void sendOrder() throws IOException{
        outServer = new ObjectOutputStream(clientSocket.getOutputStream());
        FileOutputStream fo = new FileOutputStream("data/orders/" + user.getUserName() + ".ser");
        outFile = new ObjectOutputStream(fo);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        ArrayList<Order> ord = new ArrayList<>();
        for(Product product : p){
            Order o = new Order(user, product, sdf.format(Calendar.getInstance().getTime()));
            outServer.writeObject(o);
            outServer.flush();
            ord.add(o);
       }
        outFile.writeObject(ord);
        //sending quit
        user.setType("quit");
        Order o = new Order(user, new Product(), "null");
        outServer.writeObject(o);
        outServer.flush();
    }
    
    public void run(){
        try {
            System.out.println("Client Started");
            clientSocket = new Socket(serverip, port);
            sendOrder();
            p.clear();
        } catch (IOException ex) {
            System.err.println("IOException " + ex);
        }
    }
}
