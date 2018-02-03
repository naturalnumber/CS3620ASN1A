public class LumberjackPackage extends RoomAddon {
    protected LumberjackPackage(Room toDecorate) {
        super("Lumberjack Competition Admission", 15d,
              "This booking includes admission to a lumberjack competition, " +
              "judged by the one and only Tom Cruise himself!" +
              "(By participating in this competition, attractive contestants consent to " +
              "any sexual advances or sham marriage proposals that arise.)",
              toDecorate);
    }
}
