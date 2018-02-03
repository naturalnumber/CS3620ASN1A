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
        return this.decorated.getPrice() * TAX_RATE_ADDON + super.getTax();
    }

    @Override
    public String getName() {
        return this.decorated.getName() + " + " + super.getName();
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " " + this.decorated.getDescription();
    }
}
