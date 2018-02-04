/**
 * Concrete implementation of a room addon (a decoration).
 */
public class HelicopterPackage extends RoomAddon {
    public static final String name = "Helicopter Package";
    public static final double price = 200d;
    public static final String description =
            "This booking includes the helicopter glacier tour, " +
            "featuring a reenactment of Xenu's exile of aliens on ancient earth. " +
            "(The return of helicopters after mandatory exile reenactment is only " +
            "guaranteed for church members.)";

    protected HelicopterPackage() {
        super(name, price, description);
    }
}
