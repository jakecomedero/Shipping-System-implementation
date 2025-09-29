public class Shipment {
    // Private variables - only accessible within this class
    private String trackingNumber;
    private String sender;
    private String receiver;
    private double weight; // in kilograms
    private double baseRate; // cost per kilogram
    private double distanceKm; // distance in kilometers
    private boolean delivered; // true if shipment delivered, false otherwise

    // Constructor: called when creating a new Shipment object
    public Shipment(String trackingNumber, String sender, String receiver, double weight, double baseRate, double distanceKm) {
        this.trackingNumber = trackingNumber;
        this.sender = sender;
        this.receiver = receiver;
        setWeight(weight);       // setWeight method includes validation
        setBaseRate(baseRate);   // setBaseRate method includes validation
        setDistanceKm(distanceKm); // setDistanceKm method includes validation
        this.delivered = false;  // shipment is not delivered initially
    }

    // Calculate cost of shipment = weight * baseRate
    public double calculateCost() {
        return weight * baseRate;
    }

    // Mark this shipment as delivered
    public void markDelivered() {
        delivered = true;
    }

    // Returns current delivery status as a string
    public String getDeliveryStatus() {
        return delivered ? "Delivered" : "In Transit";
    }

    // Calculates estimated days to deliver based on distance and speed (default 500 km/day)
    public int getEstimatedDeliveryDays() {
        double days = distanceKm / 500.0; 
        return (int) Math.ceil(days); // round up to next whole day
    }

    // Returns formatted string with shipment details
    public String getDetails() {
        return String.format(
            "Tracking: %s\nSender: %s\nReceiver: %s\nWeight: %.2f kg\nBase Rate: %.2f\nDistance: %.2f km\nCost: %.2f\nStatus: %s",
            trackingNumber, sender, receiver, weight, baseRate, distanceKm, calculateCost(), getDeliveryStatus()
        );
    }

    // Getter for weight
    public double getWeight() {
        return weight;
    }

    // Setter for weight with validation (must be positive)
    public void setWeight(double weight) {
        if (weight > 0) {
            this.weight = weight;
        }
    }

    // Getter for baseRate
    public double getBaseRate() {
        return baseRate;
    }

    // Setter for baseRate with validation (must be positive)
    public void setBaseRate(double baseRate) {
        if (baseRate > 0) {
            this.baseRate = baseRate;
        }
    }

    // Getter for distanceKm
    public double getDistanceKm() {
        return distanceKm;
    }

    // Setter for distanceKm with validation (must be positive)
    public void setDistanceKm(double distanceKm) {
        if (distanceKm > 0) {
            this.distanceKm = distanceKm;
        }
    }
}
