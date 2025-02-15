package Solution;

public class Hot100_066_221_maximalSquare {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;

        int side = 0;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1'){
                    if (i == 0 || j == 0){
                        dp[i][j] = 1;
                    }else {
                        dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1;
                    }
                }
                side = Math.max(side, dp[i][j]);
            }
        }
        return side * side;
    }

    private static int min(int a, int b, int c){
        return Math.min(a, Math.min(b, c));
    }
}
