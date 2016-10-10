package fronted;

import backend.Backtracking;
import backend.Horse;
import backend.Position;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Diego Baldassare on 10/7/16.
 */
public class ChessApp {

    public static void main(String[] args) {
        Backtracking backtracking = new Backtracking(new Horse(new Position(0, 0, Color.BLACK)), 4);

        Window window = new Window(backtracking);

//        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        window.setVisible(true);
    }
}
