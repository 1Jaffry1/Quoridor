package Back;

import java.util.ArrayList;

public class Board {
    private final int height = 9; //not count ing zero, will be 9 at end. same for width
    private final int width = 9;
    public ArrayList<Node> grid;

    public Board(ArrayList<Node> main) {
    }
//    public Player[] players = new Player[2];



    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    @Override
    public String toString() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(Node.getNodeByCoordinates(i, j) + "   ");
            }
            System.out.println("\n");
        }
        return "";
    }
}