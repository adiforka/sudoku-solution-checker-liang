package sudoku_solution;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class SudokuSolutionChecker {
    public static void main(String[] args) throws Exception {

        var checker = new SudokuSolutionChecker();

        int[][] solutionGrid = checker.getSolution("src/sudoku_solution/sudoku solution");

        System.out.println(
                checker.isValidSolution(solutionGrid) ? "Valid solution" : "Invalid solution");
    }

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

    public boolean isValidSolution(int[][] grid) {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (grid[i][j] < 1 || grid[i][j] > 9 || !isValidSolution(i, j, grid)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValidSolution(int i, int j, int[][] grid) {

        //checking uniqueness of element in its row
        for (int col = 0; col < 9; col++) {
            if (j != col && grid[i][j] == grid[i][col]) {
                return false;
            }
        }

        //checking uniqueness of element in its column
        for (int row = 0; row < 9; row++) {
            if (row != i && grid[row][j] == grid[i][j]) {
                return false;
            }
        }

        //checking uniqueness of element in its 3*3 local block_
        return isValidLocalBlock(i, j, grid);
    }

    private boolean isValidLocalBlock(int i, int j, int[][] grid) {

        //local denotes part of a 3*3 grid cell block
        int startingLocalRow = (i / 3) * 3;
        int startingLocalCol = (j / 3) * 3;
        for (int row = startingLocalRow; row < startingLocalRow + 3; row++) {
            for (int col = startingLocalCol; col < startingLocalCol + 3; col++) {
                if (!(row == i && col == j) && grid[i][j] == grid[row][col]) {
                    return false;
                }
            }
        }
        return true;
    }
}
