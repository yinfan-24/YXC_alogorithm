package Solution;

public class Hot100_034_079_exist {
    int m;
    int n;
    char[][] g;
    boolean[][] visited;
    String word;
    int[] dx = new int[]{0, 1, 0, -1};
    int[] dy = new int[]{1, 0, -1, 0};
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0){
            return false;
        }

        m = board.length;
        n = board[0].length;
        g = board;
        this.word = word;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (word.charAt(0) == board[i][j]){
//                    找到可能开始的开头
                    visited = new boolean[m][n];
                    if (dfs(i,j, new StringBuilder())){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    boolean dfs(int x, int y, StringBuilder sb){
//        还没纳入就已经满员
        if (sb.length() == word.length()) return false;

        sb.append(g[x][y]);
        visited[x][y] = true;

        if (sb.toString().equals(word))
            return true;

        for (int i = 0; i < 4; i++) {
            int a = x + dx[i];
            int b = y + dy[i];

            if (a<0 || a>=m || b<0 || b>=n || visited[a][b]){
                continue;
            }
            if (dfs(a,b,sb)) return true;
        }

        sb.deleteCharAt(sb.length()-1);
        visited[x][y] = false;
        return false;
    }
}
