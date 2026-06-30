public class Event {

    private int eventId;
    private String eventName;
    private String eventDate;
    private double ticketPrice;
    private int availableSeats;
    private Location location;
    private String status;      // Pending, Approved, Rejected, Cancelled
    private int managerId;

    public Event() {
    }

    public Event(int eventId, String eventName, String eventDate,
                 double ticketPrice, int availableSeats,
                 Location location, String status, int managerId) {

        this.eventId = eventId;
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.ticketPrice = ticketPrice;
        this.availableSeats = availableSeats;
        this.location = location;
        this.status = status;
        this.managerId = managerId;
    }

    // Getters
    public int getEventId() {
        return eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public String getEventDate() {
        return eventDate;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public Location getLocation() {
        return location;
    }

    public String getStatus() {
        return status;
    }

    public int getManagerId() {
        return managerId;
    }

    // Setters
    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    @Override
    public String toString() {
        return "\nEvent ID : " + eventId +
               "\nEvent Name : " + eventName +
               "\nEvent Date : " + eventDate +
               "\nTicket Price : ₹" + ticketPrice +
               "\nAvailable Seats : " + availableSeats +
               "\nLocation : " + location.getLocationName() +
               "\nStatus : " + status +
               "\nManager ID : " + managerId;
    }
}