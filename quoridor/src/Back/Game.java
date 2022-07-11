// this is the class that will handle the info to save and load;

package Back;

public class Game {
    private Board board;
    private Player player1;
    private Player player2;
    public boolean win = false;

    public Game(Board board, Player player1, Player player2) {
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
    }


}
