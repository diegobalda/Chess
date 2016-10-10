package backend;

/**
 * Created by diegobaldassare on 4/06/16.
 */
public class Piece {

    //the combination of x,y in which each piece can move
    protected int[] xMoves;
    protected int[] yMoves;
    private Position position;

    public Piece(Position position) {
        this.position = position;
    }

    public int[] getXMoves() {
        return xMoves;
    }
    public int[] getYMoves() {
        return yMoves;
    }

    public Position getPosition() {
        return this.position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
