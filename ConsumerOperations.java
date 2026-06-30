import java.util.Scanner;

public class ConsumerOperations {

    private Scanner sc = new Scanner(System.in);

    // View Approved Events
    public void viewApprovedEvents() {

        boolean found = false;

        System.out.println("\n========== APPROVED EVENTS ==========");

        for (Event event : DataStore.events) {

            if (event.getStatus().equalsIgnoreCase("Approved")) {

                System.out.println(event);
                System.out.println("--------------------------------");

                found = true;
            }
        }

        if (!found) {

            System.out.println("No Approved Events Available.");
        }
    }

    // Book Ticket

    public void bookTicket(int consumerId) {

        System.out.print("Enter Event ID: ");
        int eventId = sc.nextInt();

        Event selectedEvent = null;

        for (Event event : DataStore.events) {

            if (event.getEventId() == eventId &&
                    event.getStatus().equalsIgnoreCase("Approved")) {

                selectedEvent = event;
                break;
            }
        }

        if (selectedEvent == null) {

            System.out.println("Event Not Found.");
            return;
        }

        System.out.print("Enter Number of Tickets: ");
        int tickets = sc.nextInt();
        sc.nextLine();

        if (tickets <= 0) {

            System.out.println("Invalid Number Of Tickets.");
            return;
        }

        if (tickets > selectedEvent.getAvailableSeats()) {

            System.out.println("Seats Not Available.");
            return;
        }

        double totalAmount =
                tickets * selectedEvent.getTicketPrice();

        Booking booking = new Booking(

                DataStore.generateBookingId(),

                consumerId,

                eventId,

                tickets,

                totalAmount,

                "Pending");

        DataStore.bookings.add(booking);

        selectedEvent.setAvailableSeats(
                selectedEvent.getAvailableSeats() - tickets);

        System.out.println("\nBooking Successful.");
        System.out.println("Booking ID : "
                + booking.getBookingId());

        System.out.println("Amount To Pay : ₹"
                + totalAmount);
    }

    // View My Bookings

    public void viewMyBookings(int consumerId) {

        boolean found = false;

        System.out.println("\n========== MY BOOKINGS ==========");

        for (Booking booking : DataStore.bookings) {

            if (booking.getConsumerId() == consumerId) {

                System.out.println(booking);
                System.out.println("--------------------------------");

                found = true;
            }
        }

        if (!found) {

            System.out.println("No Bookings Found.");
        }
    }

    // Make Payment
        public void makePayment(int consumerId) {

        System.out.print("Enter Booking ID: ");
        int bookingId = sc.nextInt();
        sc.nextLine();

        for (Booking booking : DataStore.bookings) {

            if (booking.getBookingId() == bookingId &&
                    booking.getConsumerId() == consumerId) {

                if (booking.getPaymentStatus().equalsIgnoreCase("Paid")) {

                    System.out.println("Payment Already Completed.");
                    return;
                }

                booking.setPaymentStatus("Paid");

                System.out.println("\nPayment Successful.");

                generateReceipt(booking);

                return;
            }
        }

        System.out.println("Booking Not Found.");
    }

    // Apply Coupon

    public void applyCoupon(int consumerId) {

        System.out.print("Enter Coupon Code: ");
        String couponCode = sc.nextLine();

        for (Coupon coupon : DataStore.coupons) {

            if (coupon.getConsumerId() == consumerId &&
                    coupon.getCouponCode().equalsIgnoreCase(couponCode) &&
                    !coupon.isUsed()) {

                coupon.setUsed(true);

                System.out.println("Coupon Applied Successfully.");
                System.out.println("Discount : "
                        + coupon.getDiscountPercentage() + "%");

                return;
            }
        }

        System.out.println("Invalid Coupon or Coupon Already Used.");
    }

    // Generate Receipt

    private void generateReceipt(Booking booking) {

        System.out.println("\n========== E-RECEIPT ==========");

        System.out.println("Booking ID      : "
                + booking.getBookingId());

        System.out.println("Consumer ID     : "
                + booking.getConsumerId());

        System.out.println("Event ID        : "
                + booking.getEventId());

        System.out.println("Tickets         : "
                + booking.getNumberOfTickets());

        System.out.println("Amount Paid     : ₹"
                + booking.getTotalAmount());

        System.out.println("Payment Status  : "
                + booking.getPaymentStatus());

        System.out.println("===============================");
    }

}