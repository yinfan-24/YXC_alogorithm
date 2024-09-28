package Chapter_1;
import java.util.*;

public class ACW_012_796_SumOfSubmatrix {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        int q = input.nextInt();
        int[][] arr = new int[n+1][m+1];
        long[][] res = new long[n+1][m+1];
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                arr[i][j] = input.nextInt();
                res[i][j] = res[i-1][j] + res[i][j-1] - res[i-1][j-1] + arr[i][j];
            }
        }
        for (int k = 0; k < q; k++) {
            int x1 = input.nextInt();
            int y1 = input.nextInt();
            int x2 = input.nextInt();
            int y2 = input.nextInt();
            System.out.println(res[x2][y2] - res[x2][y1-1] - res[x1-1][y2] + res[x1-1][y1-1]);
        }
    }
}


/*
3 4 3
1 7 2 4
3 6 2 8
2 1 2 3
1 1 2 2
2 1 3 4
1 3 3 4
*/