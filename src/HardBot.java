import javax.swing.*;

/*
 * HardBot.java
 * Simple Minimax-based Tic-Tac-Toe bot.
 *
 * Usage: new HardBot(board);
 * The constructor immediately chooses and plays the best move (sets the chosen button's text to "O").
 *
 * Notes:
 * - This implementation treats "O" (uppercase) as the bot marker and "x" (lowercase) as the human marker.
 *   I chose uppercase "O" to match the style already used in EasyBot.java in your project.
 * - The evaluation uses +10 for a bot (O) win, -10 for a human (x) win, 0 for tie.
 * - The recursion favors faster wins and slower losses by subtracting/adding depth to the score.
 * - The code uses equalsIgnoreCase when checking contents to be a little robust to case differences.
 */
public class HardBot {
    private JButton[][] board;

    public HardBot(JButton[][] board) {
        this.board = board;
        Move best = findBestMove();
        if (best != null) {
            board[best.row][best.col].setText("O");
        }
    }

    // helper class for move
    private static class Move {
        int row, col;
        Move(int r, int c) { row = r; col = c; }
    }

    // Minimax entry: iterate possible moves and pick best
    private Move findBestMove() {
        int bestVal = Integer.MIN_VALUE;
        Move bestMove = null;

        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (isEmptyCell(r, c)) {
                    // Make the move
                    board[r][c].setText("O");
                    int moveVal = minimax(0, false);
                    // Undo
                    board[r][c].setText("");
                    if (moveVal > bestVal) {
                        bestVal = moveVal;
                        bestMove = new Move(r, c);
                    }
                }
            }
        }
        return bestMove;
    }

    // Minimax recursion
    // depth: current recursion depth (used for preferring faster wins)
    // isMax: true if it's bot's turn to maximize score
    private int minimax(int depth, boolean isMax) {
        Integer score = evaluateBoard();
        if (score != null) { // non-null means terminal (win or loss)
            // If bot wins, positive; if human wins, negative.
            // Subtract/add depth so the algorithm prefers faster wins and slower losses.
            return score > 0 ? score - depth : score + depth;
        }

        if (isBoardFull()) {
            return 0; // tie
        }

        if (isMax) {
            int best = Integer.MIN_VALUE;
            for (int r = 0; r < 3; r++) {
                for (int c = 0; c < 3; c++) {
                    if (isEmptyCell(r, c)) {
                        board[r][c].setText("O");
                        best = Math.max(best, minimax(depth + 1, false));
                        board[r][c].setText("");
                    }
                }
            }
            return best;
        } else {
            int best = Integer.MAX_VALUE;
            for (int r = 0; r < 3; r++) {
                for (int c = 0; c < 3; c++) {
                    if (isEmptyCell(r, c)) {
                        // assume human plays "x"
                        board[r][c].setText("x");
                        best = Math.min(best, minimax(depth + 1, true));
                        board[r][c].setText("");
                    }
                }
            }
            return best;
        }
    }

    // return +10 if bot (O) wins, -10 if human (x) wins, null otherwise
    private Integer evaluateBoard() {
        // rows
        for (int r = 0; r < 3; r++) {
            String a = board[r][0].getText();
            String b = board[r][1].getText();
            String c = board[r][2].getText();
            if (!a.equals("") && a.equalsIgnoreCase(b) && b.equalsIgnoreCase(c)) {
                if (a.equalsIgnoreCase("O")) return +10;
                if (a.equalsIgnoreCase("x")) return -10;
            }
        }
        // cols
        for (int col = 0; col < 3; col++) {
            String a = board[0][col].getText();
            String b = board[1][col].getText();
            String c = board[2][col].getText();
            if (!a.equals("") && a.equalsIgnoreCase(b) && b.equalsIgnoreCase(c)) {
                if (a.equalsIgnoreCase("O")) return +10;
                if (a.equalsIgnoreCase("x")) return -10;
            }
        }
        // diagonals
        String d1a = board[0][0].getText();
        String d1b = board[1][1].getText();
        String d1c = board[2][2].getText();
        if (!d1a.equals("") && d1a.equalsIgnoreCase(d1b) && d1b.equalsIgnoreCase(d1c)) {
            if (d1a.equalsIgnoreCase("O")) return +10;
            if (d1a.equalsIgnoreCase("x")) return -10;
        }
        String d2a = board[0][2].getText();
        String d2b = board[1][1].getText();
        String d2c = board[2][0].getText();
        if (!d2a.equals("") && d2a.equalsIgnoreCase(d2b) && d2b.equalsIgnoreCase(d2c)) {
            if (d2a.equalsIgnoreCase("O")) return +10;
            if (d2a.equalsIgnoreCase("x")) return -10;
        }
        return null; // no terminal winner yet
    }

    private boolean isEmptyCell(int r, int c) {
        return board[r][c].getText().equals("");
    }

    private boolean isBoardFull() {
        for (int r = 0; r < 3; r++)
            for (int c = 0; c < 3; c++)
                if (isEmptyCell(r, c)) return false;
        return true;
    }
}
