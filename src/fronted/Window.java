package fronted;

import backend.Backtracking;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Created by diegobaldassare on 4/18/16.
 */
public class Window extends JFrame {

    private BoardPanel boardPanel;
    private Backtracking backtracking;
    private List<StackPanel> stackPanels;
    private JButton next = new JButton("Next");

    //JFrame
    private static final long serialVersionUID = 1L;
    private static final int CELL_SIZE = 65;

    public Window(Backtracking backtracking) {
        super("Chess");
        this.backtracking = backtracking;

        //JFrame
        this.pack();
        this.setVisible(true);
        this.setResizable(false);
        setLayout(new BorderLayout(15, 10)); //null
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(backtracking.getBoard().getSize() * CELL_SIZE + 80 +
                backtracking.getNumberOfMovements() * StackPanel.PANEL_WIDTH,
                backtracking.getBoard().getSize() * CELL_SIZE +100);

        initBoard(backtracking);
        initButton(backtracking);
        initStacks(backtracking);


        //JTextArea test
        JTextArea textArea1 = new JTextArea(1, 10);
        JTextArea textArea2 = new JTextArea(1, 10);
        JTextArea textArea3 = new JTextArea(1, 10);
        JTextArea textArea4 = new JTextArea(1, 10);

        textArea1.append("textArea1\n");
        textArea1.append("textArea11\n");
        textArea1.append("textArea111\n");

        textArea2.append("textArea2\n");
        textArea2.append("textArea22\n");
        textArea2.append("textArea222\n");
        textArea2.append("textArea2222\n");

        textArea3.append("textArea3\n");
        textArea3.append("textArea33\n");
        textArea3.append("textArea333\n");

        textArea4.append("textArea4\n");
        textArea4.append("textArea44\n");
        textArea4.append("textArea444\n");

        JPanel textAreas = new JPanel(new GridLayout(1, 4, 0, 5));
        textAreas.add(textArea1);
        textAreas.add(textArea2);
        textAreas.add(textArea3);
        textAreas.add(textArea4);


        //Add JPanels and set alignment
        add(board, BorderLayout.CENTER);
        add(getRowsPanel(), BorderLayout.WEST);
        add(getColumnsPanel(), BorderLayout.NORTH);
        add(textAreas, BorderLayout.EAST);
        add(buttonsPanel, BorderLayout.SOUTH);

        board.getPosition(0,0).paintRed();
//        SwingUtilities.updateComponentTreeUI(this);
//        invalidate();
//        validate();
//        repaint();
    }

    private void initBoard(Backtracking backtracking) {
        boardPanel = new BoardPanel(backtracking.getBoard().getSize(),
                                    backtracking.getBoard().getSize(), CELL_SIZE, backtracking);
        add(boardPanel);
    }

    private void initButton(Backtracking backtracking) {
        next.setLocation(backtracking.getBoard().getSize() * CELL_SIZE,
                (backtracking.getBoard().getSize() * CELL_SIZE)/2);
        next.setSize(80, 30);
        add(next);

        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                backtracking.next();
            }
        });

        JPanel buttonsPanel = new JPanel(new FlowLayout());
        buttonsPanel.add(next);
    }

    private void initStacks(Backtracking backtracking) {

    }


    public JPanel getRowsPanel() {
        JPanel rows = new JPanel(new GridLayout(8, 1));
        for (int i = 8; i > 0; i--) {
            rows.add(new JLabel("    " + i));
        }
        return rows;
    }

    public JPanel getColumnsPanel() {
        JPanel columns = new JPanel(new GridLayout(1, 9, 50, 0));

        columns.add(new JLabel());
        columns.add(new JLabel("A"));
        columns.add(new JLabel("B"));
        columns.add(new JLabel("C"));
        columns.add(new JLabel("D"));
        columns.add(new JLabel("E"));
        columns.add(new JLabel("F"));
        columns.add(new JLabel("G"));
        columns.add(new JLabel("H"));

        JPanel ret = new JPanel(new GridLayout(2, 2));
        ret.add(new JPanel());
        ret.add(new JPanel());
        ret.add(columns);

        return ret;
    }
}
