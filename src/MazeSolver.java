public class MazeSolver{
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


    public static void main(String[] args){
        MazeSolver Solver = new MazeSolver();


    }



}
