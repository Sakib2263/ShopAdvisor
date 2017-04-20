
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
       return head + person + things; 
    }
    
    public void run(){
        System.out.println(createOrder(p,user));
        p.clear();
    }
}
