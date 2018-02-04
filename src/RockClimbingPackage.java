/**
 * Concrete implementation of a room addon (a decoration).
 */
public class RockClimbingPackage extends RoomAddon {
    public static final String name = "Rock Climbing Lessons";
    public static final double price = 60d;
    public static final String description =
            "This booking includes rock climbing lessons, " +
            "taught by Tom Cruise's own stunt doub- er... partner. " +
            "(By purchasing this package you formally agree that Tom Cruise has never " +
            "had a stunt double.)";

    protected RockClimbingPackage() {
        super(name, price, description);
    }
}
