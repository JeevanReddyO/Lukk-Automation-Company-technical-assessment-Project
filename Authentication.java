import java.util.Scanner;

public class Authentication {

    private Scanner sc = new Scanner(System.in);

    // Register User
    public void register() {

        System.out.println("\n========== USER REGISTRATION ==========");

        System.out.print("Enter Username: ");
        String username = sc.nextLine();

        // Check duplicate username
        for (User user : DataStore.users) {
            if (user.getUsername().equalsIgnoreCase(username)) {
                System.out.println("Username already exists!");
                return;
            }
        }

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        System.out.println("\nSelect Role");
        System.out.println("1. Admin");
        System.out.println("2. Event Manager");
        System.out.println("3. Consumer");
        System.out.print("Enter Choice: ");

        int choice = sc.nextInt();
        sc.nextLine(); // Consume newline

        int userId = DataStore.generateUserId();

        switch (choice) {

            case 1:
                DataStore.users.add(new Admin(DataStore.generateUserId(), username, password));
                System.out.println("Admin Registered Successfully.");

                break;

            case 2:
                DataStore.users.add(new EventManager(userId, username, password));
                System.out.println("Event Manager Registered Successfully.");
                break;

            case 3:
                DataStore.users.add(new Consumer(userId, username, password));
                System.out.println("Consumer Registered Successfully.");
                break;

            default:
                System.out.println("Invalid Role.");
        }
    }

    // Login User
    public User login() {

        System.out.println("\n========== LOGIN ==========");

        System.out.print("Enter Username: ");
        String username = sc.nextLine();

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        for (User user : DataStore.users) {

            if (user.getUsername().equalsIgnoreCase(username)
                    && user.getPassword().equals(password)) {

                System.out.println("\nLogin Successful!");
                System.out.println("Welcome, " + user.getUsername());
                System.out.println("Role : " + user.getRole());

                return user;
            }
        }

        System.out.println("Invalid Username or Password.");
        return null;
    }
}