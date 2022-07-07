package Back;

import java.util.ArrayList;

public class Node {
    private final int x;
    private final int y;
    public static ArrayList<Node> nodes = new ArrayList<Node>();
    public ArrayList<Node> neighbors = new ArrayList<Node>();
    public ArrayList<Edge> edges = new ArrayList<Edge>();
    private int playerishere;
    private int topvalue = 1;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
    static Node none = new Node (-1, -1);
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public static Node getNodeByCoordinates(int x, int y){
        for (Node n : nodes){
            if (n.getX() == x && n.getY() == y){
                return n;
            }
        }
        return none;
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
        for (Node i : this.neighbors) {
            if (i.equals(n)) return true;
        }
        return false;
    }

    public Node moveupwards() {
        return new Node(this.x, this.y + 1);
    }
}
