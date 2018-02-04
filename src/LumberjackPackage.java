/**
 * Concrete implementation of a room addon (a decoration).
 */
public class LumberjackPackage extends RoomAddon {
    public static final String name = "Lumberjack Competition Admission";
    public static final double price = 15d;
    public static final String description =
            "This booking includes admission to a lumberjack competition, " +
            "judged by the one and only Tom Cruise himself! " +
            "(By participating in this competition, attractive contestants consent to " +
            "any sexual advances or sham marriage proposals that arise.)";

    protected LumberjackPackage() {
        super(name, price, description);
    }
}
