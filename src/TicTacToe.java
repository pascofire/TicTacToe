import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
public class TicTacToe {
    int width=700;
    int height=750;

    JFrame frame=new JFrame("TicTacToe");
    JLabel textlable=new JLabel();
    JPanel textpanel = new JPanel();
    JPanel boardpanel = new JPanel();


    TicTacToe()
    {frame.setVisible(true);
        frame.setSize(width,height);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        textlable.setBackground(Color.darkGray);
        textlable.setForeground(Color.white);
        textlable.setFont(new Font("calibre",Font.BOLD,50));
        textlable.setHorizontalAlignment(JLabel.CENTER);
        textlable.setText("tictactoe");
        textlable.setOpaque(true);

        textpanel.setLayout(new BorderLayout());
        textpanel.add(textlable);
        frame.add(textpanel,BorderLayout.NORTH); 
        
        boardpanel.setLayout(new GridLayout(3,3));
        boardpanel.setBackground(Color.darkGray);
        frame.add(boardpanel);

    }  
}
