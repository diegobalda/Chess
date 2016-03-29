package Posta;

/**
 * Created by brunodeluca on 3/28/16.
 */
public class Board {
    static int[][] board;
    private Piece piece;
    static final int DIMENSION = 8;

    public Board() {
        board = new int[DIMENSION][DIMENSION];
        initialize();
    }

    public void initialize(){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                this.board[i][j] = -1;
            }
        }
    }

    public void setPiece(Piece piece){this.piece = piece;}

    public Piece getPiece(){return this.piece;}


    public int getPosition(int x, int y){
        return board[x][y];
    }

}
