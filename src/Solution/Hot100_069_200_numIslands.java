package Solution;

public class Hot100_069_200_numIslands {
    public static int numIslands(char[][] grid) {
        int gridRow = grid.length, gridCol= grid[0].length;

        int res = 0;
        for (int i = 0; i < gridRow; i++) {
            for (int j = 0; j < gridCol; j++) {
                if (grid[i][j] == '1'){
                    res++;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    private static void dfs(char[][] grid, int i, int j){
        int gridRow = grid.length, gridCol= grid[0].length;
        if (i < 0 || i >= gridRow || j < 0 || j >= gridCol || grid[i][j] == '0') return;

        grid[i][j] = '0';
        dfs(grid, i-1, j);
        dfs(grid, i+1, j);
        dfs(grid, i, j-1);
        dfs(grid, i, j+1);
    }

}
