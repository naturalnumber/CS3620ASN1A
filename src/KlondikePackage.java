/**
 * Concrete implementation of a room addon (a decoration).
 */
public class KlondikePackage extends RoomAddon {
    public static final String name = "Klondike Package";
    public static final double price = 50d;
    public static final String description =
            "This booking includes the Klondike trail guided horseback tour, " +
            "featuring horses trained only to balk with suppressive riders. " +
            "(All suppressive riders will be handed over to Sea Org members on standby.)";

    protected KlondikePackage() {
        super(name, price, description);
    }
}
