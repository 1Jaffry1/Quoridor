package Back;

import java.util.ArrayList;

public class Player {
    //    public static Player noPlayer = new Player(-1, "none");
    public static ArrayList<Player> players = new ArrayList<>();
    private final String goal; //top or bottom
    private int name;
    private Node location;
    private int wallsRemaining = 10;


    public Player(int name, String goal) {
        this.name = name;
        this.goal = goal;
        if (goal.equals("top")) {
            setLocation(Node.getNodeByName(84));
        } else if (goal.equals("bottom")) {
            setLocation(Node.getNodeByName(4));
        }
        players.add(this);
    }

    public Node getLocation() {
        return location;
    }

    public void setLocation(Node n) {
        location = n;
    }

    public void moveUp() {
        this.setLocation(location.moveUp());
    }

    public void moveDown() {
        this.setLocation(location.moveDown());
    }

    public void moveRight() {
        this.setLocation(location.moveRight());
    }

    public void moveLeft() {
        this.setLocation(location.moveLeft());
    }

    public String getGoal() {
        return goal;
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

    public boolean hasPath() {
        if (this.getLocation() == null)
            return false;
        return this.getLocation().hasPath(this.goal);
    }

    public boolean isLegalWalk(Node n) {
        for (Node i : this.getLocation().neighbors) {
            if (i.equals(n) && !i.isPlayerIsHere() && !this.getLocation().equals(n)) return true;
            else if (i.isPlayerIsHere() && (n.getJ() == this.getLocation().getJ() + 2 || n.getI() == this.getLocation().getI() + 2) && i.isNeighbor(n))
                return true;
//            else if (i.isPlayerIsHere() )
        }

        return false;
    }
}


