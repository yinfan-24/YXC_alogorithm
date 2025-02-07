package Solution;

import java.util.Arrays;

public class Hot100_028_064_minPathSum {
    private static int[][] memory;
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        memory = new int[m][n];
        for (int[] row: memory){
            Arrays.fill(row, -1);
        }
        return findMin(grid, m-1, n-1);
    }

    private static int findMin(int[][] grid, int i, int j){
        if (i == 0 && j == 0) return grid[0][0];
        if (i < 0 || j < 0) return Integer.MAX_VALUE;
        if (memory[i][j] != -1) return memory[i][j];
        memory[i][j] = Math.min(findMin(grid, i-1, j), findMin(grid, i, j-1)) + grid[i][j];
        return memory[i][j];
    }

}
