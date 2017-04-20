
package net;

import data.FileOperations;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;


public class TestServer extends Thread{
  private static ServerSocket serverSocket = null;
  private static Socket clientSocket;
  private static final int maxClientsCount = 10;
  private static final serverProcessThread[] threads = new serverProcessThread[maxClientsCount];

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
            (threads[i] = new serverProcessThread(clientSocket, threads)).start();
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


class serverProcessThread extends Thread {

  private String clientName = null;
  private DataInputStream is = null;
  private PrintStream os = null;
  private Socket clientSocket = null;
  private final serverProcessThread[] threads;
  private int maxClientsCount;
  FileOperations fop = new FileOperations();

  public serverProcessThread(Socket clientSocket, serverProcessThread[] threads) {
    this.clientSocket = clientSocket;
    this.threads = threads;
    maxClientsCount = threads.length;
  }

  public void run() {
      System.out.println("Server is processing");
    int maxClientsCount = this.maxClientsCount;
    serverProcessThread[] threads = this.threads;
    String fileName = "default";

    try {
      /*
       * Create input and output streams for this client.
       */
      is = new DataInputStream(clientSocket.getInputStream());
      os = new PrintStream(clientSocket.getOutputStream());
     
      /* Start the conversation. */
      while (true) {
        String line = is.readLine();
        //if(line.isEmpty()) continue;
        System.out.println("line received: " + line);
        if (line.startsWith("/quit")) {
          break;
        }
        if (line.startsWith("#")) {
          String[] words = line.split("\\s", 2);
          if (words.length > 1 && words[1] != null) {
            if (!words[1].isEmpty()) {
                fileName = words[0].substring(1);
                fop.addRecord(fileName,words[1]);
                //System.out.println(words[1]);
            }
          }
        } else {
          fop.addRecord(fileName,line);
          //System.out.println(line);
        }
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
      is.close();
      os.close();
      clientSocket.close();
  } catch (IOException e) {
    }
  }
}
