public class Location {

    private int locationId;
    private String locationName;
    private String address;
    private int capacity;

    // Default Constructor
    public Location() {

    }

    // Parameterized Constructor
    public Location(int locationId, String locationName,
                    String address, int capacity) {

        this.locationId = locationId;
        this.locationName = locationName;
        this.address = address;
        this.capacity = capacity;
    }

    // Getters

    public int getLocationId() {
        return locationId;
    }

    public String getLocationName() {
        return locationName;
    }

    public String getAddress() {
        return address;
    }

    public int getCapacity() {
        return capacity;
    }

    // Setters

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCapacity(int capacity) {

        if (capacity > 0) {
            this.capacity = capacity;
        } else {
            System.out.println("Invalid Capacity.");
        }
    }

    @Override
    public String toString() {

        return "\n========== LOCATION ==========" +
                "\nLocation ID      : " + locationId +
                "\nLocation Name    : " + locationName +
                "\nAddress          : " + address +
                "\nSeat Capacity    : " + capacity +
                "\n==============================";
    }
}