public class ShippingSystemDemo {
    public static void main(String[] args) {
        // Create Standard Shipment object
        StandardShipment standard = new StandardShipment("STD123", "Alice", "Bob", 3.5, 10.0, 1000.0, 50.0);
        System.out.println("== Standard Shipment ==");
        System.out.println(standard.getDetails());                    // Print details
        System.out.println("Estimated Days: " + standard.getEstimatedDeliveryDays());  // Print estimated days
        System.out.println("Before Delivery Status: " + standard.getDeliveryStatus()); // Print status before delivery
        standard.markDelivered();                                     // Mark as delivered
        System.out.println("After Delivery Status: " + standard.getDeliveryStatus());  // Print status after delivery
        System.out.println();

        // Create Express Shipment object with "Rush" priority
        ExpressShipment express = new ExpressShipment("EXP456", "John", "Jane", 2.0, 15.0, 800.0, "Rush");
        System.out.println("== Express Shipment ==");
        System.out.println(express.getDetails());
        System.out.println("Estimated Days: " + express.getEstimatedDeliveryDays());
        System.out.println("Is High Priority? " + express.isHighPriority());
        System.out.println("Before Delivery Status: " + express.getDeliveryStatus());
        express.markDelivered();
        System.out.println("After Delivery Status: " + express.getDeliveryStatus());
        System.out.println();

        // Create International Shipment object
        InternationalShipment international = new InternationalShipment("INT789", "CompanyX", "CustomerY", 3.0, 20.0, 1500.0, 100.0, "Germany");
        System.out.println("== International Shipment ==");
        System.out.println(international.getDetails());
        System.out.println("Estimated Days: " + international.getEstimatedDeliveryDays());
        System.out.println("Requires Customs Declaration? " + international.requiresCustomsDeclaration());
        System.out.println("Before Delivery Status: " + international.getDeliveryStatus());
        international.markDelivered();
        System.out.println("After Delivery Status: " + international.getDeliveryStatus());
    }
}
