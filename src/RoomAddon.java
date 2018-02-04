/**
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

    @Override
    public double getPrice() {
        return this.decorated.getPrice() + super.getPrice();
    }

    @Override
    public double getTax() {
        return this.decorated.getPrice() * TAX_RATE_ADDON + super.getTax();
    }

    @Override
    public String getName() {
        return this.decorated.getName() + " + " + super.getName();
    }

    @Override
    public String getDescription() {
        return this.decorated.getDescription() + " " + super.getDescription();
    }

    public Room initializeDecorated(Room toDecorate) {
        if (toDecorate == null) throw new NullPointerException("Invalid base: null");

        if (this.decorated != null || toDecorate.setDecoration(this)) {
            this.decorated = toDecorate;
        } else {
            throw new IllegalStateException(toDecorate.toString());
        }

        return this.decorated.getTop();
    }

    protected void replaceDecorated(Room decorated) {
        this.decorated = decorated;
    }

    protected Room getDecorated() {
        return decorated;
    }

    protected <T extends RoomAddon> Room removeAddon(Class<T> addon) {
        if (hasDecoration()) this.decoration.replaceDecorated(this.decorated);

        return (addon == this.getClass()) ?
               this.decorated.replaceDecoration(this.decoration) :
               this.decorated.removeAddon(addon);
    }

    protected Room replaceRoom(Room newRoom) {
        return this.decorated.replaceRoom(newRoom);
    }

    protected Room getTop() {
        return (hasDecoration()) ? this.decoration.getTop() : this;
    }

    protected Room getBase() {
        return this.decorated.getBase();
    }
}

/*


    protected Room remove() {
        if (hasDecoration()) {
            this.decorated.setDecoration(this.decoration);
        }
        return ;
    }
 */