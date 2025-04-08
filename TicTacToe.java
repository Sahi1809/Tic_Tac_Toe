import java.util.Scanner;

public class TicTacToe {
    private char[][] board;
    private char currentPlayer;
    
    public TicTacToe() {
        board = new char[3][3];
        currentPlayer = 'X';
        initializeBoard();
    }
    
    // Initialize the board with empty spaces
    private void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }
    
    // Print the current state of the board
    private void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n-------------");
        }
    }
    
    // Check if the board is full
    private boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
    
    // Check if someone has won
    private boolean checkWin() {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return true;
            }
        }
        
        // Check columns
        for (int j = 0; j < 3; j++) {
            if (board[0][j] != ' ' && board[0][j] == board[1][j] && board[1][j] == board[2][j]) {
                return true;
            }
        }
        
        // Check diagonals
        if (board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return true;
        }
        if (board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return true;
        }
        
        return false;
    }
    
    // Make a move
    private boolean makeMove(int row, int col) {
        if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ') {
            board[row][col] = currentPlayer;
            return true;
        }
        return false;
    }
    
    // Switch players
    private void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }
    
    // Play the game
    public void play() {
        Scanner scanner = new Scanner(System.in);
        boolean gameEnded = false;
        
        System.out.println("Welcome to Tic Tac Toe!");
        System.out.println("Enter row (0-2) and column (0-2) separated by space");
        
        while (!gameEnded) {
            printBoard();
            System.out.println("Player " + currentPlayer + "'s turn");
            System.out.print("Enter move: ");
            
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            
            if (makeMove(row, col)) {
                if (checkWin()) {
                    printBoard();
                    System.out.println("Player " + currentPlayer + " wins!");
                    gameEnded = true;
                } else if (isBoardFull()) {
                    printBoard();
                    System.out.println("It's a tie!");
                    gameEnded = true;
                } else {
                    switchPlayer();
                }
            } else {
                System.out.println("Invalid move! Try again.");
            }
        }
        scanner.close();
    }
    
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.play();
    }
}