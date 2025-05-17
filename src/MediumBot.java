import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;


public class MediumBot {
//    ArrayList<Integer> intboard =new ArrayList<>();
//    JButton[][] board= new JButton[3][3];
//    boolean gameOver = false;
//    Random random= new Random();
//
//    public MediumBot(JButton [][]board) {
//        intboard = intboard(board);
//        int[] blanks = new int[intboard.size()];
//
//        for (int i = 0; i < intboard.size(); i++) {
//            blanks[i] = intboard.get(i);
//        }//stores index of number of blank spaces
//
//
//        int randomIndex= random.nextInt(blanks.length);
//        int num = blanks[randomIndex];
//        int numRow=num/3;
//        int numColumn=num%3;
//
//
//        board[numRow][numColumn].setText("O");
//    }
//    public int[] check(JButton[][] board) {
//
//        //horizontal
//        for(int a=0;a<3;a++)
//        {   if(board[a][1].getText() =="")continue;
//            if(board[a][0].getText() == board[a][1].getText() && board[a][1].getText() == board[a][2].getText())
//            {
//                for(int i=0;i<3;i++)
//                {setWinner(board[a][i]);}
//                gameOver=true;
//                return;
//            }
//        }
//
//        //vertical
//        for(int c=0;c<3;c++)
//        {   if(board[1][c].getText() =="")continue;
//            if(board[0][c].getText() == board[1][c].getText() && board[1][c].getText() == board[2][c].getText())
//            { for(int i=0;i<3;i++)
//            {setWinner(board[i][c]);}
//                gameOver=true;
//                return;
//            }
//        }
//
//        //diagonal
//        if(board[0][0].getText()==board[1][1].getText() && board[1][1].getText()==board[2][2].getText()
//                && board[0][0].getText()!="")
//        { gameOver=true;
//            for(int i=0;i<3;i++)
//            {setWinner(board[i][i]);}
//            return;
//        }
//
//        if(board[0][2].getText()==board[1][1].getText() && board[1][1].getText()==board[2][0].getText()
//                && board[0][2].getText()!="")
//        { gameOver=true;
//            setWinner(board[0][2]);
//            setWinner(board[1][1]);
//            setWinner(board[2][0]);
//            return;
//
//        }
//    }
//
//    void checkWinner()
//    {
//        //horizontal
//        for(int a=0;a<3;a++)
//        {   if(board[a][1].getText() =="")continue;
//            if(board[a][0].getText() == board[a][1].getText() && board[a][1].getText() == board[a][2].getText())
//            {
//                for(int i=0;i<3;i++)
//                {setWinner(board[a][i]);}
//                gameOver=true;
//                return;
//            }
//        }
//
//        //vertical
//        for(int c=0;c<3;c++)
//        {   if(board[1][c].getText() =="")continue;
//            if(board[0][c].getText() == board[1][c].getText() && board[1][c].getText() == board[2][c].getText())
//            { for(int i=0;i<3;i++)
//            {setWinner(board[i][c]);}
//                gameOver=true;
//                return;
//            }
//        }
//
//        //diagonal
//        if(board[0][0].getText()==board[1][1].getText() && board[1][1].getText()==board[2][2].getText()
//                && board[0][0].getText()!="")
//        { gameOver=true;
//            for(int i=0;i<3;i++)
//            {setWinner(board[i][i]);}
//            return;
//        }
//
//        if(board[0][2].getText()==board[1][1].getText() && board[1][1].getText()==board[2][0].getText()
//                && board[0][2].getText()!="")
//        { gameOver=true;
//            setWinner(board[0][2]);
//            setWinner(board[1][1]);
//            setWinner(board[2][0]);
//            return;
//
//        }
//        if(turns==9)
//        {for(int r=0;r<3;r++)
//        {for(int c=0;c<3;c++)
//        {
//            board[r][c].setForeground(Color.blue);
//            board[r][c].setBackground(Color.gray);
//
//        }
//        }
//            textlable.setText("it's a tie!");
//            gameOver=true;
//            return;
//        }
//    }
//
//
//
//    public ArrayList<Integer> intboard(JButton [][]board)
//    {    ArrayList<Integer> board1 =new ArrayList<>();
//        for(int r=0;r<3;r++)
//        { for(int c=0;c<3;c++)
//        {
//            if(board[r][c].getText().equals("")) {
//                int x=(r*3)+c;
//                board1.add(x);
//            }
//        }
//        }
//        return board1;
//    }
}
