
package net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

public class TestClient extends Thread{
    
    private Socket clientSocket;
    private DataInputStream Din;
    private DataOutputStream Dout;
    private final int port;
    private final String serverip;
    String clientinfo;
    String ordered;
    private static PrintStream os;

    public TestClient(String serverip, int port) {
        this.port = port;
        this.serverip = serverip;
    }

    public void setClientinfo(String clientinfo) {
        this.clientinfo = clientinfo;
    }

    public void setOrdered(String ordered) {
        this.ordered = ordered;
    }
    
    public void run(){
        try {
            System.out.println("Client Started");
            clientSocket = new Socket(serverip, port);
            Din = new DataInputStream(clientSocket.getInputStream());
            Dout = new DataOutputStream(clientSocket.getOutputStream());
            os = new PrintStream(clientSocket.getOutputStream());
            sendOrder();
        } catch (IOException ex) {
            System.err.println("IOException " + ex);
        }
        
    }
    
    void sendOrder() throws IOException{
        String[] items = ordered.split("\n");
        for(String s : items){
            //System.out.println("sent: " + s);
            os.println(s);
            os.println("\n" +clientinfo);
            os.flush();
        }
        os.println("/quit");
    }
    
    
    
    
}
