public class HelicopterPackage extends RoomAddon {
    protected HelicopterPackage(Room toDecorate) {
        super("Helicopter Package", 200d,
              "This booking includes the helicopter glacier tour, " +
              "featuring a reenactment of Xenu's exile of aliens on ancient earth. " +
              "(The return of helicopters after mandatory exile reenactment is only " +
              "guaranteed for church members.)",
              toDecorate);
    }
}
