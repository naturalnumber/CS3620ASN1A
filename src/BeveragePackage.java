public class BeveragePackage extends RoomAddon {
    protected BeveragePackage(Room toDecorate) {
        super("Beverage Package", 700d,
              "This booking includes the coveted beverage package, " +
              "featuring unlimited kool-aid.",
              toDecorate);
    }
}
