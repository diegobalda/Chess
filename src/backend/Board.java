package backend;

import javax.swing.*;
import java.awt.*;

/**
 * Created by diegobaldassare on 4/06/16.
 */
public class Board extends JPanel {

    //positions are stored in a double matrix in order to access to them easier
    private static Position[][] positions;

    public Board() {
        positions = new Position[8][8];

        //initialization
        for (int i = 0; i < positions.length; i++) {
            for (int j = 0; j < positions[i].length; j++) {
                if (isBlack(i, j))
                    positions[i][j] = new Position(i, j, Color.BLACK);
                else
                    positions[i][j] = new Position(i, j, Color.WHITE);
            }
        }

        setGraphics();
    }

    /**
     * Given a Piece, it asks the combination of moves and with its actual position,
     * it returns a list of possible Positions where the Piece can be moved.
     */
    public Stack<Position> possibleMoves(Piece p, Position previousPosition) {
        Stack<Position> possible = new Stack<>();
        int x, y; //evaluating values

        for (int i = 0; i < p.getXMoves().length; i++) {
            x = p.getPosition().getXLocation() + p.getXMoves()[i];
            y = p.getPosition().getYLocation() + p.getYMoves()[i];

            //Test
//            System.out.println("i = " + i);
//            System.out.println("x = (" + x + ") " + p.getPosition().getXLocation() + " " + p.getXMoves()[i]);
//            System.out.println("y = (" + y + ") " + p.getPosition().getYLocation() + " " + p.getYMoves()[i]);

            //verifies it doesn't get out of the bounds of the board that it doesn't go backwards
            if ((x >= 0) && (x < positions.length) && (y >= 0) && (y < positions[0].length) && (!positions[x][y].equals(previousPosition))) {
                possible.push(positions[x][y]);
//                System.out.println("added to the possibles");
            }
        }
        return possible;
    }

    public Position getPosition(int x, int y) {
        return positions[x][y];
    }

    public void moveTo(Piece piece, Position position) {
        piece.setPosition(position);
        position.setPiece(piece);
    }




    /**
     * GUI part
     */
    private void setGraphics() {
        this.setVisible(true);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setPreferredSize(new Dimension(500, 500));
        this.setLayout(new GridLayout(8, 8));

        //adds the positions to the graphics, in a way that the first position is on the left down corner
        for (int j = positions[0].length - 1; j >= 0; j--) {
            for (int i = 0; i < positions.length; i++) {
                this.add(positions[i][j]);
            }
        }
    }

    /**
     * The position should be painted in black only if the x and y
     * value are even numbers or the x and y value are odd numbers.
     * @param i the x value of the position
     * @param j the y value of the position
     * @return true if the position should be painted in black
     */
    private boolean isBlack(int i, int j) {
        return (((i % 2) == 0) && ((j % 2) == 0)) || (((i % 2) != 0) && ((j % 2) != 0));
    }

}
