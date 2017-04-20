
package net;

import data.*;
import javafx.collections.ObservableList;

public class OrderMaker extends Thread {
    
    ObservableList<Product> p;
    User user;

    public OrderMaker(ObservableList<Product> p, User user) {
        this.p = p;
        this.user = user;
    }
    
    public String createOrder(ObservableList<Product> pr, User u){
       String head = "\t\tShopadvisor order\n";
       String person = "Customer Information: \n" + u.toString() + "\n";
       String things = "";
       for(Product product : pr){
           things+= "\n" + product;
       }
       return head + things; 
    }
    
    String prepareItemList(ObservableList<Product> pr){
       String things = "";
       for(Product product : pr){
           things+= "\n" + product;
       }
        return things;
    }
    
    public void run(){
        TestClient tc = new TestClient("127.0.0.1", 2222);
        tc.setClientinfo("Customer Information: \n\t" + user.toString() + "\n");
        tc.setOrdered(prepareItemList(p));
        tc.start();
        //System.out.println(createOrder(p, user));
        p.clear();
    }
}
