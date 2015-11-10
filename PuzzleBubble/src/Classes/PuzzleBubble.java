package Classes;

/**
 * Created by Timothy on 30/10/2015.
 */
public class PuzzleBubble {
    public int game = 1;
    public int players;
    public int level;

    public PuzzleBubble(int game, int players, int level){
        this.game = game;
        this.players = players;
        this.level = level;

    }




    public int getLevel() {
        return level;
    }

    public int getPlayers() {
        return players;
    }

    public void setGame(int game) {
        this.game = game;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setPlayers(int players) {
        this.players = players;
    }
}
