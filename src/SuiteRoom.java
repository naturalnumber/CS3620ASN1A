public class SuiteRoom extends Room {
    public static final String name = "Suite";
    public static final double price = 3000d;
    public static final String description =
            "A room with unparalleled luxury, combining all the amenities of all " +
            "other room types with the added bonus of a closet guaranteed to have been used " +
            "by at least one of John Travolta or Tom Cruise. (Continued occupancy of the " +
            "closet, though not guaranteed, is likely.)";

    protected SuiteRoom() {
        super(name, price, description);
    }
}
