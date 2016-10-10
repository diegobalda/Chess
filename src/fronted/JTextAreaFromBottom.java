package fronted;

import javax.swing.*;
import java.util.Stack;

/**
 * This class is a JTextArea that prints from the bottom to the top.
 * It uses a Stack (reverse) in order to change the order of the lines of the text area.
 *
 * Created by diegobaldassare on 4/24/16.
 */
public class JTextAreaFromBottom extends JTextArea {

    private Stack<String> reverse = new Stack<>();
    private boolean append; //if append is false, it don't let append anything else

    public JTextAreaFromBottom(int rows, int columns) {
        super(rows, columns);
    }

    /**
     * If append is false, it don't let append anything else,
     * because otherwise it won't work properly.
     * @param str
     */
    @Override
    public void append(String str) {
        if (!append)
            throw new RuntimeException("Append finished");
        reverse.push(str);
    }

    public void endAppend() {
        append = false;
        while (!reverse.isEmpty()) {
            super.append(reverse.pop());
        }
    }
}
