/**
 * The abstract room from which all rooms and decorations will inherit.
 *
 * Concrete implementations will be:
 * Interior room - $1000
 • Ocean view room - $1500
 • Balcony room - $2000
 • Suite - $3000
 */
public abstract class Room {
    public static final double TAX_RATE_ROOM = .16d;
    public static final double GRATUITY_RATE_ROOM = .15d;

    private double price;
    private String name;
    private String description;
    protected RoomAddon decoration;

    protected Room(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    /**
     * @return room price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @return room tax
     */
    public double getTax() {
        return price * TAX_RATE_ROOM;
    }

    /**
     * @return room name
     */
    public String getName() {
        return name;
    }

    /**
     * @return room description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return decorated state
     */
    protected boolean hasDecoration() {
        return this.decoration != null;
    }

    protected RoomAddon getDecoration() {
        return decoration;
    }

    /**
     * @param decoration new decoration
     *
     * @return success
     */
    protected boolean setDecoration(RoomAddon decoration) {
        if (decoration != null && !hasDecoration()) {
            this.decoration = decoration;
            return hasDecoration();
        }

        return false;
    }

    /**
     * Internal use only.
     *
     * @param decoration replacement
     *
     * @return new combined construct
     */
    protected Room replaceDecoration(RoomAddon decoration) {
        this.decoration = decoration;
        return this.getTop();
    }

    /**
     * Acts as base case, does nothing.
     *
     * @param addon the class type to remove
     * @param <T> the class type to remove
     *
     * @return the new construct
     */
    protected <T extends RoomAddon> Room removeAddon(Class<T> addon) {
        return this.getTop();
    }

    /**
     * @param newRoom replacement
     *
     * @return the new combined construct
     */
    protected Room replaceRoom(Room newRoom) {
        if (newRoom != null && !(newRoom instanceof RoomAddon)) {
            if (hasDecoration()) {
                this.decoration.replaceDecorated(newRoom);
            }

            return newRoom.replaceDecoration(this.decoration);
        }

        return this.getTop();
    }

    /**
     * @return the combined construct
     */
    protected Room getTop() {
        return (hasDecoration()) ? this.decoration.getTop() : this;
    }

    /**
     * Acts as base case.
     * For internal use only.
     *
     * @return the base of the construct, null if invalid
     */
    protected Room getBase() {
        return this;
    }
}