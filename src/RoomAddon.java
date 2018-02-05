/**
 * The abstract decoration from which all decorations will inherit.
 *
 * Concrete implementations will be:
 * Beverage package ($700)
 • Klondike trail guided horseback tour ($50)
 • Helicopter glacier tour ($200)
 • Rock climbing lessons ($60)
 • Admission to a lumberjack competition ($15)
 • Scientology enlightenment tour ($500)
 */
public abstract class RoomAddon extends Room {
    public static final double TAX_RATE_ADDON = .06d;

    private Room decorated;

    protected RoomAddon(String name, double price, String description) {
        super(name, price, description);
    }

    /**
     * @return combined price, 0 if invalid
     */
    @Override
    public double getPrice() {
        if (isValid())
            return this.decorated.getPrice() + super.getPrice();
        else
            return 0d;
    }

    /**
     * @return combined tax, 0 if invalid
     */
    @Override
    public double getTax() {
        if (isValid())
            return this.decorated.getTax() + super.getPrice() * TAX_RATE_ADDON;
        else
            return 0d;
    }

    /**
     * @return combined name, "" if invalid
     */
    @Override
    public String getName() {
        if (isValid())
            return this.decorated.getName() + " + " + super.getName();
        else
            return "";
    }

    /**
     * @return combined description, "" if invalid
     */
    @Override
    public String getDescription() {
        if (isValid())
            return this.decorated.getDescription() + " " + super.getDescription();
        else
            return "";
    }

    /**
     * Sets the room or room construct that this decoration will decorate.
     * This must be called shortly after construction.
     *
     * @param toDecorate the construct to decorate
     *
     * @return the combined, decorated construct
     */
    public Room initializeDecorated(Room toDecorate) {
        if (toDecorate == null) throw new NullPointerException("Invalid base: null");

        // Validity check
        if (this.decorated == null && toDecorate.setDecoration(this)) {
            this.decorated = toDecorate;
        } else {
            throw new IllegalStateException(toDecorate.toString());
        }

        return this.decorated.getTop();
    }

    /**
     * Internal use only.
     *
     * @param decorated replacement decoration target
     */
    protected void replaceDecorated(Room decorated) {
        this.decorated = decorated;
    }

    protected Room getDecorated() {
        return decorated;
    }

    public boolean isValid() {
        return this.decorated != null;
    }

    /**
     * Traverses the construct and removes an addon by type if found.
     *
     * @param addon the class type to remove
     * @param <T> the class type to remove
     *
     * @return the new construct
     */
    protected <T extends RoomAddon> Room removeAddon(Class<T> addon) {
        if (!isValid()) throw new NullPointerException("No room");

        // If type matches, remove yourself
        if (addon == this.getClass()) {
            if (hasDecoration()) this.decoration.replaceDecorated(this.decorated);
            return this.decorated.replaceDecoration(this.decoration);
        }

        // Otherwise pass it down the chain
        return this.decorated.removeAddon(addon);
    }

    /**
     * For internal use only.
     *
     * @param newRoom new room
     *
     * @return new construct, null if invalid
     */
    protected Room replaceRoom(Room newRoom) {
        if (isValid())
            return this.decorated.replaceRoom(newRoom);
        else
            return null;
    }

    /**
     * @return the combined construct
     */
    protected Room getTop() {
        return (hasDecoration()) ? this.decoration.getTop() : this;
    }

    /**
     * For internal use only.
     *
     * @return the base of the construct, null if invalid
     */
    protected Room getBase() {
        if (isValid())
            return this.decorated.getBase();
        else
            return null;
    }
}