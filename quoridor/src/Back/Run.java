package Back;

import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Board board = new Board();
        int cnt = 1; //oscillates between 1 and 2
        Player playerone = new Player("PlayerOne", "bottom"); //he starts at the top //4
        Player playertwo = new Player("PlayerTwo", "top"); // he starts at the bottom //84
        Game game = new Game("game1", null, playerone, playertwo);
        game.win = false;
        System.out.println("Welcome to QUORIDOR!\nChoose a mode: new or load");

        do {
            String move = scanner.nextLine();
            if (cnt ==2) System.out.println("--------"+playerone.getName()+"'s turn---------");
            else System.out.println("--------"+playertwo.getName()+"'s turn----------");
            switch (move) {
                case "new":
                    System.out.println("Player one's name: ");
                    playerone.setName(scanner.nextLine());
                    System.out.println("Player two's name: ");
                    playertwo.setName(scanner.nextLine());
                    break;
                case "save":
                    String name = scanner.nextLine();
                    game.save(name);
                    System.exit(0);
                    break;

                case "load":
                    String name2 = scanner.nextLine();
                    try {
                        game = Game.load(name2);
                        game.win = false;
                    } catch (NullPointerException e) {
                        System.out.println("No game found");
//                        game = new Game("game1", null, playerone, playertwo);
//                        game.win = true;
                        System.exit(1);
                    }
                    break;


                case "w":
                    if (cnt == 1 && playerone.isLegalWalk(playerone.getLocation().moveUp())) {
                        playerone.moveUp();
                        cnt++;
                    } else if (cnt == 2 && playertwo.isLegalWalk(playertwo.getLocation().moveUp())) {
                        playertwo.moveUp();
                        cnt--;
                    } else {
                        System.out.println("ILLEGAL MOVE");
                        break;
                    }
                    break;

                case "s":
                    if (cnt == 1 && playerone.isLegalWalk(playerone.getLocation().moveDown())) {
                        playerone.moveDown();
                        cnt++;
                    } else if (cnt == 2 && playertwo.isLegalWalk(playertwo.getLocation().moveDown())) {
                        playertwo.moveDown();
                        cnt--;
                    } else {
                        System.out.println("ILLEGAL MOVE");
                        break;
                    }
                    break;

                case "d":
                    if (cnt == 1 && playerone.isLegalWalk(playerone.getLocation().moveRight())) {
                        playerone.moveRight();
                        cnt++;
                    } else if (cnt == 2 && playertwo.isLegalWalk(playertwo.getLocation().moveRight())) {
                        playertwo.moveRight();
                        cnt--;
                    } else {
                        System.out.println("ILLEGAL MOVE");
                        break;
                    }
                    break;

                case "a":
                    if (cnt == 1 && playerone.isLegalWalk(playerone.getLocation().moveLeft())) {
                        playerone.moveLeft();
                        cnt++;
                    } else if (cnt == 2 && playertwo.isLegalWalk(playertwo.getLocation().moveLeft())) {
                        playertwo.moveLeft();
                        cnt--;
                    } else {
                        System.out.println("ILLEGAL MOVE");
                        break;
                    }
                    break;

                case "q":
                    System.exit(0);
                    break;

                default:
                    try {
                        new Wall(move);
                    } catch (Exception e) {
                        System.out.println("WHAT IS THIS");
                        break;
                    }
                    if (Wall.wallsplaced.contains(Wall.getWallWithName(move))) {
                        if (cnt == 1) {
                            playerone.setWallsRemaining(playerone.getWallsRemaining() - 1);
                            cnt++;
                        } else if (cnt == 2) {
                            playertwo.setWallsRemaining(playertwo.getWallsRemaining() - 1);
                            cnt--;
                        }
                    }
                    break;
            }
            if (Node.bottomNodes.contains(playerone.getLocation())) {
                System.out.println("Player one wins!");
                game.win = true;
//                game.winner = playerone;

            } else if (Node.topNodes.contains(playertwo.getLocation())) {
                System.out.println("Player two wins!");
                game.win = true;
//                game.winner = playertwo;
            }
            System.out.println("player one: " + playerone.getLocation());
            System.out.println("player two: " + playertwo.getLocation());
            System.out.println("player one's walls: " + playerone.getWallsRemaining());
            System.out.println("player two's walls: " + playertwo.getWallsRemaining());
            System.out.println(Wall.wallsplaced);

        } while (!game.win);
    }
}
