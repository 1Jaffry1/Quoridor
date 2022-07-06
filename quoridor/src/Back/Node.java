package Back;

public class Node {
    private final int x;
    private final int y;
    private int player;

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
        return 10 * x + y;
    }

    public static boolean tophaspath(Node n) {
        if (n.player == 1) {
            if (n.x == Board.getHeight() - 1) {
                return true;
            }
            else return(tophaspath(new Node(n.x, n.y+1)));
        }
        return false;
    }
}
