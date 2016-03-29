package Posta;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;

public class Work extends JFrame{
    Game game = new Game();
    JFrame frame = new JFrame();
    JPanel content = new JPanel();
    JPanel content2 = new JPanel();
    JPanel one = new JPanel();
    JPanel two = new JPanel();
    JPanel three = new JPanel();
    ChessWork chess = new ChessWork(0,0);
    private int count = 0;

    public void display(){
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
        three.setLayout(new BoxLayout(three, BoxLayout.PAGE_AXIS));
        three.add(new Stacks());
        two.setLayout(new BoxLayout(two, BoxLayout.PAGE_AXIS));
        content2.setLayout(new GridLayout(2,1));
        content2.add(two);
        content2.add(three);
        content.setLayout(new GridLayout(1,1));
        content.add(one);
        content.add(content2);

        frame.add(content);
    }

    private class ButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(count < 4){
                Position lastPosition = game.getLastPosition();
                Piece piece = game.getBoard().getPiece();
                piece.setCurrentPosition(lastPosition);
                Board.board[lastPosition.getX()][lastPosition.getY()] = 0;
                game.setGamePositions(piece.posibleMoves(piece.getCurrentPosition()));
                chess.x = piece.getCurrentPosition().getX();
                chess.y = piece.getCurrentPosition().getY();
                game.printLastStack();
                SwingUtilities.updateComponentTreeUI(frame);
                count++;
            }else
                System.out.println("No more movements");
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
                BufferedImage image = ImageIO.read(new File(getClass().getResource("../Images/Knight.png").toURI()));
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
    private class Stacks extends JPanel{
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            String stack = game.printLastStack();
            JLabel lable = new JLabel(stack);
        }
        public Dimension getPreferredSize() {
            return new Dimension(500, 500);
        }
    }
}