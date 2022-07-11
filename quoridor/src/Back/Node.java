package Back;

import java.util.ArrayList;

public class Node {
    public static ArrayList<Node> nodes = new ArrayList<>();
    public static ArrayList<Node> topNodes = new ArrayList<>();
    public static ArrayList<Node> bottomNodes = new ArrayList<>();
    private final int j;
    private final int i;
    public ArrayList<Node> visited = new ArrayList<>();
    public ArrayList<Node> neighbors = new ArrayList<>();
    private boolean playerIsHere;

    public Node(int i, int j) {
        this.j = j;
        this.i = i;
        if (i != -2 && j != -2) {
            nodes.add(this);
        }
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
        return null;
    }

    public static void setPlayerIsHere() {
        for (Node i : Node.nodes) {
            i.playerIsHere = false;
        }
        for (Player p : Player.players) {
            p.getLocation().playerIsHere = true;
        }
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
        return getNodeByCoordinates(i - 1, j);

    }

    public Node moveDown() {
        return getNodeByCoordinates(i + 1, j);

    }

    public Node moveRight() {
        return getNodeByCoordinates(i, j + 1);
    }

    public Node moveLeft() {
        return getNodeByCoordinates(i, j - 1);

    }

    public boolean isPlayerIsHere() {
        return playerIsHere;
    }

    public boolean isNeighbor(Node n) {
        for (Node i : neighbors) {
            if (i.equals(n)) return true;
        }
        return false;
    }
}
