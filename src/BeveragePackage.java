/**
 * Concrete implementation of a room addon (a decoration).
 */
public class BeveragePackage extends RoomAddon {
    public static final String name = "Beverage Package";
    public static final double price = 700d;
    public static final String description =
            "This booking includes the coveted beverage package, " +
            "featuring unlimited Kool-aid.";

    protected BeveragePackage() {
        super(name, price, description);
    }
}
