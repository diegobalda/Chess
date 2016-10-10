package backend;

/**
 * Created by diegobaldassare on 4/06/16.
 */
public class Horse extends Piece {

    public Horse(Position position) {
        super(position);
        initializeMoves();
    }

    private void initializeMoves() {
        xMoves = new int[]{2, 1, -1, -2, -2, -1, 1, 2};
        yMoves = new int[]{1, 2, 2, 1, -1, -2, -2, -1};
    }
}
