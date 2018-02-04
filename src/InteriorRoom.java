/**
 * Concrete implementation of a room.
 */
public class InteriorRoom extends Room {
    public static final String name = "Interior Room";
    public static final double price = 1000d;
    public static final String description =
            "A room with a view of a diverse collection of photos featuring the " +
            "illustrious L. Ron Hubbard, which decorate every wall, ceiling, and screen. " +
            "(Clearing screens for use is a violation of the terms and conditions of this " +
            "cruise. We will sue!) (L. Ron eyes may be surveillance cameras for your own " +
            "protection.)";

    protected InteriorRoom() {
        super(name, price, description);
    }
}
