/**
 * Concrete implementation of a room.
 */
public class BalconyRoom extends Room {
    public static final String name = "Balcony Room";
    public static final double price = 2000d;
    public static final String description =
            "A room with a luxurious balcony overlooking the ocean. This room " +
            "includes all amenities of the interior and ocean view rooms while also " +
            "including a complementary E-meter and coupon booklet for a free daily audit! " +
            "(By purchasing this room you agree to redemption of this coupon upon receipt of " +
            "room key.) (Due to safety doctrine 137.FI3, access to balconies is restricted to " +
            "Clear individuals only.)";

    protected BalconyRoom() {
        super(name, price, description);
    }
}
