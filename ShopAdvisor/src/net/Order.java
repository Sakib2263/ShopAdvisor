
package net;

import data.*;
import java.io.Serializable;

public class Order implements Serializable{
    private User buyer;
    private Product product;
    private String id;

    public Order(User buyer,Product product, String id) {
        this.buyer = buyer;
        this.product = product;
        this.id = id;
    }

    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }
    
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
}
