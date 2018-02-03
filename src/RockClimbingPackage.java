public class RockClimbingPackage extends RoomAddon {
    protected RockClimbingPackage(Room toDecorate) {
        super("Rock Climbing Lessons", 60d,
              "This booking includes rock climbing lessons, " +
              "taught by Tom Cruise's own stunt doub- er... partner." +
              "(By purchasing this package you formally agree that Tom Cruise has never " +
              "had a stunt double.)",
              toDecorate);
    }
}
