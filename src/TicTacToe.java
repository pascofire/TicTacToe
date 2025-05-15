import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToe {
    int width=700;
    int height=750;

    JFrame frame=new JFrame("TicTacToe");
    JLabel textlable=new JLabel();
    JPanel textpanel = new JPanel();
    JPanel boardpanel = new JPanel();

    JButton[][] board= new JButton[3][3];
    String pX ="x";
    String pO ="o";
    String currentPlayer= pX;

    boolean gameOver = false;

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

        for(int r=0;r<3;r++)
        {
            for(int c=0;c<3;c++)
            {
                JButton tile = new JButton();
                board[r][c]= tile;
                boardpanel.add(tile);

                 tile.setForeground(Color.LIGHT_GRAY);
                 tile.setBackground(Color.DARK_GRAY);
                 tile.setFont(new Font("calibre",Font.BOLD, 120));
                 tile.setFocusable(false);
                 
                 tile.addActionListener(new ActionListener() {
                   public void actionPerformed(ActionEvent e)
                   { if(gameOver) return;
                    JButton tile = (JButton)e.getSource();
                   

                     if (tile.getText()=="")
                        {tile.setText(currentPlayer);
                         checkWinner();
                         if(!gameOver)
                         {  
                            currentPlayer=currentPlayer==pX?pO:pX;
                            textlable.setText(currentPlayer + "'s turn");
                        }
                       }

                   }
                 })
                ;
            }
        }
    }  
 void checkWinner()
 {
    //horizontal
    for(int a=0;a<3;a++)
    {   if(board[a][1].getText() =="")continue;
        if(board[a][0].getText() == board[a][1].getText() && board[a][1].getText() == board[a][2].getText())
        {  
            for(int i=0;i<3;i++)
            {setWinner(board[a][i]);}
            gameOver=true;
            return;
        }
    }
 
    //vertical
    for(int c=0;c<3;c++)
    {   if(board[1][c].getText() =="")continue;
        if(board[0][c].getText() == board[1][c].getText() && board[1][c].getText() == board[2][c].getText())
        {
            gameOver=true;
            return;
        }
    }

    //diagonal
    if(board[0][0].getText()==board[1][1].getText() && board[1][1].getText()==board[2][2].getText() 
    && board[0][0].getText()!="")
    { gameOver=true;
    
        return;
    }

     if(board[0][2].getText()==board[1][1].getText() && board[1][1].getText()==board[2][0].getText() 
     && board[0][2].getText()!="")
     { gameOver=true;
         return;
 
     }
 }  

 void setWinner(JButton tile)
 {
    tile.setForeground(Color.green);
    tile.setBackground(Color.gray);
    textlable.setText(currentPlayer+"is the winner!");
 }
}
