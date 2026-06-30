import java.util.Scanner;

public class EventOperations {

    private Scanner sc = new Scanner(System.in);

    // Create Event
    public void createEvent(int managerId) {

        System.out.println("\n========== CREATE EVENT ==========");

        int eventId = DataStore.generateEventId();

        System.out.print("Enter Event Name: ");
        String eventName = sc.nextLine();

        // Check duplicate event name
        for (Event event : DataStore.events) {

            if (event.getEventName().equalsIgnoreCase(eventName)) {

                System.out.println("Event already exists.");
                return;
            }
        }

        System.out.print("Enter Event Date (dd-mm-yyyy): ");
        String eventDate = sc.nextLine();

        System.out.print("Enter Ticket Price: ");
        double ticketPrice = sc.nextDouble();

        if (ticketPrice <= 0) {

            System.out.println("Invalid Ticket Price.");
            sc.nextLine();
            return;
        }

        System.out.print("Enter Number of Seats: ");
        int seats = sc.nextInt();
        sc.nextLine();

        if (seats <= 0) {

            System.out.println("Invalid Seat Count.");
            return;
        }

        if (DataStore.locations.isEmpty()) {

            System.out.println("No Locations Available.");
            return;
        }

        System.out.println("\nAvailable Locations");

        for (Location location : DataStore.locations) {

            System.out.println(location.getLocationId()
                    + " - "
                    + location.getLocationName());
        }

        System.out.print("Enter Location ID: ");
        int locationId = sc.nextInt();
        sc.nextLine();

        Location selectedLocation = null;

        for (Location location : DataStore.locations) {

            if (location.getLocationId() == locationId) {

                selectedLocation = location;
                break;
            }
        }

        if (selectedLocation == null) {

            System.out.println("Invalid Location.");
            return;
        }

        Event event = new Event(
                eventId,
                eventName,
                eventDate,
                ticketPrice,
                seats,
                selectedLocation,
                "Pending",
                managerId);

        DataStore.events.add(event);

        System.out.println("Event Created Successfully.");
    }

    // View My Events

    public void viewMyEvents(int managerId) {

        boolean found = false;

        System.out.println("\n========== MY EVENTS ==========");

        for (Event event : DataStore.events) {

            if (event.getManagerId() == managerId) {

                System.out.println(event);
                found = true;
            }
        }

        if (!found) {

            System.out.println("No Events Found.");
        }
    }

    // Edit Event

    public void editEvent(int managerId) {

        System.out.print("Enter Event ID: ");
        int eventId = sc.nextInt();
        sc.nextLine();

        for (Event event : DataStore.events) {

            if (event.getEventId() == eventId &&
                    event.getManagerId() == managerId) {

                if (event.getStatus().equalsIgnoreCase("Cancelled")) {

                    System.out.println("Cancelled Event cannot be edited.");
                    return;
                }

                System.out.print("Enter New Event Name: ");
                event.setEventName(sc.nextLine());

                System.out.print("Enter New Date: ");
                event.setEventDate(sc.nextLine());

                System.out.print("Enter New Ticket Price: ");
                event.setTicketPrice(sc.nextDouble());

                System.out.print("Enter New Seat Count: ");
                event.setAvailableSeats(sc.nextInt());
                sc.nextLine();

                System.out.println("Event Updated Successfully.");

                return;
            }
        }

        System.out.println("Event Not Found.");
    }

    // Send Event For Approval
        public void sendForApproval(int managerId) {

        System.out.print("Enter Event ID: ");
        int eventId = sc.nextInt();
        sc.nextLine();

        for (Event event : DataStore.events) {

            if (event.getEventId() == eventId &&
                    event.getManagerId() == managerId) {

                if (event.getStatus().equalsIgnoreCase("Approved")) {

                    System.out.println("Event is already approved.");
                    return;
                }

                if (event.getStatus().equalsIgnoreCase("Cancelled")) {

                    System.out.println("Cancelled Event cannot be submitted.");
                    return;
                }

                event.setStatus("Pending");

                System.out.println("Event Sent For Approval Successfully.");

                return;
            }
        }

        System.out.println("Event Not Found.");
    }

    // Cancel Event

    public void cancelEvent(int managerId) {

        System.out.print("Enter Event ID: ");
        int eventId = sc.nextInt();
        sc.nextLine();

        for (Event event : DataStore.events) {

            if (event.getEventId() == eventId &&
                    event.getManagerId() == managerId) {

                if (event.getStatus().equalsIgnoreCase("Cancelled")) {

                    System.out.println("Event Already Cancelled.");
                    return;
                }

                event.setStatus("Cancelled");

                System.out.println("Event Cancelled Successfully.");

                // Generate Coupons
                for (Booking booking : DataStore.bookings) {

                    if (booking.getEventId() == eventId) {

                        Coupon coupon = new Coupon(

                                DataStore.generateCouponId(),

                                booking.getConsumerId(),

                                "DISC10" + booking.getConsumerId(),

                                10,

                                false);

                        DataStore.coupons.add(coupon);
                    }
                }

                System.out.println("Compensation Coupons Generated.");

                return;
            }
        }

        System.out.println("Event Not Found.");
    }
}