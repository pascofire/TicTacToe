import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToe {
    int width=700;
    int height=750;
    String selectedDifficulty ="";

    JFrame frame=new JFrame("TicTacToe");
    JLabel textlable=new JLabel();
    JPanel textpanel = new JPanel();
    JPanel boardpanel = new JPanel();

    JButton[][] board= new JButton[3][3];
    String pX ="x";
    String pO ="o";
    String currentPlayer= pX;
    int turns=0;
    boolean gameOver = false;



    TicTacToe(String selectedDifficulty) {
        this.selectedDifficulty = selectedDifficulty;
        frame.setVisible(true);
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
                            turns=turns+2;
                            checkWinner();
                         if(!gameOver)
                         {  if(currentPlayer.equals(pX))
                           {  if(selectedDifficulty.equals("easy"))
                                 {EasyBot bot = new EasyBot(board);}
                              else if(selectedDifficulty.equals("hard"))
                                 { HardBot bot = new HardBot(board);}
                           }
                            textlable.setText(currentPlayer + "'s turn");
                        }checkWinner();
                       }

                   }
                 });//action listener
            }
        }
    } // end of default constuctor
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
        { for(int i=0;i<3;i++)
            {setWinner(board[i][c]);}
            gameOver=true;
            return;
        }
    }

    //diagonal
    if(board[0][0].getText()==board[1][1].getText() && board[1][1].getText()==board[2][2].getText() 
    && board[0][0].getText()!="")
    { gameOver=true;
        for(int i=0;i<3;i++)
        {setWinner(board[i][i]);}
        return;
    }

     if(board[0][2].getText()==board[1][1].getText() && board[1][1].getText()==board[2][0].getText() 
     && board[0][2].getText()!="")
     { gameOver=true;
        setWinner(board[0][2]);
        setWinner(board[1][1]);
        setWinner(board[2][0]);
         return;
 
     }
     if(turns==9)
     {for(int r=0;r<3;r++)
        {for(int c=0;c<3;c++)
            {
               board[r][c].setForeground(Color.blue);
               board[r][c].setBackground(Color.gray);
               
            }
        }
        textlable.setText("it's a tie!");
        gameOver=true;
        return;
     }
 }  

 void setWinner(JButton tile)
 {
    tile.setForeground(Color.green);
    tile.setBackground(Color.gray);
    textlable.setText(tile.getText() +" is the winner!");
 }
}
