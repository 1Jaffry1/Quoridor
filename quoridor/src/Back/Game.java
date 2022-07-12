// this is the class that will handle the info to save and load;

package Back;

public class Game {
    private String name;
    private Player player1;
    private Player player2;
    public boolean win = false;
    public Player winner;

    public Game(String name, Player player1, Player player2) {
        this.name = name;
        this.player1 = player1;
        this.player2 = player2;
    }


    public void save(String gamename) {
        IOF.writeToFile(gamename, player1.getName(), player2.getName(), player1.getLocation(), player2.getLocation(), player1.getWallsRemaining(), player2.getWallsRemaining());
    }

    public void load(String gamename) {
        IOF.readFromFile(gamename);
    }
}
