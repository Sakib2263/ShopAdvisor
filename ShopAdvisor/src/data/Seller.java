package data;

public class Seller extends User{

    public Seller(String userName, String password, String type, String FullName, String email, String address) {
        super(userName, password, type, FullName, email, address);
    }

    public Seller() {
        type = "Buyer";
    }
    
}
