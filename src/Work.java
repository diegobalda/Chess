import com.javafx.tools.doclets.formats.html.SourceToHTMLConverter;
import oracle.jrockit.jfr.JFR;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.EventListener;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;

/**
 * Created by diegobaldassare on 3/22/16.
 */
public class Work extends JFrame{

    JFrame frame = new JFrame();
    JPanel content = new JPanel();
    JPanel one = new JPanel();
    JPanel two = new JPanel();
    ChessWork chess = new ChessWork(0,0);
    int[][] sol;

    public void display(){
        KnightTour.answer();
        this.sol = KnightTour.sol;
        frame.setTitle("Kight Move - Bruno De Luca, Nicolas Curat, Diego Baldassare");
        frame.setVisible(true);
        frame.setSize(1000,600);
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);



        one.add(chess);
        JButton button = new JButton("Siguiente");
        button.addActionListener(new ButtonListener());
        two.add(button);
        two.setLayout(new GridBagLayout());
        content.setLayout(new GridLayout(1,2));
        content.add(one);
        content.add(two);

        frame.add(content);



    }

    private class ButtonListener implements ActionListener{
        private int count = 1;
        @Override
        public void actionPerformed(ActionEvent e) {
            for(int i = 0; i < sol.length;i++){
                for(int j = 0; j < sol[i].length ;j++){
                    if(sol[i][j] == count){
                        chess.x = j;
                        chess.y = i;
                        count++;
                        SwingUtilities.updateComponentTreeUI(frame);
                        return;
                    }
                }
            }

            System.out.println("end of moves");

        }
    }


    public static void main(String[] args){
        Work work = new Work();
        work.display();
    }

    private class ChessWork extends JPanel{
        int x = 0;
        int y = 0;

        public ChessWork(int x, int y){
            this.x = x;
            this.y = y;
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Color borderColor = new Color(113, 79, 13);
            g.setColor(borderColor);
            g.fillRect(50,50,450,450);
            g.setColor(Color.GRAY);
            g.fillRect(75, 75, 400, 400);


            for(int i = 75; i <= 400; i+=100)
                for(int j = 75; j <= 400; j+=100)
                    g.clearRect(i, j, 50, 50);


            for(int i = 125; i <= 450; i+=100)
                for(int j = 125; j <= 450;j+=100)
                    g.clearRect(i, j, 50, 50);


            try{
                BufferedImage image = ImageIO.read(new File(getClass().getResource("Images/Knight.png").toURI()));
                g.drawImage(image,(75 + x*50),(75 + y*50), 50, 50,null);
            }catch(URISyntaxException e){
                System.out.println(e.getMessage());
            }catch(IOException e){
                System.out.println(e.getMessage());
            }

        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(500, 500);
        }
    }



}