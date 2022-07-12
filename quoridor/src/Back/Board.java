package Back;

import java.util.ArrayList;

public class Board {
    private final int height = 9; //not count ing zero, will be 9 at end. same for width
    private final int width = 9;
    public ArrayList<Node> grid;
    public Game g;

    public Board() {
        this.grid = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                this.grid.add(new Node(i, j));
            }
        }
        for (Node n : this.grid) {
            if (n.moveUp() != null) n.neighbors.add(n.moveUp());
            if (n.moveDown() != null) n.neighbors.add(n.moveDown());
            if (n.moveRight() != null) n.neighbors.add(n.moveRight());
            if (n.moveLeft() != null) n.neighbors.add(n.moveLeft());
        }
        for (int j = 0; j < width; j++) {
            Node.bottomNodes.add(Node.getNodeByCoordinates(8, j));
            Node.topNodes.add(Node.getNodeByCoordinates(0, j));
        }
    }


    @Override
    public String toString() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(Node.getNodeByCoordinates(i, j) + "   ");
            }
            System.out.println("\n");
        }
        return "";
    }
}