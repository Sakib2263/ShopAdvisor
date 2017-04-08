package productHandler;

public class ProductDemo {

    private String name;
    private double price;
    private int quantity;
    private String seller;
    private int id;

    public ProductDemo(){
        this.name = "";
        this.price = 0;
        this.quantity = 0;
    }

    public ProductDemo(String name, double price, int quantity){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public ProductDemo(String name, double price, String seller) {
        this.name = name;
        this.price = price;
        this.seller = seller;
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
