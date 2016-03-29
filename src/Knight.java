package Posta;

/**
 * Created by brunodeluca on 3/28/16.
 */
public class Knight extends Piece{

    public Knight(Position position) {
        super(position);
        int xMove[] = {2, 1, -1, -2, -2, -1, 1, 2};
        int yMove[] = {1, 2, 2, 1, -1, -2, -2, -1};
        setXmoves(xMove);
        setYmoves(yMove);

    }


}
