package sudoku_solution;

public class SudokuSolutionDemo {
    public static void main(String[] args) throws Exception {

        var solutionGetter = new SudokuSolutionGetter();
        var checker = new SudokuSolutionChecker();

        int[][] solutionGrid = solutionGetter.getSolution("src/sudoku_solution/sudoku solution");

        System.out.println(
                //Elvis lives!
                checker.isValid(solutionGrid) ? "Valid solution" : "Invalid solution");
    }
}

