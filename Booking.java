public class Booking {

    private int bookingId;
    private int consumerId;
    private int eventId;
    private int numberOfTickets;
    private double totalAmount;
    private String paymentStatus; // Pending or Paid

    public Booking() {
    }

    public Booking(int bookingId, int consumerId, int eventId,
                   int numberOfTickets, double totalAmount,
                   String paymentStatus) {

        this.bookingId = bookingId;
        this.consumerId = consumerId;
        this.eventId = eventId;
        this.numberOfTickets = numberOfTickets;
        this.totalAmount = totalAmount;
        this.paymentStatus = paymentStatus;
    }

    // Getters
    public int getBookingId() {
        return bookingId;
    }

    public int getConsumerId() {
        return consumerId;
    }

    public int getEventId() {
        return eventId;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    // Setters
    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public void setConsumerId(int consumerId) {
        this.consumerId = consumerId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public void setNumberOfTickets(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    @Override
    public String toString() {
        return "\nBooking ID : " + bookingId +
               "\nConsumer ID : " + consumerId +
               "\nEvent ID : " + eventId +
               "\nTickets Booked : " + numberOfTickets +
               "\nTotal Amount : ₹" + totalAmount +
               "\nPayment Status : " + paymentStatus;
    }
}