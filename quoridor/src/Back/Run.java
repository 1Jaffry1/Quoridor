package Back;

public class Run {
    public static void main(String[] args) {
        Board board = new Board();

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                board.nodes.add(new Node(i, j));
            }
        }
        //adding all neighbors
        for (Node n : board.nodes) {
            for (Node m : board.nodes) {
                if (n.getX() == m.getX() && n.getY() == m.getY() + 1) {
                    n.neighbors.add(m);
                }
                if (n.getX() == m.getX() + 1 && n.getY() == m.getY()) {
                    n.neighbors.add(m);
                }
                if (n.getX() == m.getX() - 1 && n.getY() == m.getY()) {
                    n.neighbors.add(m);
                }
                if (n.getX() == m.getX() && n.getY() == m.getY() - 1) {
                    n.neighbors.add(m);
                }
            }
        }

    }
}

