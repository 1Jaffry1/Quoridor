package Back;

import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Board board = new Board();

        //we can also add the players here

        //adding all neighbors
//        for (Node n : board.grid) {
//            if (n.moveUp() != null) n.neighbors.add(n.moveUp());
//            if (n.moveDown() != null) n.neighbors.add(n.moveDown());
//            if (n.moveRight() != null) n.neighbors.add(n.moveRight());
//            if (n.moveLeft() != null) n.neighbors.add(n.moveLeft());

        Player playerone = new Player("ID1", "bottom"); //he starts at the top //4
        Player playertwo = new Player("ID2", "top"); // he starts a// t the bottom //84
        Game game = new Game(board, playerone, playertwo);


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
//            String move = "";
            String move = scanner.nextLine();
            switch (move) {
                case "w":
                    if (cnt == 1 && playerone.isLegalWalk(playerone.getLocation().moveUp())) {
                        playerone.moveUp();
                        cnt++;
                    } else if (cnt == 2 && playertwo.isLegalWalk(playertwo.getLocation().moveUp())) {
                        playertwo.moveUp();
                        cnt--;
                    }
                    break;

                case "s":
                    if (cnt == 1 && playerone.isLegalWalk(playerone.getLocation().moveDown())) {
                        playerone.moveDown();
                        cnt++;
                    } else if (cnt == 2 && playertwo.isLegalWalk(playertwo.getLocation().moveDown())) {
                        playertwo.moveDown();
                        cnt--;
                    }
                    break;

                case "d":
                    if (cnt == 1 && playerone.isLegalWalk(playerone.getLocation().moveRight())) {
                        playerone.moveRight();
                        cnt++;
                    } else if (cnt == 2 && playertwo.isLegalWalk(playertwo.getLocation().moveRight())) {
                        playertwo.moveRight();
                        cnt--;
                    }
                    break;

                case "a":
                    if (cnt == 1 && playerone.isLegalWalk(playerone.getLocation().moveLeft())) {
                        playerone.moveLeft();
                        cnt++;
                    } else if (cnt == 2 && playertwo.isLegalWalk(playertwo.getLocation().moveLeft())) {
                        playertwo.moveLeft();
                        cnt--;
                    }
                    break;

                case "q":
                    System.exit(0);
                    break;

                case "save":
                    String name = scanner.nextLine();
                    game.save(name);
                    System.out.println(Wall.wallsplaced);
                    System.exit(0);
                case "load":
                    String name2 = scanner.nextLine();
                    game.load(name2);
                    break;
                default:
                    new Wall(move);
                    if (cnt == 1) {
                        playerone.setWallsRemaining(playerone.getWallsRemaining() - 1);
                        cnt++;
                    } else if (cnt == 2) {
                        playertwo.setWallsRemaining(playertwo.getWallsRemaining() - 1);
                        cnt--;
                    }
                    break;

            }
            if (Node.bottomNodes.contains(playerone.getLocation())) {
                    System.out.println("Player one wins!");
                    game.win = true;
                    game.winner = playerone;
            } else if (Node.topNodes.contains(playertwo.getLocation())) {
                    System.out.println("Player two wins!");
                    game.win = true;
                    game.winner = playertwo;
            }

        }
    }

}


//fix nonode addition to neighbors : done, now it adds itself