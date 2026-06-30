public class EventManager extends User {

    public EventManager() {
        super();
        setRole("Event Manager");
    }

    public EventManager(int userId, String username, String password) {
        super(userId, username, password, "Event Manager");
    }

    @Override
    public String toString() {
        return "EventManager {" +
                "User ID = " + getUserId() +
                ", Username = '" + getUsername() + '\'' +
                ", Role = '" + getRole() + '\'' +
                '}';
    }
}