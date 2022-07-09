package Back;

import java.util.ArrayList;

public class Board {
    private static int Height; //not count ing zero, will be 9 at end. same for width
    private static int Width;
    public ArrayList<Node> nodes = new ArrayList<Node>();

    public static int getHeight() {
        return Height;
    }

    public int getWidth() {
        return Width;
    }
}