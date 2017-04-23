
package net;

import data.*;
import java.io.Serializable;

public class Order implements Serializable{
    private User buyer;
    private Product product;

    public Order(User buyer,Product product) {
        this.buyer = buyer;
        this.product = product;
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
    
    
}
