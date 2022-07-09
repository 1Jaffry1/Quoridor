package Back;

import java.util.ArrayList;

public class Node {
    private final int x;
    private final int y;
    public static ArrayList<Node> nodes = new ArrayList<>();
    public ArrayList<Node> neighbors = new ArrayList<>();
    public ArrayList<Edge> edges = new ArrayList<>();
    private boolean playerIsHere;
    static Node noNode = new Node(-2, -2);

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public static Node getNodeByCoordinates(int x, int y) {
        for (Node n : nodes) {
            if (n.getX() == x && n.getY() == y) {
                return n;
            }
        }
        return noNode;
    }

    @Override
    public String toString() {
        return x + "" + y;
    }

    public int printPosition() {
        return 10 * y + x;
    }

    public boolean hasPath(String n) { //temp placeholder
        if (n.equals("top")) {
            ArrayList<Node> visited = new ArrayList<>();
            visited.add(this);
            for (int i = 0; i < visited.size(); i++) {
                for (Node neighbor : visited.get(i).neighbors) {
                    if (!visited.contains(neighbor)) visited.add(neighbor);
                }
            }
            ArrayList<Node> top = new ArrayList<>();
            for (int x = 0; x < 9; x++) top.add(getNodeByCoordinates(x, 8));
            for (Node v : top) {
                if (visited.contains(v)) return true;
            }
        }
        if (n.equals("bottom")) {
            ArrayList<Node> visited = new ArrayList<>();
            visited.add(this);
            for (int i = 0; i < visited.size(); i++) {
                for (Node neighbor : visited.get(i).neighbors) {
                    if (!visited.contains(neighbor)) visited.add(neighbor);
                }
            }
            ArrayList<Node> bottom = new ArrayList<>();
            for (int x = 0; x < 9; x++) bottom.add(getNodeByCoordinates(x, 0));
            for (Node v : bottom) {
                if (visited.contains(v)) return true;
            }
        }
        return false;
    }

    public boolean isLegalWalk(Node n) {
        for (Node i : this.neighbors) {
            if (i.equals(n)) return true;
        }
        return false;
    }

    public Node moveUpwards() {
        return new Node(this.x, this.y + 1);
    }
}
