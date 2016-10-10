package backend;

import java.util.ArrayList;

/**
 * This class applies the backtracking technique
 * and simulates the movements from the chess piece.
 *
 * Created by diegobaldassare on 4/12/16.
 */
public class Backtracking {

    private ArrayList<Stack<Position>> stacks;
    private Board board;
    private Piece piece;

//    private boolean finished;
//    private int numberOfMovements;
//    private Position start;
//    private Image pieceImage;
    private Stack<Position> last;

    public Backtracking(Piece piece, int jumps) {
        stacks = new ArrayList<>();
        board = new Board();
        this.piece = piece;

        Stack<Position> initial = new Stack<>();
        //starts with the piece on the first position
        initial.push(board.getPosition(0, 0));
        stacks.add(initial);

        //initialization
        while (stacks.size() <= jumps) {
            stacks.add(new Stack<>());
        }

        //uploads all the stacks from the beginning
        uploadStacksFrom(stacks.get(0));
    }

    /**
     * Fills the next stack with all the possible moves
     * starting from the position on the top of the stack given.
     * Then it continues filling all the other stacks with
     * possible positions from the position on the top of the previous stack.
     *
     * @param theStack in which it starts expanding the other stacks
     * @exception RuntimeException when the stack given does not exists on the backtracking
     */
    public void uploadStacksFrom(Stack<Position> theStack) {
        if (!stacks.contains(theStack))
            throw new RuntimeException("Stack not on the list of backtracking!");
        Position previousPosition = piece.getPosition(); //chequear!
        //the piece begins on the top position of the stack given because the possible moves are analyzed from there
        board.moveTo(piece, theStack.peek());

        for (int i = stacks.indexOf(theStack) + 1; i < stacks.size(); i++) {
            stacks.remove(i);
            stacks.add(i, board.possibleMoves(piece, previousPosition));
            previousPosition = piece.getPosition();
            board.moveTo(piece, stacks.get(i).peek());
        }
        last = stacks.get(stacks.size() - 1);
    }

    //Backtracking test for only 4 moves
    public void finiteBacktracking() {

        while (!stacks.get(1).isEmpty()) {

            while (!stacks.get(2).isEmpty()) {

                while (!stacks.get(3).isEmpty()) {

                    while (!last.isEmpty()) {
                        for (Stack<Position> s : stacks) {
                            System.out.print(s.peek().toString());
                        }
                        System.out.println("");
                        last.pop();
                    }

                    stacks.get(3).pop();
                    if (!stacks.get(3).isEmpty()) {

                        uploadStacksFrom(stacks.get(3));
                        for (Stack<Position> s : stacks) {
                            System.out.print(s.peek().toString());
                        }
                    }
                    System.out.println("");
                }

                stacks.get(2).pop();
                if (!stacks.get(2).isEmpty()) {
                    uploadStacksFrom(stacks.get(2));
                    for (Stack<Position> s : stacks) {
                        System.out.print(s.peek().toString());
                    }
                }
                System.out.println("");
            }

            stacks.get(1).pop();
            if (!stacks.get(1).isEmpty()) {
                uploadStacksFrom(stacks.get(1));
                for (Stack<Position> s : stacks) {
                    System.out.print(s.peek().toString());
                }
            }
            System.out.println("");
        }
    }




    //No pude hacer el Backtracking para cualquier cantidad de movimientos
    public void getAllTheWays() {

        while (!stacks.get(0).isEmpty()) {
            while (!last.isEmpty()) {
                for (Stack<Position> s : stacks) {
//                    System.out.print(s.peek().toString() + " - ");
                }
                last.pop();
            }
//            backtracking(last);
        }
    }

    /**
     * Given a stack, it pops the last element of the previous stack
     * and it uploads all the stacks from there.
     * @param s
     */
    private void backtracking(Stack<Position> s) {
        if (stacks.indexOf(s) - 1 < 0)
            return;
        Stack<Position> previous =  stacks.get(stacks.indexOf(s) - 1);
        if (previous.isEmpty()) {
            backtracking(previous);
        }
        previous.pop();
        uploadStacksFrom(previous);
    }


    //for internal test
    private void printStacks(int n) {
        System.out.println("Stacks " + n);
        for (Stack<Position> s: stacks) {
            System.out.println(stacks.indexOf(s) + " " + s.toString());
        }
    }

    public void test() {
        printStacks(1);
        System.out.println("\nPosibles movimientos de a 4 del caballo:");
        finiteBacktracking();
    }

    /**
     *
     * @return stack asked from the list
     */
    public Stack<Position> getStack(int index) {
        return stacks.get(index);
    }
}
