package Back;

import java.util.ArrayList;
import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        ArrayList<Node> main = new ArrayList<>();
        Board board = new Board(9, 9, main);


        for (int i = 0; i < board.getHeight(); i++) {
            for (int j = 0; j < board.getWidth(); j++) {
                board.grid.add(new Node(i, j));
            }
        }
        //adding all neighbors
        for (Node n : board.grid) {
            if (n.moveUp() != null)
                n.neighbors.add(n.moveUp());
            if (n.moveDown() != null)
                n.neighbors.add(n.moveDown());
            if (n.moveRight() != null)
                n.neighbors.add(n.moveRight());
            if (n.moveLeft() != null)
                n.neighbors.add(n.moveLeft());

        }
        Player playerone = new Player(1, "bottom"); //he starts at the top
        Player playertwo = new Player(2, "top"); // he starts at the bottom
        Game game = new Game(board, playerone, playertwo);

        for (int j = 0; j < 9; j++) Node.topNodes.add(Node.getNodeByCoordinates(0, j));
        for (int j = 0; j < 9; j++) Node.bottomNodes.add(Node.getNodeByCoordinates(8, j));
        //from file: import Arraylist(walls)
//        for (Wall wall : new ArrayList<Wall>()){  //change this to loaded array list
//            wall.placeWall();
//        }

//        System.out.println(board.grid); //test
        Scanner scanner = new Scanner(System.in);
        String one = "10h";
        String two = "11v";
        System.out.println(playerone.getLocation());
        System.out.println(playertwo.getLocation());
        playerone.setLocation(Node.getNodeByName(01));
        Wall wall = new Wall(one);
        Wall wall2 = new Wall(two);
        Wall wall3 = new Wall("43h");
        System.out.println(Node.getNodeByName(01).isNeighbor(Node.getNodeByName(02)));
        System.out.println(Node.getNodeByName(01).hasPath("bottom"));
        System.out.println(Wall.wallsplaced);
        System.out.println(Node.getNodeByName(0).isNeighbor(Node.getNodeByName(10)));
        System.out.println(Node.getNodeByName(0).isNeighbor(Node.getNodeByName(1)));


    }
}


//fix nonode addition to neighbors : done, now it adds itself