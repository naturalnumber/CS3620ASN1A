/**
 * Concrete implementation of a room addon (a decoration).
 */
public class EnlightenmentPackage extends RoomAddon {
    public static final String name = "Enlightenment Tour";
    public static final double price = 500d;
    public static final String description =
            "This booking includes admission to the Scientology enlightenment tour. " +
            "(Tour ends upon complete vanquishing of the reactive mind, or a successful " +
            "credit check and church membership.)";

    protected EnlightenmentPackage() {
        super(name, price, description);
    }
}
