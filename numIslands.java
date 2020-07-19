
public class numIslands {

    public static int numislands(char[][] grid) {
        int count = 0;
        int[][] seen = new int[grid.length][grid[0].length];
        for(int row = 0; row < grid.length; ++row) {
            for(int col = 0; col < grid[0].length; ++col) {
                count += checkNeighbours(grid, seen, row, col);
            }
        }
        return count;
    }

    public static int checkNeighbours(char[][] grid, int[][] seen, int row, int col) {
        if (row < 0 || col < 0 || row >= seen.length || col >= seen[0].length || seen[row][col] != 0 || grid[row][col] != 1) {
            return 0;
        }
        seen[row][col] = 1;
        checkNeighbours(grid, seen, row - 1, col);
        checkNeighbours(grid, seen, row + 1, col);
        checkNeighbours(grid, seen, row, col - 1);
        checkNeighbours(grid, seen, row, col + 1);
        return 1;
    }

    public static void main(String args[]) {
        char[][] grid = { { 1, 1, 1, 1, 0 }, { 1, 1, 0, 1, 0 }, { 1, 1, 0, 0, 0 }, { 0, 0, 0, 0, 0 } };
        int islands = numislands(grid);
        char[][] grid2 = { { 1,1,0,0,0}, { 1,1,0,0,0 }, { 0,0,1,0,0 }, {0,0,0,1,1 } };
        int islands2 = numislands(grid2);
        System.out.println("The total number of islands is: " + islands);
        System.out.println("The total number of islands is: " + islands2);
    }
}