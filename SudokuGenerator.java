import java.util.Random;

public class SudokuGenerator {
    private int[][] board;

    public SudokuGenerator() {
        board = new int[9][9];
        generateBoard();
    }

    private void generateBoard() {
        // Fill the board with 0s
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = 0;
            }
        }

        // Generate random numbers for each row and column
        Random rand = new Random();
        for (int i = 0; i < 9; i++) {
            int num = i % 9 + 1;
            for (int j = 0; j < 9; j++) {
                board[i][j] = num;
                num++;
                if (num > 9) {
                    num = 1;
                }
            }
        }

        // Shuffle the rows and columns to create a valid board
        shuffleRows();
        shuffleColumns();

        // Remove some random cells to create the puzzle
        removeCells();
    }

    private void shuffleRows() {
        Random rand = new Random();
        for (int i = 0; i < 3; i++) {
            int r1 = rand.nextInt(3) + i * 3;
            int r2 = rand.nextInt(3) + i * 3;
            for (int j = 0; j < 9; j++) {
                int temp = board[r1][j];
                board[r1][j] = board[r2][j];
                board[r2][j] = temp;
            }
        }
    }

    private void shuffleColumns() {
        Random rand = new Random();
        for (int i = 0; i < 3; i++) {
            int c1 = rand.nextInt(3) + i * 3;
            int c2 = rand.nextInt(3) + i * 3;
            for (int j = 0; j < 9; j++) {
                int temp = board[j][c1];
                board[j][c1] = board[j][c2];
                board[j][c2] = temp;
            }
        }
    }

    private void removeCells() {
        Random rand = new Random();
        int numCells = rand.nextInt(20) + 40; // remove between 40-59 cells
        for (int i = 0; i < numCells; i++) {
            int row = rand.nextInt(9);
            int col = rand.nextInt(9);
            if (board[row][col] != 0) {
                board[row][col] = 0;
            } else {
                i--; // try again
            }
        }
    }

    public int[][] getBoard() {
        return board;
    }
}
