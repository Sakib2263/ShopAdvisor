
package net;

import data.FileOperations;
import data.User;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;


public class OrderServer extends Thread{
  private static ServerSocket serverSocket = null;
  private static Socket clientSocket;
  private static final int maxClientsCount = 10;
  private static final serverProcessorThread[] threads = new serverProcessorThread[maxClientsCount];

  @Override
  public void run() {
    int portNumber = 2222;
      System.out.println("Usage: java MultiThreadServerSync <portNumber>\n"
          + "Now using port number=" + portNumber);

    try {
      serverSocket = new ServerSocket(portNumber);
    } catch (IOException e) {
      System.out.println(e);
    }

    while (true) {
      try {
        clientSocket = serverSocket.accept();
          System.out.println("Client connected");
        int i = 0;
        for (i = 0; i < maxClientsCount; i++) {
          if (threads[i] == null) {
            (threads[i] = new serverProcessorThread(clientSocket, threads)).start();
            break;
          }
        }
        if (i == maxClientsCount) {
          PrintStream os = new PrintStream(clientSocket.getOutputStream());
          os.println("Server too busy. Try later.");
          os.close();
          clientSocket.close();
        }
      } catch (IOException e) {
        System.out.println(e);
      }
    }
  }
}


class serverProcessorThread extends Thread {

  private ObjectInputStream inStream = null;
  private Socket clientSocket = null;
  private final serverProcessorThread[] threads;
  private int maxClientsCount;
  FileOperations fop = new FileOperations();

  public serverProcessorThread(Socket clientSocket, serverProcessorThread[] threads) {
    this.clientSocket = clientSocket;
    this.threads = threads;
    maxClientsCount = threads.length;
  }

  public void run() {
      System.out.println("Server is processing");
    int maxClientsCount = this.maxClientsCount;
    serverProcessorThread[] threads = this.threads;
    String fileName = "default";

    try {
      inStream = new ObjectInputStream(clientSocket.getInputStream());
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
      while (true) {
        Order o = (Order) inStream.readObject();
        User u = o.getBuyer();
        if(u.getType() == "quit"){
            break;
        }
        String orderText = "";
        orderText+= "\nOrder received: \nOrder id : " + sdf.format(Calendar.getInstance().getTime());
        orderText+="\nOrdered Product: \n" + o.getProduct();
        orderText+= "\nOrdered by: \nName : " + u.getFullName() + "\nEmail : " + u.getEmail() + "\nAddress : " + u.getAddress();
        System.out.println(orderText);
        fop.addRecord(o.getProduct().getStore(),orderText );
      }

      /*
       * Clean up. Set the current thread variable to null so that a new client
       * could be accepted by the server.
       */
      synchronized (this) {
        for (int i = 0; i < maxClientsCount; i++) {
          if (threads[i] == this) {
            threads[i] = null;
          }
        }
      }
      /*
       * Close the output stream, close the input stream, close the socket.
       */
      inStream.close();
      clientSocket.close();
  } catch (IOException e) {
    } catch (ClassNotFoundException ex) {
          Logger.getLogger(serverProcessorThread.class.getName()).log(Level.SEVERE, null, ex);
      }
  }
}
