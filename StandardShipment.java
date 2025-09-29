// StandardShipment inherits from Shipment and adds insuranceFee
public class StandardShipment extends Shipment {
    private double insuranceFee; // extra cost for insurance

    // Constructor calls Shipment constructor and sets insuranceFee
    public StandardShipment(String trackingNumber, String sender, String receiver, double weight, double baseRate, double distanceKm, double insuranceFee) {
        super(trackingNumber, sender, receiver, weight, baseRate, distanceKm);
        this.insuranceFee = insuranceFee;
    }

    // Override calculateCost to add insuranceFee to base cost
    @Override
    public double calculateCost() {
        return super.calculateCost() + insuranceFee;
    }

    // Override estimated delivery days using 500 km/day speed (same as base)
    @Override
    public int getEstimatedDeliveryDays() {
        return (int) Math.ceil(getDistanceKm() / 500.0);
    }

    // Override getDetails to include insuranceFee
    @Override
    public String getDetails() {
        return super.getDetails() + String.format("\nInsurance Fee: %.2f", insuranceFee);
    }
}
