package Back;

public class Move {
    public static void moveUp(Player p) {
        if (p.getLocation().moveUp() != null) {
            p.setLocation(p.getLocation().moveUp());
        }
    }
    public static void moveDown(Player p) {
        if (p.getLocation().moveDown() != null) {
            p.setLocation(p.getLocation().moveDown());
        }
    }
    public static void moveRight(Player p) {
        if (p.getLocation().moveRight() != null) {
            p.setLocation(p.getLocation().moveRight());
        }
    }
    public static void moveLeft(Player p) {
        if (p.getLocation().moveLeft() != null) {
            p.setLocation(p.getLocation().moveLeft());
        }
    }
}
