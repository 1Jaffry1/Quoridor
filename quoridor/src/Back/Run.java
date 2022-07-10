package Back;

import java.util.ArrayList;
import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        ArrayList<Node> main = new ArrayList<>();
        Board board = new Board(9, 9, main);
        Player playerone = new Player(1, "bottom"); //he starts at the top
        Player playertwo = new Player(2, "top"); // he starts at the bottom
        Game game = new Game(board, playerone, playertwo);



        for (int i = 0; i < board.getHeight(); i++) {
            for (int j = 0; j < board.getWidth(); j++) {
                board.grid.add(new Node(i, j));
            }
        }
        //adding all neighbors
        for (Node n : board.grid) {
            try {
                n.neighbors.add(n.moveUp());
            } catch (Exception e) {
                System.out.println("Border cell");
            }
            try {
                n.neighbors.add(n.moveDown());
            } catch (Exception e) {
                System.out.println("Border cell");
            }
            try {
                n.neighbors.add(n.moveRight());
            } catch (Exception e) {
                System.out.println("Border cell");
            }
            try {
                n.neighbors.add(n.moveLeft());
            } catch (Exception e) {
                System.out.println("Border cell");
            }
        }

        for (int j = 0; j < 9; j++) Node.topNodes.add(Node.getNodeByCoordinates(0, j));
        for (int j = 0; j < 9; j++) Node.bottomNodes.add(Node.getNodeByCoordinates(8, j));
        //from file: import Arraylist(walls)
//        for (Wall wall : new ArrayList<Wall>()){  //change this to loaded array list
//            wall.placeWall();
//        }

        System.out.println(board.grid); //test
        Scanner scanner = new Scanner(System.in);
        System.out.println(Node.bottomNodes);
        System.out.println(Node.topNodes);

    }
}


//fix nonode addition to neighbors
