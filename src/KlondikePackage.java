public class KlondikePackage extends RoomAddon {
    protected KlondikePackage(Room toDecorate) {
        super("Klondike Package", 50d,
              "This booking includes the Klondike trail guided horseback tour, " +
              "featuring horses trained only to balk with suppressive riders. " +
              "(All suppressive riders with be handed over to Sea Org members on standby.)",
              toDecorate);
    }
}
