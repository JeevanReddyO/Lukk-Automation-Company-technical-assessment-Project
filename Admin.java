public class Admin extends User {

    public Admin() {
        super();
        setRole("Admin");
    }

    public Admin(int userId, String username, String password) {
        super(userId, username, password, "Admin");
    }

    @Override
    public String toString() {
        return "Admin {" +
                "User ID = " + getUserId() +
                ", Username = '" + getUsername() + '\'' +
                ", Role = '" + getRole() + '\'' +
                '}';
    }
}