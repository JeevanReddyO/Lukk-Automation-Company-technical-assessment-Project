import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Authentication auth = new Authentication();
        AdminOperations adminOps = new AdminOperations();
        EventOperations eventOps = new EventOperations();
        ConsumerOperations consumerOps = new ConsumerOperations();

        while (true) {

            System.out.println("\n======================================");
            System.out.println("     EVENT TICKET BOOKING SYSTEM");
            System.out.println("======================================");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    auth.register();
                    break;

                case 2:

                    User user = auth.login();

                    if (user == null) {
                        break;
                    }

                    // ================= ADMIN =================

                    if (user instanceof Admin) {

                        boolean adminLogout = false;

                        while (!adminLogout) {

                            System.out.println("\n========== ADMIN MENU ==========");
                            System.out.println("1. Add Location");
                            System.out.println("2. View Locations");
                            System.out.println("3. Approve Event");
                            System.out.println("4. Reject Event");
                            System.out.println("5. View Pending Events");
                            System.out.println("6. Monitor Seat Capacity");
                            System.out.println("7. Logout");

                            System.out.print("Enter Choice: ");
                            int adminChoice = sc.nextInt();
                            sc.nextLine();

                            switch (adminChoice) {

                                case 1:
                                    adminOps.addLocation();
                                    break;

                                case 2:
                                    adminOps.viewLocations();
                                    break;

                                case 3:
                                    adminOps.approveEvent();
                                    break;

                                case 4:
                                    adminOps.rejectEvent();
                                    break;

                                case 5:
                                    adminOps.viewPendingEvents();
                                    break;

                                case 6:
                                    adminOps.monitorSeatCapacity();
                                    break;

                                case 7:
                                    System.out.println("Admin Logged Out Successfully.");
                                    adminLogout = true;
                                    break;

                                default:
                                    System.out.println("Invalid Choice.");
                            }
                        }
                    }

                    // ================= EVENT MANAGER =================

                    else if (user instanceof EventManager) {

                        boolean managerLogout = false;

                        while (!managerLogout) {

                            System.out.println("\n======= EVENT MANAGER MENU =======");
                            System.out.println("1. Create Event");
                            System.out.println("2. View My Events");
                            System.out.println("3. Edit Event");
                            System.out.println("4. Send Event For Approval");
                            System.out.println("5. Cancel Event");
                            System.out.println("6. Logout");

                            System.out.print("Enter Choice: ");
                            int managerChoice = sc.nextInt();
                            sc.nextLine();

                            switch (managerChoice) {
                                                                case 1:
                                    eventOps.createEvent(user.getUserId());
                                    break;

                                case 2:
                                    eventOps.viewMyEvents(user.getUserId());
                                    break;

                                case 3:
                                    eventOps.editEvent(user.getUserId());
                                    break;

                                case 4:
                                    eventOps.sendForApproval(user.getUserId());
                                    break;

                                case 5:
                                    eventOps.cancelEvent(user.getUserId());
                                    break;

                                case 6:
                                    System.out.println("Event Manager Logged Out Successfully.");
                                    managerLogout = true;
                                    break;

                                default:
                                    System.out.println("Invalid Choice.");
                            }
                        }
                    }

                    // ================= CONSUMER =================

                    else if (user instanceof Consumer) {

                        boolean consumerLogout = false;

                        while (!consumerLogout) {

                            System.out.println("\n========== CONSUMER MENU ==========");
                            System.out.println("1. View Approved Events");
                            System.out.println("2. Book Ticket");
                            System.out.println("3. View My Bookings");
                            System.out.println("4. Make Payment");
                            System.out.println("5. Apply Coupon");
                            System.out.println("6. Logout");

                            System.out.print("Enter Choice: ");
                            int consumerChoice = sc.nextInt();
                            sc.nextLine();

                            switch (consumerChoice) {

                                case 1:
                                    consumerOps.viewApprovedEvents();
                                    break;

                                case 2:
                                    consumerOps.bookTicket(user.getUserId());
                                    break;

                                case 3:
                                    consumerOps.viewMyBookings(user.getUserId());
                                    break;

                                case 4:
                                    consumerOps.makePayment(user.getUserId());
                                    break;

                                case 5:
                                    consumerOps.applyCoupon(user.getUserId());
                                    break;

                                case 6:
                                    System.out.println("Consumer Logged Out Successfully.");
                                    consumerLogout = true;
                                    break;

                                default:
                                    System.out.println("Invalid Choice.");
                            }
                        }
                    }

                    break;

                case 3:

                    System.out.println("\nThank You for using Event Ticket Booking System.");
                    sc.close();
                    return;

                default:

                    System.out.println("Invalid Choice.");
                                }
        }

        
    }
}