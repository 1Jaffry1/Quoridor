package Back;

import java.util.ArrayList;

public class Player {
    public static ArrayList<Player> players = new ArrayList<>();
    private final String goal; //top or bottom
    private String name;
    private Node location;
    private int wallsRemaining = 10;


    public Player(String name, String goal) {
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
        Node.setPlayerIsHere();
    }

    public void moveUp() {
//        if (this.location.neighbors.contains(this.location.moveUp()))
        if (isLegalWalk(this.location.moveUp())) {
            this.location = this.location.moveUp();
            Node.setPlayerIsHere();

        }
    }

    public void moveDown() {
//        if (this.location.neighbors.contains(this.location.moveDown()))
        if(isLegalWalk(this.location.moveDown())) {
            this.location = this.location.moveDown();
            Node.setPlayerIsHere();
        }
    }

    public void moveRight() {
//        if (this.location.neighbors.contains(this.location.moveRight()))
        if (isLegalWalk(this.location.moveRight())) {
            this.location = this.location.moveRight();
            Node.setPlayerIsHere();

        }
    }

    public void moveLeft() {
//        if (this.location.neighbors.contains(this.location.moveLeft()))
        if(isLegalWalk(this.location.moveLeft())) {
            this.location = this.location.moveLeft();
            Node.setPlayerIsHere();

        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWallsRemaining() {
        return wallsRemaining;
    }

    public void setWallsRemaining(int wallsRemaining) {
        this.wallsRemaining = wallsRemaining;
    }

    public boolean hasPath() {
        if (this.getLocation() == null) return false;
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


