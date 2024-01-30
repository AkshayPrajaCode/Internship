import java.util.Scanner;

public class TicTToe {
 public static void main (String[] args){
        int board[] = new int[9]; // 0 for empty, 1 for X and -1 for O
        boolean isXTurn; // true if it's X's turn, false otherwise.

        System.out.println("Welcome to Tic-tac-toe!");
        printBoard(board);

        isXTurn = true;
        while (true) {
            makeMove(isXTurn ? "X" : "O", board);

            if (!checkWin(board)) {
                // if there isn't a winner yet, switch turns.
                isXTurn = !isXTurn;
            } else {
                // If there is a winner, end the game.
                break;
            }
        }
        System.out.println("\nGame Over! The Winner is: " + (isXTurn ? "X" : "O"));
        printBoard(board);
    }

    private static void printBoard(int[] bd) {
        System.out.print("  1 | 2 | 3\n");
        System.out.print("  ---------\n");
        System.out.printf("1 %1d | %1d | %1d\n", bd[0], bd[1], bd[2]);
        System.out.print("  ---------\n");
        System.out.printf("2 %1d | %1d | %1d\n", bd[3], bd[4], bd[5]);
        System.out.print("  ---------\n");
        System.out.printf("3 %1d | %1d | %1d\n", bd[6], bd[7], bd[8]);
    }

    /**
     * This method makes a move on the tic-tac-toe board. It takes in a character representing the player who made the move ('X' or 'O')
     * and an array representing the current state of the board.
     * Makes a move on the tic-tac-toe board. Assumes that the spot chosen is valid.
     *
     * @param mark   What to put in the spot (X or O).
     * @param bd     The current state of the board.
     */
    private static void makeMove(String mark, int[] bd) {
        Scanner scanner = new Scanner(System.in);
        int spot;
        do {
            System.out.print("Enter the number of the spot you want to place your " + mark + ": ");
            spot = scanner.nextInt() - 1;
        } while (!validateSpot(spot));
        bd[spot] = getMarkValue(mark);
    }

    /**
     * Checks whether a given integer represents an X or an O. Returns true for X and false for O. Throws an exception otherwise.
     *
     * @param m The string representing either X or O.
     * @return True iff m is X.
     */
    public static boolean isX(String m) {
        return m.equalsIgnoreCase("x") || m.equalsIgnoreCase("X");
    }

    /**
     * Gets the numerical value associated with a particular piece of the game (an X or an O).
     *
     * @param m The string representing either X or O.
     * @return 1 for X and 0 for O.
     */
    private static int getMarkValue(String m) {
        return isX(m) ? 1 : -1;
    }

    /**
     * Validates that a given integer is within range for the tic-tac-toe board.
     *
     * @param s The integer to check.
     * @return True iff s is between 0 and 8 inclusive.
     */
    private static boolean validateSpot(int s) {
        return s >= 0 && s < 9;
    }

    /**
     * Determines who wins by looking at every possible combination of three spots. If any one of them has all X's or all O's, then that player wins.
     *
     * @param bd The current state of the board.
     * @return True if there is a winner, false otherwise.
     */
    private static boolean checkWin(int[] bd) {
        return checkRows(bd) || checkCols(bd) || checkDiags(bd);
    }

    /**
     * Checks the rows for a win.
     *
     * @param bd The current state of the board.
     * @return True if there is a win in any row, false otherwise.
     */
    private static boolean checkRows(int[] bd) {
        for (int i = 0; i <= 6; i += 3) {
            if (Math.abs(bd[i]) == 1 && bd[i] == bd[i + 1] && bd[i] == bd[i + 2]) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks the columns for a win.
     *
     * @param bd The current state of the board.
     * @return True if there is a win in any column, false otherwise.
     */
    private static boolean checkCols(int[] bd) {
        for (int i = 0; i <= 2; i++) {
            if (Math.abs(bd[i]) == 1 && bd[i] == bd[i + 3] && bd[i] == bd[i + 6]) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks the diagonals for a win.
     *
     * @param bd The current state of the board.
     * @return True if there is a win in any diagonal, false otherwise.
     */
    private static boolean checkDiags(int[] bd) {
        return (Math.abs(bd[0]) == 1 && bd[0] == bd[4] && bd[0] == bd[8])
                || (Math.abs(bd[2]) == 1 && bd[2] == bd[4] && bd[2] == bd[6]);
    }
}