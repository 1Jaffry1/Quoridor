// this is the class that will handle the info to save and load;

package Back;

import java.util.ArrayList;

public class Game {
    public boolean win = false;
    public Player winner;
    private String name;
    private Player player1;
    private Player player2;

    public Game(String name, ArrayList<String> wallnames, Player player1, Player player2) {
        this.name = name;
        this.player1 = player1;
        this.player2 = player2;
        if (wallnames != null) {
            for (String s : wallnames) {
                Wall w = new Wall(s);
            }
        }
    }


    public void save(String gamename) {
        IOF.writeToFile(gamename, player1.getName(), player2.getName(), player1.getLocation(), player2.getLocation(), player1.getWallsRemaining(), player2.getWallsRemaining(), winner);
    }

    public void load(String gamename) {
        IOF.readFromFile(gamename);
    }
}
