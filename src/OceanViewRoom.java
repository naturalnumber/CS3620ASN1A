public class OceanViewRoom extends Room {
    public static final String name = "Ocean View Room";
    public static final double price = 1500d;
    public static final String description =
            "A room with a view of the ocean and its carefree inhabitants. " +
            "In addition to the features of the interior room, this room comes " +
            "pre-stocked with an automatic, looped audio-book version of " +
            "Dianetics so you too can learn to be as carefree as an ocean creature. " +
            "(Audio-book may be paused for up to 2 hours for a nominal fee of 10$!) " +
            "(As per safety doctrine 28.AF67G, volume may not be adjusted.) " +
            "(Complementary braille sheets included free of charge for all customers " +
            "with hearing impairments.)";

    protected OceanViewRoom() {
        super(name, price, description);
    }
}
