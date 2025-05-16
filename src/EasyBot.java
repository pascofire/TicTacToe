import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;


public class EasyBot {
    ArrayList<Integer> intboard =new ArrayList<>();
    //int[][] intboard=new int[3][3];
    Random random= new Random();

    public EasyBot(JButton [][]board) {
       intboard = intboard(board);
        int[] blanks = new int[intboard.size()];

        for (int i = 0; i < intboard.size(); i++) 
        { blanks[i]=intboard.get(i);            
        }//stores index of number of blank spaces

        int randomIndex= random.nextInt(blanks.length);
        int num = blanks[randomIndex];
        int numRow=num/3;
        int numColumn=num%3;


        board[numRow][numColumn].setText("O");
    }

    public ArrayList<Integer> intboard(JButton [][]board)
    {    ArrayList<Integer> board1 =new ArrayList<>();
        for(int r=0;r<3;r++)
        { for(int c=0;c<3;c++)
            {
             if(board[r][c].getText().equals("")) {
                 int x=(r*3)+c;
                 board1.add(x);
             }
            }
        }
        return board1;
    }
}
