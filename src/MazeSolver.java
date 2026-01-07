public class MazeSolver {

    private static final char WALL = '#';
    private static final char FREE = ' ';
    private static final char PATH = '.';
    private static final char START = 'S';
    private static final char END = 'E';

    private char[][] maze = {
            {'#', '#', '#', '#', '#', '#', '#'},
            {'#', 'S', ' ', '#', ' ', ' ', '#'},
            {'#', ' ', '#', '#', ' ', '#', '#'},
            {'#', ' ', ' ', ' ', ' ', '#', '#'},
            {'#', '#', '#', ' ', '#', ' ', '#'},
            {'#', ' ', ' ', ' ', ' ', 'E', '#'},
            {'#', '#', '#', '#', '#', '#', '#'}
    };

    private int startRow = 1, startCol = 1;
    private int endRow = 5, endCol = 5;

    public boolean findPath(int row, int col) {

        // 1) Out of bounds
        if (row < 0 || row >= maze.length || col < 0 || col >= maze[0].length) {
            return false;
        }

        // 2) Wall or already part of path
        if (maze[row][col] == WALL || maze[row][col] == PATH) {
            return false;
        }

        // 3) Reached the cheese
        if (row == endRow && col == endCol) {
            return true;
        }

        // 4) Mark visited (but don't overwrite S)
        if (maze[row][col] != START) {
            maze[row][col] = PATH;
        }

        //  RECURSION HAPPENS HERE

        if (findPath(row - 1, col)) return true; // up
        if (findPath(row, col + 1)) return true; // right
        if (findPath(row + 1, col)) return true; // down
        if (findPath(row, col - 1)) return true; // left

        // BACKTRACKING PART

        if (maze[row][col] == PATH) {
            maze[row][col] = FREE;
        }
        return false;
    }

    public void printMaze() {
        for (char[] line : maze) {
            for (char c : line) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        MazeSolver solver = new MazeSolver();

        System.out.println("Maze before:");
        solver.printMaze();

        boolean solved = solver.findPath(solver.startRow, solver.startCol);

        System.out.println("\nSolved? " + solved);
        System.out.println("\nMaze after:");
        solver.printMaze();
    }
}
