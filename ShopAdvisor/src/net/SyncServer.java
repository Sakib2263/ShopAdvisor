package net;

import java.net.*;
import java.io.*;

public class SyncServer extends Thread {
    
    private static ServerSocket serverSocket;
    private static Socket socket;

    @Override
    public void run() {
        try {
            serverSocket = new ServerSocket(15123);
        } catch (IOException ex) {
            System.err.println(ex);
        }
        while (true) {
            try {
                socket = serverSocket.accept();
                new SyncServerWork(socket).start();
                
            } catch (IOException ex) {
                System.err.println(ex);
            }
        }
    }

}

class SyncServerWork extends Thread {
    
    Socket socket;

    public SyncServerWork(Socket socket) {
        this.socket = socket;
    }
    

    @Override
    public void run() {

        try {
            System.out.println("Accepted connection : " + socket);

            DataInputStream is;
            is = new DataInputStream(socket.getInputStream());
            String name = is.readLine();

            File transferFile = new File("data/orders/" + name + ".txt");
            byte[] bytearray = new byte[(int) transferFile.length()];
            FileInputStream fin = new FileInputStream(transferFile);
            BufferedInputStream bin = new BufferedInputStream(fin);
            bin.read(bytearray, 0, bytearray.length);
            OutputStream os = socket.getOutputStream();
            System.out.println("Sending Files...");
            os.write(bytearray, 0, bytearray.length);
            os.flush();
            socket.close();
            FileWriter finish = new FileWriter("data/orders/" + name + ".txt");
            finish.close();
            System.out.println("File transfer complete");
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}
