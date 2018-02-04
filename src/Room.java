/**
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

    public double getPrice() {
        return price;
    }

    public double getTax() {
        return price * TAX_RATE_ROOM;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    protected boolean hasDecoration() {
        return this.decoration != null;
    }

    protected RoomAddon getDecoration() {
        return decoration;
    }

    protected boolean setDecoration(RoomAddon decoration) {
        if (decoration != null && !hasDecoration()) {
            this.decoration = decoration;
            return hasDecoration();
        }

        return false;
    }

    protected Room replaceDecoration(RoomAddon decoration) {
        this.decoration = decoration;
        return this.getTop();
    }

    protected <T extends RoomAddon> Room removeAddon(Class<T> addon) {
        return this.getTop();
    }

    protected Room replaceRoom(Room newRoom) {
        if (newRoom != null && !(newRoom instanceof RoomAddon)) {
            if (hasDecoration()) {
                this.decoration.replaceDecorated(newRoom);
                return this.decoration.getTop();
            }

            return newRoom.replaceDecoration(this.decoration);
        }

        return this.getTop();
    }

    protected Room getTop() {
        return (hasDecoration()) ? this.decoration.getTop() : this;
    }

    protected Room getBase() {
        return this;
    }
}

/*




    protected Room remove() {
        return this;
    }

 */