import java.awt.*;
import javax.swing.*;

public class SudokuPuzzle extends JFrame {
    public JPanel sudokuPanel;  // JPanel to hold the Sudoku grid
    private JTextField[][] cells;  // 2D array of JTextFields to represent the cells
    private SudokuGenerator generator;  // SudokuGenerator object to generate the Sudoku board

    public SudokuPuzzle() {
        // Initialize the generator and create the panel
        generator = new SudokuGenerator();
        sudokuPanel = new JPanel(new GridLayout(9, 9, 1, 1));  // Create a 9x9 grid layout with 1-pixel gaps between the cells
        cells = new JTextField[9][9];  // Create a 2D array of JTextFields to represent the cells

        // Create the cells for the panel
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                cells[row][col] = new JTextField();  // Create a new JTextField object
                cells[row][col].setHorizontalAlignment(JTextField.CENTER);  // Set the text alignment to center
                cells[row][col].setFont(new Font("Arial", Font.BOLD, 24));  // Set the font to Arial, bold, size 24
                cells[row][col].setPreferredSize(new Dimension(40, 40));  // Set the preferred size of the field to 40x40 pixels
                cells[row][col].setBorder(BorderFactory.createLineBorder(Color.GRAY));  // Set a gray border around the field
                sudokuPanel.add(cells[row][col]);  // Add the JTextField object to the panel

                // Set the value of the cell from the generator
                int val = generator.getBoard()[row][col];  // Get the value of the cell from the generator
                if (val != 0) {  // If the value is not zero, it is an initial value
                    cells[row][col].setText(Integer.toString(val));  // Set the text of the field to the value
                    cells[row][col].setEditable(false);  // Set the field to be not editable
                }
            }
        }

        // Create the frame and add the panel
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Set the default close operation to exit the application
        setTitle("Sudoku Puzzle");  // Set the title of the frame
        setSize(450, 450);  // Set the size of the frame to 450x450 pixels
        setResizable(false);  // Set the frame to be not resizable
        add(sudokuPanel);  // Add the panel to the frame
        setVisible(true);  // Set the frame to be visible
    }

    public static void main(String[] args) {
        new SudokuPuzzle();  // Create a new instance of the SudokuPuzzle class
    }
}
