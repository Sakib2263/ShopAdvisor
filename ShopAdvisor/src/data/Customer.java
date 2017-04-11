package data;

public class Customer extends User{

    public Customer(String userName, String password, String type, String FullName, String email, String address) {
        super(userName, password, type, FullName, email, address);
    }

    public Customer() {
        type = "Buyer";
    }
    
    
}
