package Back;

import java.util.ArrayList;

public class Board {
    private static int Height; //not count ing zero, will be 9 at end. same for width
    private static int Width;
    public ArrayList<Node> nodes = new ArrayList<Node>();
//    for (int i = 0; i<4; i++){
//        for (int j = 0; j<4; j++){
//            nodes.add(new Node(i,j));
//        }
//    } //for main

    public static int getHeight() {
        return Height;
    }

    public int getWidth() {
        return Width;
    }
}