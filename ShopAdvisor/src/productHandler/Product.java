package productHandler;


public class Product {
    private double price;
    private String store;

    public Product(String store,double price) {
        this.price = price;
        this.store = store;
    }

    public Product() {
    }

    public double getPrice() {
        return price;
    }

    public String getStore() {
        return store;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStore(String store) {
        this.store = store;
    }
    
    
}
