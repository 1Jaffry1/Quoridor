package Back;

import java.util.ArrayList;

public class Board {
    private int height; //not count ing zero, will be 9 at end. same for width
    private int width;
    public ArrayList<Node> grid;
    public Board(int h, int w, ArrayList<Node> grid ){
        height = h;
        width = w;
        this.grid = grid;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}