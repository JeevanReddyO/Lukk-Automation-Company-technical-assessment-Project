public class Coupon {

    private int couponId;
    private int consumerId;
    private String couponCode;
    private double discountPercentage;
    private boolean used;

    public Coupon() {
    }

    public Coupon(int couponId, int consumerId, String couponCode,
                  double discountPercentage, boolean used) {
        this.couponId = couponId;
        this.consumerId = consumerId;
        this.couponCode = couponCode;
        this.discountPercentage = discountPercentage;
        this.used = used;
    }

    // Getters
    public int getCouponId() {
        return couponId;
    }

    public int getConsumerId() {
        return consumerId;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public boolean isUsed() {
        return used;
    }

    // Setters
    public void setCouponId(int couponId) {
        this.couponId = couponId;
    }

    public void setConsumerId(int consumerId) {
        this.consumerId = consumerId;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    @Override
    public String toString() {
        return "\nCoupon ID : " + couponId +
               "\nConsumer ID : " + consumerId +
               "\nCoupon Code : " + couponCode +
               "\nDiscount : " + discountPercentage + "%" +
               "\nStatus : " + (used ? "Used" : "Available");
    }
}