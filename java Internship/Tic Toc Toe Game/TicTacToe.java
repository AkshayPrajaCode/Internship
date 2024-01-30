public class TicTacToe {
    /*
     * 
     */
    public static  void main(String[] args) {
        int board[] = new int[9]; //0 for empty, 1 for X and -1 for O
        boolean isXTurn; //true if it's X's turn, false otherwise.
        
        System.out.println("Welcome to Tic-tac-toe!");
        printBoard(board);
        
        isXTurn=true;
        while (true){
            makeMove(isXTurn ? "X" : "O", board);
            
            if (!checkWin(board)) {
                //if there isn't a winner yet, switch turns.
                isXTurn = !isXTurn;
            } else{
                //If there is a winner, end the game.
                break;
            }
        }
        System.out.println("\nGame Over! The Winner is: "+(isXTurn ? "X" : "O"));
        printBoard(board);
    }
    
    private static void printBoard(int[] bd){
        System.out.print("  1 | 2 | 3\n");
        System.out.print("  ---------\n");
        System.out.printf("1 %1d | %1d | %1d\n",bd[0],bd[1],bd[2]);
        System.out.print("  ---------\n");
        System.out.printf("2 %1d | %1d | %1d\n",bd[3],bd[4],bd[5]);
        System.out.print("  ---------\n");
        System.out.printf("3 %1d | %1d | %1d\n",bd[6],bd[7],bd[8]);
    }
    
    /**
     * This method makes a move on the tic-tac-toe board. It takes in a character representing the player who made the move ('X' or 'O')
     * This method makes a move on the tic-tac-toe board. It takes in a character representing the player who made the move ('X' or 'O') and an
     * Makes a move on the tic-tac-toe board. Assumes that the spot chosen is valid.
     * @param mark What to put in the spot (X or O).
     * @param bd The current state of the board.
     */
    private static void makeMove(String mark, int[] bd){
        Scanner scanner = new Scanner(System.in);
        int spot;
        do{
            System.out.print("Enter the number of the spot you want to place your "+mark+": ");
            spot = scanner.nextInt() - 1;
        }while(!validateSpot(spot));
        bd[spot] = getMarkValue(mark);
    }
    
    /**
     * Checks whether a given integer represents an X or an O. Returns true for X and false for O. Throws an exception otherwise.
     * Checks whether a given integer represents an X or an O. Returns true for X and false for O. Throws an exception otherwise.
     * Checks whether a given integer represents an X or an O. Returns true for X and false for O. Throws an exception otherwise.
     * Checks whether a given integer represents an X or an O. If it does, returns its numerical value. Otherwise, throws an error.
     * Checks whether a given integer represents an X or an O. If it does, returns its corresponding value. Otherwise, throws an exception.
     * Checks whether a given integer represents an X or an O. Returns true for X and false for O. Throws an exception otherwise.
     * Checks whether a given integer represents an X or an O. Returns true for X and false for O.
     * @param m The string representing either X or O.
     * @return True iff m is X.
     */
    public static boolean isX(String m) { return m.equalsIgnoreCase("x") || m.equalsIgnoreCase("X");}
    
    /**
     * Gets the numerical value associated with a particular piece of the game (an X or an O).
     * @param m The string representing either X or O.
     * @return 1 for X and 0 for O.
     */
    private static int getMarkValue(String m) { return isX(m)? 1:0;}
    
    /**
     * Validates that a given integer is within range for the tic-tac-toe board.
     * @param s The integer to check.
     * @return True iff s is between 0 and 8 inclusive.
     */
    private static boolean validateSpot(int s) { return s >= 0 && s < 9;}
    
    /**
     * Determines who wins by looking at every possible combination of three spots. If any one of them has all X's or all O's, then that player wins.
     * Determines who wins by looking at all possible combinations of three consecutive spots. If no one has won yet, returns a draw.
     * Plays a single round of Tic Tac Toe.
     */
    public static void playGame(){
        // Initialize the game board.
        int[] board = new int[9];
        
        // Play until someone wins or there are no more moves left.
        while (!isWinningBoard(board) && hasMovesLeft(board)) {
            
            // Make the first move.
            makeMove('O', board);
            
            // Display the current state of the game.
            System.out.println("\nCurrent Game Board:\n" + printBoard(board) + "\n");
            
            char mark;
            
            do{
                // Prompt the user for their next move.
                System.out.print("Enter your move (0-8): ");
                
                try {
                    String input = scanner.nextLine();
                    int spot = Integer.parseInt(input);
                    
                    // If the user's move is valid, record it on the board and break out of this loop.
                    if (validateSpot(spot)){
                        mark = 'X';
                        makeMove(mark, board);
                        break;
                    } else {
                        System.out.println("Invalid move! Please enter a number between 0 and 8.");
                    }
                } catch (NumberFormatException e){
                    System.out.println("Invalid move! Please enter a number between 0 and 8.");
                }
            }while(true);
        }
        
        // Display the final state of the game.
        System.out.println("\nFinal Game Board:\n" + printBoard(board));
        
        // Determine who won (if anyone).
        determineWinner(board);
    }
}
   