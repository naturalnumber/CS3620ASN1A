/**
 * Interior room - $1000
 • Ocean view room - $1500
 • Balcony room - $2000
 • Suite - $3000
 */
public abstract class Room {
    public static final double TAX_RATE_ROOM = .16d;

    private double price;
    private String name;
    private String description;

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
}
