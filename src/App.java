import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class App {
    public static void main(String[] args) throws Exception {
        int width=720;
        int height=750;
        String selectedDifficulty = "";
        JFrame frame1 = new JFrame("Choose Bot Difficulty!");
        JFrame frame = new JFrame("Tic Tac Toe");

        JLabel label = new JLabel();
        JPanel difficultyPanel = new JPanel();

        JButton easyButton = new JButton("Easy Bot");
        JButton mediumButton = new JButton("Hard Bot");

        JLabel textLabel = new JLabel();
        JPanel textPanel = new JPanel();
        JPanel boardPanel = new JPanel();
        frame1.setSize(550, 350);
        frame1.setLocationRelativeTo(null);
        frame1.setResizable(false);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setLayout(new BorderLayout());

        label.setText("Choose Bot Difficulty");
        label.setFont(new Font("Calibre", Font.BOLD, 30));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setOpaque(true);
        label.setBackground(Color.DARK_GRAY);
        label.setForeground(Color.WHITE);

        difficultyPanel.setLayout(new GridLayout(1, 2, 20, 10));
        difficultyPanel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        easyButton.setFont(new Font("Calibre", Font.BOLD, 16));
        mediumButton.setFont(new Font("Calibre", Font.BOLD, 16));
        easyButton.setBackground(new Color(144, 238, 144)); // light green
        mediumButton.setBackground(new Color(173, 216, 230)); // light blue

        difficultyPanel.add(easyButton);
        difficultyPanel.add(mediumButton);

        frame1.add(label, BorderLayout.NORTH);
        frame1.add(difficultyPanel, BorderLayout.CENTER);
        frame1.setVisible(true);

        easyButton.addActionListener(e -> {
            frame1.dispose();
            TicTacToe tictactoe = new TicTacToe("easy");
        });

        mediumButton.addActionListener(e -> {
            frame1.dispose();
            TicTacToe tictactoe = new TicTacToe("hard");
        });

    }
}
