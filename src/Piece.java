package Posta;

/**
 * Created by brunodeluca on 3/28/16.
 */
public class Piece {
    protected int[] Xmoves;
    protected int[] Ymoves;
    private Position currentPosition;

    public Piece(Position position) {
        this.currentPosition = position;
    }

    public int[] getXmoves() {
        return Xmoves;
    }

    public int[] getYmoves() {
        return Ymoves;
    }

    public void setXmoves(int[] xmoves) {
        Xmoves = xmoves;
    }

    public void setYmoves(int[] ymoves) {
        Ymoves = ymoves;
    }

    public Position getCurrentPosition(){return this.currentPosition;}

    public void setCurrentPosition(Position position){this.currentPosition = position;}

    public static boolean isValid(Position pos, int[][] board){
        return (pos.getX() >= 0 && pos.getX() < Board.DIMENSION && pos.getY() >= 0 && pos.getY() < Board.DIMENSION && board[pos.getX()][pos.getY()] == -1);
    }

    public Stack<Position> posibleMoves(Position position){
        Stack<Position> posibleMoves = new Stack<Position>();
        int next_x;
        int next_y;
        for(int i = 0; i < 8; i++){
            next_x = position.getX() + Xmoves[i];
            next_y = position.getY() + Ymoves[i];
            if(isValid(new Position(next_x,next_y), Board.board))
                posibleMoves.push(new Position(next_x,next_y));
        }
        return posibleMoves;
    }

}
