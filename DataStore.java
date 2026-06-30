import java.util.ArrayList;

public class DataStore {

    public static ArrayList<User> users = new ArrayList<>();
    public static ArrayList<Location> locations = new ArrayList<>();
    public static ArrayList<Event> events = new ArrayList<>();
    public static ArrayList<Booking> bookings = new ArrayList<>();
    public static ArrayList<Coupon> coupons = new ArrayList<>();

    static {

        // ================= DEFAULT USERS =================

        users.add(new Admin(1, "admin", "admin123"));
        users.add(new EventManager(2, "manager1", "manager123"));
        users.add(new Consumer(3, "consumer1", "consumer123"));

        // ================= DEFAULT LOCATIONS =================

        // Hyderabad
        locations.add(new Location(generateLocationId(), "Hyderabad Convention Centre", "Hyderabad", 5000));
        locations.add(new Location(generateLocationId(), "Hitex Exhibition Center", "Hyderabad", 10000));
        locations.add(new Location(generateLocationId(), "Gachibowli Indoor Stadium", "Hyderabad", 7500));

        // Chennai
        locations.add(new Location(generateLocationId(), "Jawaharlal Nehru Indoor Stadium", "Chennai", 8000));
        locations.add(new Location(generateLocationId(), "YMCA Grounds, Nandanam", "Chennai", 12000));
        locations.add(new Location(generateLocationId(), "Chennai Trade Centre", "Chennai", 6000));

        // Mumbai
        locations.add(new Location(generateLocationId(), "Jio World Garden", "Mumbai", 15000));
        locations.add(new Location(generateLocationId(), "MMRDA Grounds", "Mumbai", 20000));
        locations.add(new Location(generateLocationId(), "NSCI Dome", "Mumbai", 9000));

        // Goa
        locations.add(new Location(generateLocationId(), "Sunburn Arena", "Goa", 30000));
        locations.add(new Location(generateLocationId(), "Bambolim Athletic Stadium", "Goa", 12000));
        locations.add(new Location(generateLocationId(), "Dr. Shyama Prasad Mukherjee Indoor Stadium", "Goa", 5000));
        locations.add(new Location(generateLocationId(), "Campal Grounds", "Goa", 10000));

        // Gurugram
        locations.add(new Location(generateLocationId(), "Leisure Valley Ground", "Gurugram", 12000));
        locations.add(new Location(generateLocationId(), "DLF CyberHub Amphitheatre", "Gurugram", 4000));

        // Bengaluru
        locations.add(new Location(generateLocationId(), "Palace Grounds", "Bengaluru", 25000));
        locations.add(new Location(generateLocationId(), "KTPO Exhibition Centre", "Bengaluru", 15000));
        locations.add(new Location(generateLocationId(), "Embassy International Riding School", "Bengaluru", 10000));

        // ================= DEFAULT EVENT =================

        events.add(new Event(
                generateEventId(),
                "Java Tech Fest",
                "15-08-2026",
                500.0,
                300,
                locations.get(0),
                "Approved",
                2));
    }

    // Generate User ID
    public static int generateUserId() {
        return users.size() + 1;
    }

    // Generate Event ID
    public static int generateEventId() {
        return events.size() + 1;
    }

    // Generate Booking ID
    public static int generateBookingId() {
        return bookings.size() + 1;
    }

    // Generate Coupon ID
    public static int generateCouponId() {
        return coupons.size() + 1;
    }

    // Generate Location ID
    public static int generateLocationId() {
        return locations.size() + 1;
    }
}