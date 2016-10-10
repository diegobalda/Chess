package fronted;

import backend.Backtracking;
import backend.BoardListener;
import backend.Position;
import backend.Stack;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by diegobaldassare on 4/27/16.
 */
public class StackPanel extends JPanel implements BoardListener{

    private Backtracking backtracking; //needed to get the moves

    //JPanel
    public static final int TEXT_HEIGHT = 50;
    public static final int PANEL_WIDTH = 100;
    private int index;
    private int height;

    public StackPanel(Backtracking backtracking, int index, int height) {
        this.backtracking = backtracking;
        this.index = index;
        this.height = height;

//        backtracking.getBoard().addBoardListener(this);

        //JPanel
        setLayout(null);
        setSize(PANEL_WIDTH, height);
        setBackground(Color.GRAY);
    }



    @Override
    public void paint(Graphics g) {
        super.paintComponent(g);
        Stack<Position> stack = backtracking.getStack(index);

        //paint
        int i = 1;
        g.drawString("Move " + (index + 1), 20, height - TEXT_HEIGHT * i);
        while(!stack.isEmpty()){
            i++;

            g.drawString(stack.peek().toString(), 30, height - TEXT_HEIGHT * i);
            stack.pop();
        }
    }

    @Override
    public void boardUpdated(List<Position> positions) {
//        repaint();
    }
}
