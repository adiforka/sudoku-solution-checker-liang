package sudoku_solution;

public class SudokuSolutionChecker {

    public boolean isValid(int[][] grid) {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (grid[i][j] < 1 || grid[i][j] > 9 || !isValid(i, j, grid)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(int i, int j, int[][] grid) {

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
