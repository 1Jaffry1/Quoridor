package Back;

import java.util.ArrayList;

public class Board {
    private final int height; //not count ing zero, will be 9 at end. same for width
    private final int width;
    public ArrayList<Node> grid;
    public Board(int h, int w, ArrayList<Node> grid ){
        height = h;
        width = w;
        this.grid = grid;
        Node.setPlayerIsHere();
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    @Override
    public String toString() {
        for (int i = 0; i<9; i++){
            for (int j = 0; j< 9; j++){
                System.out.print(Node.getNodeByCoordinates(i,j)+ "   ");
            }
            System.out.println("\n");
        }
        return "";
    }
}