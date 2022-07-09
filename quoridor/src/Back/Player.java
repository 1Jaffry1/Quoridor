package Back;

import java.util.ArrayList;

public class Player {
    public static Player noPlayer = new Player(-1, "none", Node.noNode);
    public static ArrayList<Player> players = new ArrayList<>();
    private final String role; //top or bottom
    private int name;
    private Node location;
    private int wallsRemaining = 10;

    public Player(int name, String role, Node location) {
        this.name = name;
        this.role = role;
        this.location = location;
    }

    public static Player getplayerwithname(int name) {
        for (Player p : Player.players) {
            if (p.getName() == name) {
                return p;
            }
        }
        return noPlayer;
    }

    public Node getLocation() {
        return location;
    }

    public void setLocation(Node n) {
        location = n;
    }

    public Node Moveupwards() {
        location = new Node(location.getX(), location.getY() + 1);
        return location;
    }

    public String getRole() {
        return role;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public int getWallsRemaining() {
        return wallsRemaining;
    }

    public void setWallsRemaining(int wallsRemaining) {
        this.wallsRemaining = wallsRemaining;
    }

    public boolean haspath() {
        return this.getLocation().hasPath(this.role);
    }

    public boolean isLegalWalk(Node n) {
        for (Node i : this.getLocation().neighbors) {
            if (i.equals(n) && !i.isPlayerIsHere()) return true;
            else if (i.isPlayerIsHere() && (n.getX() == this.getLocation().getX() + 2 || n.getY() == this.getLocation().getY() + 2) && i.isNeighbor(n))
                return true;
//            else if (i.isPlayerIsHere() )
        }

        return false;
    }
}


