package Posta;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by brunodeluca on 3/28/16.
 */
public class Game {

    private List<Stack<Position>> gamePositions;
    private Board board;

    public Game(){
        gamePositions = new LinkedList<Stack<Position>>();
        board = new Board();

        board.setPiece(new Knight(new Position(0,0)));

        Piece piece = board.getPiece();

        setGamePositions(piece.posibleMoves(piece.getCurrentPosition()));
        board.board[piece.getCurrentPosition().getX()][piece.getCurrentPosition().getX()] = 0;
        getLastPosition();
        printLastStack();
    }

    public Board getBoard(){return this.board;}

    public Position getLastPosition(){
        Stack<Position> lastStack = gamePositions.get(gamePositions.size()-1);
        return lastStack.peek();
    }

    public void setGamePositions(Stack<Position> positions){
        gamePositions.add(positions);
    }

    public List<Stack<Position>> getGamePosition(){return gamePositions;}

    public String printLastStack(){
        String chain = "";
        Stack<Position> lastStack = gamePositions.get(gamePositions.size()-1);
        for(Position p: lastStack){
            chain = p.print();
        }
        return chain;

    }
}
