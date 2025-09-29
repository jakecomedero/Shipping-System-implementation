// ExpressShipment inherits from Shipment and adds priority features
public class ExpressShipment extends Shipment {
    private String priorityLevel; // "Normal", "High", or "Rush"
    private double priorityFee;   // fee depends on priorityLevel

    // Constructor sets priorityLevel and calculates priorityFee
    public ExpressShipment(String trackingNumber, String sender, String receiver, double weight, double baseRate, double distanceKm, String priorityLevel) {
        super(trackingNumber, sender, receiver, weight, baseRate, distanceKm);
        this.priorityLevel = priorityLevel;
        setPriorityFee(); // calculates fee based on priority
    }

    // Helper method to assign fee based on priorityLevel
    private void setPriorityFee() {
        switch (priorityLevel) {
            case "Rush":
                priorityFee = 500;
                break;
            case "High":
                priorityFee = 200;
                break;
            default: // Normal or other
                priorityFee = 0;
        }
    }

    // Override calculateCost to add priority fee
    @Override
    public double calculateCost() {
        return super.calculateCost() + priorityFee;
    }

    // Override delivery days using 800 km/day speed (faster than standard)
    @Override
    public int getEstimatedDeliveryDays() {
        return (int) Math.ceil(getDistanceKm() / 800.0);
    }

    // Returns true if priorityLevel is "High" or "Rush"
    public boolean isHighPriority() {
        return priorityLevel.equals("High") || priorityLevel.equals("Rush");
    }

    // Override getDetails to include priority info
    @Override
    public String getDetails() {
        return super.getDetails() + String.format("\nPriority: %s\nPriority Fee: %.2f", priorityLevel, priorityFee);
    }
}
