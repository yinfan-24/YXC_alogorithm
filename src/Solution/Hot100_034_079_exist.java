package Solution;

public class Hot100_034_079_exist {

    static int[][] DIRC = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public boolean exist(char[][] board, String word) {
        int[] cnt = new int[128];
        for (char[] row : board){
            for (char c: row){
                cnt[c]++;
            }
        }

        char[] w = word.toCharArray();
        int[] w_cnt = new int[128];
        for (char c: w){
            w_cnt[c]++;
            if (w_cnt[c] > cnt[c]) return false;
        }
        if (cnt[w[w.length-1]] < cnt[w[0]]){
            w = new StringBuilder(word).reverse().toString().toCharArray();
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(i, j, 0, board, w)){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(int i, int j, int k, char[][] board, char[] w){
        if (board[i][j] != w[k]) return false;
        if (k == w.length-1) return true;

        board[i][j] = 0;
        for (int[] dic: DIRC){
            int x = i + dic[0];
            int y = j + dic[1];
            if (x >=0 && x < board.length && y >= 0 && y < board[0].length && dfs(x, y, k++, board, w)){
                return true;
            }
        }
        board[i][j] = w[k];
        return false;
    }

}
