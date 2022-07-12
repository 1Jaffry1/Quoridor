package Back;

import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Board board = new Board();

            //we can also add the players here

        //adding all neighbors
        for (Node n : board.grid) {
            if (n.moveUp() != null) n.neighbors.add(n.moveUp());
            if (n.moveDown() != null) n.neighbors.add(n.moveDown());
            if (n.moveRight() != null) n.neighbors.add(n.moveRight());
            if (n.moveLeft() != null) n.neighbors.add(n.moveLeft());
        }
        Player playerone = new Player("ID1", "bottom"); //he starts at the top //4
        Player playertwo = new Player("ID2", "top"); // he starts a// t the bottom //84
        Game game = new Game(board, playerone, playertwo);

        for (int j = 0; j < 9; j++) Node.topNodes.add(Node.getNodeByCoordinates(0, j));
        for (int j = 0; j < 9; j++) Node.bottomNodes.add(Node.getNodeByCoordinates(8, j));
        System.out.println(board);
        //from file: import Arraylist(walls)
//        for (Wall wall : new ArrayList<Wall>()){  //change this to loaded array list
//            wall.placeWall();
//        }
//        Wall wall1 = new Wall("10h");
////        playerone.setLocation(Node.getNodeByName(1));
////        System.out.println(playerone.getLocation());
//        Wall wall2 = new Wall("11v");
//        System.out.println(playerone.hasPath());
//        System.out.println(Wall.wallsplaced);
        int cnt = 1; //oscillates between 1 and 2
        while (!game.win) {
            String move = scanner.nextLine();
            switch (move) {
                case "w":
                    if (cnt == 1) {
                        playerone.moveUp();
                        cnt++;
                    } else {
                        playertwo.moveUp();
                        cnt--;
                    }
                    break;
                case "s":
                    if (cnt == 1) {
                        playerone.moveDown();
                        cnt++;
                    } else {
                        playertwo.moveDown();
                        cnt--;
                    }
                    break;
                case "a":
                    if (cnt == 1) {
                        playerone.moveLeft();
                        cnt++;
                    } else {
                        playertwo.moveLeft();
                        cnt--;
                    }
                    break;
                case "d":
                    if (cnt == 1) {
                        playerone.moveRight();
                        cnt++;
                    } else {
                        playertwo.moveRight();
                        cnt--;
                        break;
                    }
                case "q":
                    System.exit(0);
                    break;
                default:
                    new Wall(move);
            }

        }
    }

}


//fix nonode addition to neighbors : done, now it adds itself