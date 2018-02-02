public abstract class RoomAddon extends Room {
    public static final double TAX_RATE_ADDON = .06d;

    private Room decorated;

    protected RoomAddon(String name, double price, String description, Room toDecorate) {
        super(name, price, description);

        this.decorated = toDecorate;
    }

    @Override
    public double getPrice() {
        return this.decorated.getPrice() + super.getPrice();
    }

    @Override
    public double getTax() {
        return this.decorated.getPrice() * TAX_RATE_ADDON;
    }

    @Override
    public String getName() {
        return this.decorated.getName() + " with " + super.getName();
    }

    @Override
    public String getDescription() {
        return this.decorated.getDescription() + " " + super.getDescription();
    }
}
