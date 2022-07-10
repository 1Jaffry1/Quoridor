package Back;

import java.util.ArrayList;

public class Node {
    public static ArrayList<Node> nodes = new ArrayList<>();
    public static ArrayList<Node> topNodes = new ArrayList<>();
    public static ArrayList<Node> bottomNodes = new ArrayList<>();
    static Node noNode = new Node(-2, -2);
    private final int j;
    private final int i;
    public ArrayList<Node> visited = new ArrayList<>();
    public ArrayList<Node> neighbors = new ArrayList<>();
    //    public ArrayList<Edge> edges = new ArrayList<>();
    private boolean playerIsHere;

    public Node(int i, int j) {
        this.j = j;
        this.i = i;
        nodes.add(this);
    }

    public Node(int m) {
        this.i = m / 10;
        this.j = m % 10;
        nodes.add(this);
    }

    public static Node getNodeByName(int m) {
        return getNodeByCoordinates(m / 10, m % 10);
    }

    public static Node getNodeByCoordinates(int i, int j) {
        for (Node n : nodes) {
            if (n.getJ() == j && n.getI() == i) {
                return n;
            }
        }
        return noNode;
    }

    public int getJ() {
        return j;
    }

    public int getI() {
        return i;
    }

    @Override
    public String toString() {
        return i + "" + j;
    }

    public int position() {
        return 10 * i + j;
    }

    public boolean hasPath(String n) {
        visited.add(this);
        for (int i = 0; i < visited.size(); i++) {
            for (Node neighbor : visited.get(i).neighbors) {
                if (!visited.contains(neighbor)) visited.add(neighbor);
            }
        }
        if (n.equals("bottom")) {
            for (Node v : bottomNodes) {
                if (visited.contains(v)) return true;
            }
        }
        if (n.equals("top")) {
            for (Node v : topNodes) {
                if (visited.contains(v)) return true;
            }
        }
        return false;
    }


    public Node moveUp() {
        Node temp = getNodeByCoordinates(i - 1, j);
        if (temp.equals(noNode)) return this;
        return temp;
    }

    public Node moveDown() {
        Node temp = getNodeByCoordinates(i + 1, j);
        if (temp.equals(noNode)) return this;
        return temp;
    }

    public Node moveRight() {
        Node temp = getNodeByCoordinates(i, j + 1);
        if (temp.equals(noNode)) return this;
        return temp;
    }

    public Node moveLeft() {
        Node temp = getNodeByCoordinates(i, j - 1);
        if (temp.equals(noNode)) return this;
        return temp;
    }

    public boolean isPlayerIsHere() {
        return playerIsHere;
    }

    public void setPlayerIsHere() {
        this.playerIsHere = false;
        for (Player i : Player.players)
            if (i.getLocation().equals(this)) {
                this.playerIsHere = true;
                break;
            }
    }

    public boolean isNeighbor(Node n) {
        for (Node i : neighbors) {
            if (i.equals(n)) return true;
        }
        return false;
    }
}
