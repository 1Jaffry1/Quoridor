// this is the class that will handle the info to save and load;

package Back;

import java.util.ArrayList;

public class Game {
    private Board board;
    private Player player1;
    private Player player2;
    private ArrayList<Wall> placedWalls = new ArrayList<>();

    public Game(Board board, Player player1, Player player2) {
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
    }


}
