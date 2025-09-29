// InternationalShipment inherits from Shipment, adds customs and destination info
public class InternationalShipment extends Shipment {
    private double customsFee;         // extra customs charge
    private String destinationCountry; // where it is shipped to

    // Constructor initializes customsFee and destinationCountry
    public InternationalShipment(String trackingNumber, String sender, String receiver, double weight, double baseRate, double distanceKm, double customsFee, String destinationCountry) {
        super(trackingNumber, sender, receiver, weight, baseRate, distanceKm);
        this.customsFee = customsFee;
        this.destinationCountry = destinationCountry;
    }

    // Override calculateCost to add customsFee
    @Override
    public double calculateCost() {
        return super.calculateCost() + customsFee;
    }

    // Override delivery days using 400 km/day speed + 2 extra days for customs clearance
    @Override
    public int getEstimatedDeliveryDays() {
        return (int) Math.ceil(getDistanceKm() / 400.0) + 2;
    }

    // Returns true if shipment weight is heavier than 2.0 kg (requires customs form)
    public boolean requiresCustomsDeclaration() {
        return getWeight() > 2.0;
    }

    // Override getDetails to include customs and destination country
    @Override
    public String getDetails() {
        return super.getDetails() + String.format("\nCustoms Fee: %.2f\nDestination Country: %s", customsFee, destinationCountry);
    }
}
