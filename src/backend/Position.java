package backend;

import javax.swing.*;
import java.awt.*;

/**
 * Created by diegobaldassare on 5/04/16.
 */
public class Position extends JPanel {

    private int x;
    private int y;

    //unnecessary fields
    private Piece piece;
    private Color color;


    public Position(int x, int y, Color blackOrWhite) {
        this.x = x;
        this.y = y;
        this.piece = null;

        this.color = blackOrWhite;
        setGraphics();
    }

    public int getYLocation() {
        return y;
    }
    public int getXLocation() {
        return x;
    }
    public Piece getPiece() {
        return piece;
    }
    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public boolean isFree() {
        return piece == null;
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    /**
     * GUI part
     * When a position is created, it
     * will set these JPanel configurations.
     */
    private void setGraphics() {
        this.setBackground(color);
        this.setVisible(true);
    }

    //paints the position with its original color (black or white)
    public void paint(){
        this.setBackground(color);
    }

    //paints the position with red
    public void paintRed() {
        this.color = Color.RED;
    }
}