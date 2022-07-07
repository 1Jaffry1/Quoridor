package Back;

import java.util.ArrayList;

public class Node {
    private final int x;
    private final int y;
    ArrayList<Node> neighbors = new ArrayList<Node>();
    ArrayList<Edge> edges = new ArrayList<Edge>();
    private int playerishere;
    private int topvalue = 1;

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

    @Override
    public String toString() {
        return x + "" + y;
    }

    public int show() {
        return 10 * y + x;
    }

    public static boolean tophaspath(Node n) {
        if (n.playerishere == 1) {
            if (n.y == Board.getHeight() - 1)  //base case
                return true;
            return tophaspath(n.moveupwards());
//            return (tophaspath(new Node(n.x - 1, n.y)));
        }
        return false;
    }

    public boolean islegalwalk(Node n) {
        for (Node i : neighbors) {
            if (i.equals(n)) return true;
        }
        return false;
    }

    public Node moveupwards() {
        return new Node(this.x, this.y + 1);
    }
}
