package data;

public class User {
    protected String userName, type, FullName, email, address;
    protected String password;

    public User(String userName, String password, String type, String FullName, String email, String address) {
        this.userName = userName;
        this.type = type;
        this.FullName = FullName;
        this.email = email;
        this.address = address;
        this.password = password;
    }

    public User() {
    }

    public String getUserName() {
        return userName;
    }

    public String getType() {
        return type;
    }

    public String getFullName() {
        return FullName;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getPassword() {
        return password;
    }
    
    @Override
    public String toString(){
        return "Name: " + FullName + ", Email: " + email + ", Address: " + address;
    }
}
