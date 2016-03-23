package javadb_001;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Created by diegobaldassare on 3/22/16.
 */
public class Work extends JPanel{

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(600,600);
        frame.getContentPane().add(new Work());
        frame.setLocationRelativeTo(null);
        frame.setBackground(Color.LIGHT_GRAY);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

//        Piece caballo = new Piece(new Position(1,1,false));;
//        boolean isvalid = caballo.isValid(caballo.getPosition(), new Position(-1,2, true));
    }

    public void paint(Graphics g) {
        g.fillRect(100, 100, 400, 400);

        for(int i = 100; i <= 400; i+=100) {
            for(int j = 100; j <= 400; j+=100) {
                g.clearRect(i, j, 50, 50);
            }
        }

        for(int i = 150; i <= 450; i+=100) {
            for(int j = 150; j <= 450;
                j+=100){ g.clearRect(i, j, 50, 50);
            }
        }
    }

}