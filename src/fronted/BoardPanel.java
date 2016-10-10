package fronted;

import backend.Backtracking;
import backend.Position;

import javax.swing.*;
import java.awt.*;
import java.util.*;

/**
 * Created by Diego Baldassare on 10/7/16.
 */
public class BoardPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    private int cellSize;
    private int rows, columns;
    private Image[][] cells;
    private Backtracking backtracking;
    private Image darkSquare;
    private Image lightSquare;
    private Image redDot;

    private java.util.List<Position> lastPositions;
}
