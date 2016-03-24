import java.util.Iterator;

/**
 * Created by brunodeluca on 3/24/16.
 */
public class Main {
    public static void main(String[] args){
        int[] Xmoves = {1, 2, 2, 1, -1, -2, -2, -1};
        int[] Ymoves = {2, 1, -1, -2, -2, -1, 1, 2};
        Piece knight = new Knight(new Position(1,1, true), Xmoves, Ymoves);

        Stack<Position> positions = knight.whereToMove();
        if(positions.isEmpty())
            System.out.println("is empty");
        for(Position a: positions)
            a.print();

    }
}
