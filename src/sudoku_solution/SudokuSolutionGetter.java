package sudoku_solution;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//added for increased readability and naming consistency
//with Single Responsibility Principle for classes
//this class gets the solution, the checker class checks it
public class SudokuSolutionGetter {

    public int[][] getSolution(String path) throws FileNotFoundException {

        File file = new File(path);
        Scanner scanner = new Scanner(file);
        int[][] solutionGrid = new int[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                solutionGrid[i][j] = scanner.nextInt();
            }
        }
        return solutionGrid;
    }
}
