public class Consumer extends User {

    public Consumer() {
        super();
        setRole("Consumer");
    }

    public Consumer(int userId, String username, String password) {
        super(userId, username, password, "Consumer");
    }

    @Override
    public String toString() {
        return "Consumer {" +
                "User ID = " + getUserId() +
                ", Username = '" + getUsername() + '\'' +
                ", Role = '" + getRole() + '\'' +
                '}';
    }
}