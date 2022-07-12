package Back;

import java.util.ArrayList;

public class Board {
    private final int height = 9; //not count ing zero, will be 9 at end. same for width
    private final int width = 9;
    private final Wall[][] Hwalls = new Wall[height - 2][width - 1];
    private final Wall[][] Vwalls = new Wall[height - 1][width - 2];
    private final Node[][] nodes = new Node[height][width];
    public ArrayList<Node> grid;
    public Player[] players = new Player[2];


    public Board() {
        createCell();
        createWall();
        createPlayer();
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
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(Node.getNodeByCoordinates(i, j) + "   ");
            }
            System.out.println("\n");
        }
        return "";
    }

    private void createCell(){
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                nodes[i][j] = new Node(i, j);
            }
        }
    }
    private void createWall(){
        //create hwalls
        for (int i = 0 ; i<height-2; i++){
            for (int j = 0 ;j< width -1 ;j++)
                Hwalls[i][j] = new Wall(Node.getNodeByCoordinates(i,j),"h");
        }
        //create vwalls
        for (int i  = 0; i< height - 1; i++)
            for(int j = 0; j < width -2; j++)
                Vwalls[i][j] = new Wall(Node.getNodeByCoordinates(i,j),"v");
    }
    private void createPlayer(){
        players[0] = new Player(Node.getNodeByCoordinates(0,8),0);
        players[1] = new Player(Node.getNodeByCoordinates(8,8),1);
    }

}