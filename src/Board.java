/**
 * Created by brunodeluca on 3/23/16.
 */
public class Board {

    private Position[][] board = new Position[8][8];
    private Stack<Position> positions = new Stack<Position>();

    public Board() {
        initialize();
    }

    public void initialize(){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                this.board[i][j] = new Position(i, j, true);
            }
        }
    }

//    public Position[] possibleMoves(Piece piece){
//
//    }

    public Position getPosition(int x, int y){
        return board[x][y];
    }
}