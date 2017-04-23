package data;

import java.io.Serializable;

public class Product implements Serializable{
    private int id;
    private double price;
    private String store;
    private  String Name;

    public Product(String store,double price) {
        this.price = price;
        this.store = store;
    }

    public Product() {
    }

    public Product(String Name,String store, double price) {
        this.price = price;
        this.store = store;
        this.Name = Name;
    }
    

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public String getStore() {
        return store;
    }

    public String getName() {
        return Name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
    @Override
    public String toString(){
      
       return " Product Name: " + Name + "\n";
    }
    
      
}
