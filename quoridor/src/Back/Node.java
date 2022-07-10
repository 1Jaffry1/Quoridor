package Back;

import java.util.ArrayList;

public class Node {
    public static ArrayList<Node> nodes = new ArrayList<>();
    static Node noNode = new Node(-2, -2);
    private final int x;
    private final int y;
    public ArrayList<Node> neighbors = new ArrayList<>();
    //    public ArrayList<Edge> edges = new ArrayList<>();
    private boolean playerIsHere;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
        nodes.add(this);
    }
    public Node(int m){
        this.y = m/10;
        this.x = m%10;
        nodes.add(this);
    }

    public static Node getNodeByCoordinates(int x, int y) {
        for (Node n : nodes) {
            if (n.getX() == x && n.getY() == y) {
                return n;
            }
        }
        return noNode;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return x + "" + y;
    }

    public int printPosition() {
        return 10 * y + x;
    }

    public boolean hasPath(String n) {
        ArrayList<Node> visited = new ArrayList<>();
        visited.add(this);
        for (int i = 0; i < visited.size(); i++) {
            for (Node neighbor : visited.get(i).neighbors) {
                if (!visited.contains(neighbor)) visited.add(neighbor);
            }
        }
        if (n.equals("bottom")) {
            ArrayList<Node> bottom = new ArrayList<>();
            for (int x = 0; x < 9; x++) bottom.add(getNodeByCoordinates(x, 0));
            for (Node v : bottom) {
                if (visited.contains(v)) return true;
            }
        }
        if (n.equals("top")) {
            ArrayList<Node> top = new ArrayList<>();
            for (int x = 0; x < 9; x++) top.add(getNodeByCoordinates(x, 8));
            for (Node v : top) {
                if (visited.contains(v)) return true;
            }
        }
        return false;
    }


    public Node moveUp() {
        return getNodeByCoordinates(this.x, this.y - 1);
    }

    public Node moveDown() {
        return getNodeByCoordinates(this.x, this.y + 1);
    }

    public Node moveRight() {
        return getNodeByCoordinates(this.x + 1, this.y);
    }

    public Node moveLeft() {
        return getNodeByCoordinates(this.x - 1, this.y);
    }

    public boolean isPlayerIsHere() {
        return playerIsHere;
    }

    public void setPlayerIsHere(boolean playerIsHere) {
        this.playerIsHere = playerIsHere;
    }

    public boolean isNeighbor(Node n) {
        for (Node i : neighbors) {
            if (i.equals(n)) return true;
        }
        return false;
    }
}
