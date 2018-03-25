package functionLayer;

public class User {

    private final String email;
    private final String password;
    private final String role;
    private int id;

    public User(String username, String password, String role) {
        this.email = username;
        this.password = password;
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

}
