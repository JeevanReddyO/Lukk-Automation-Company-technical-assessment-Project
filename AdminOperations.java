import java.util.Scanner;

public class AdminOperations {

    private Scanner sc = new Scanner(System.in);

    // Add Location
    public void addLocation() {

        System.out.println("\n========== ADD LOCATION ==========");

        int locationId = DataStore.generateLocationId();

        System.out.print("Enter Location Name: ");
        String locationName = sc.nextLine();

        // Check duplicate location name
        for (Location location : DataStore.locations) {
            if (location.getLocationName().equalsIgnoreCase(locationName)) {
                System.out.println("Location already exists.");
                return;
            }
        }

        System.out.print("Enter Address: ");
        String address = sc.nextLine();

        System.out.print("Enter Seat Capacity: ");
        int capacity = sc.nextInt();
        sc.nextLine(); // Consume newline

        if (capacity <= 0) {
            System.out.println("Invalid Capacity.");
            return;
        }

        Location location = new Location(locationId, locationName, address, capacity);
        DataStore.locations.add(location);

        System.out.println("Location Added Successfully.");
    }

    // View Locations
    public void viewLocations() {

        System.out.println("\n========== LOCATIONS ==========");

        if (DataStore.locations.isEmpty()) {
            System.out.println("No Locations Available.");
            return;
        }

        for (Location location : DataStore.locations) {
            System.out.println(location);
        }
    }

    // View Pending Events
    public void viewPendingEvents() {

        System.out.println("\n========== PENDING EVENTS ==========");

        boolean found = false;

        for (Event event : DataStore.events) {

            if (event.getStatus().equalsIgnoreCase("Pending")) {
                System.out.println(event);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No Pending Events Found.");
        }
    }

    // Approve Event
    public void approveEvent() {

        System.out.print("Enter Event ID to Approve: ");
        int eventId = sc.nextInt();
        sc.nextLine();

        for (Event event : DataStore.events) {

            if (event.getEventId() == eventId) {

                if (event.getStatus().equalsIgnoreCase("Approved")) {
                    System.out.println("Event is already approved.");
                    return;
                }

                event.setStatus("Approved");
                System.out.println("Event Approved Successfully.");
                return;
            }
        }

        System.out.println("Event Not Found.");
    }

    // Reject Event (New Feature)
    public void rejectEvent() {

        System.out.print("Enter Event ID to Reject: ");
        int eventId = sc.nextInt();
        sc.nextLine();

        for (Event event : DataStore.events) {

            if (event.getEventId() == eventId) {

                event.setStatus("Rejected");
                System.out.println("Event Rejected Successfully.");
                return;
            }
        }

        System.out.println("Event Not Found.");
    }

    // Monitor Seat Capacity
    public void monitorSeatCapacity() {

        System.out.println("\n========== LOCATION CAPACITY ==========");

        if (DataStore.locations.isEmpty()) {
            System.out.println("No Locations Available.");
            return;
        }

        for (Location location : DataStore.locations) {

            System.out.println("Location ID   : " + location.getLocationId());
            System.out.println("Location Name : " + location.getLocationName());
            System.out.println("Capacity      : " + location.getCapacity());
            System.out.println("---------------------------------------");
        }
    }
}