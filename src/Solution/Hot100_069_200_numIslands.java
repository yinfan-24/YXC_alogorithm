package Solution;

public class Hot100_069_200_numIslands {
    int max_w;
    int max_d;
    int res;
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        max_w = grid.length;
        max_d = grid[0].length;

        for (int i = 0; i < max_w; i++) {
            for (int j = 0; j < max_d; j++) {
                if (grid[i][j] == '1'){
                    dfs(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    public void dfs(char[][] grid, int w, int d){
        if (w < 0 || d < 0 || w >= max_w || d >= max_d || grid[w][d] == '0'){
            return;
        }
        grid[w][d] = '0';
        dfs(grid, w+1, d);
        dfs(grid, w-1, d);
        dfs(grid, w, d+1);
        dfs(grid, w, d-1);
    }
}
