package Solution;

public class Hot100_021_048_matrix {
    public static void rotate(int[][] matrix) {
        int n = matrix[0].length;
//        先对角线对称
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

//        再竖直对称
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < n/2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n-j];
                matrix[i][n-j] = tmp;
            }
        }
    }
}
