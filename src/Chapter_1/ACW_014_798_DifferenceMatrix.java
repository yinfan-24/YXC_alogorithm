package Chapter_1;

import java.io.*;

public class ACW_014_798_DifferenceMatrix {
        public static void main(String[] args) throws IOException {
            //普遍Scanner会超时，所以使用BufferedReader
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
            String[] str1 = reader.readLine().split(" ");

            int n = Integer.parseInt(str1[0]);
            int m = Integer.parseInt(str1[1]);
            int q = Integer.parseInt(str1[2]);
            int N = 1010;
            int[][] a = new int[N][N];
            int[][] b = new int[N][N];

            // 读入原数组
            for (int i = 1; i <= n; i++) {
                String[] str2 = reader.readLine().split(" ");
                for (int j = 1; j <= m; j++) {
                    a[i][j] = Integer.parseInt(str2[j-1]);
                    // 初始化差分数组
                    insert(b, i, j, i, j, a[i][j]);
                }
            }


            while (q-- > 0) {
                String[] str3 = reader.readLine().split(" ");
                int x1 = Integer.parseInt(str3[0]);
                int y1 = Integer.parseInt(str3[1]);
                int x2 = Integer.parseInt(str3[2]);
                int y2 = Integer.parseInt(str3[3]);
                int k  =  Integer.parseInt(str3[4]);
                insert(b, x1, y1, x2, y2, k);
            }

            // 求b数组的前缀和
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    b[i][j] += b[i][j - 1] + b[i - 1][j] - b[i - 1][j - 1];
                    //输出
                    writer.write(b[i][j] + " ");
                }
                writer.write("\n");
            }
            //所有write下的内容，会先存在writers中，当启用flush以后，会输出存在其中的内容。如果没有调用flush，则不会将writer中的内容进行输出。
            writer.flush();
            reader.close();
            writer.close();
        }

        // 插入操作函数
        private static void insert(int[][] b, int x1, int y1, int x2, int y2, int k) {
            b[x1][y1] += k;
            b[x2 + 1][y1] -= k;
            b[x1][y2 + 1] -= k;
            b[x2 + 1][y2 + 1] += k;
        }

    }


/*
3 4 3

1 2 2 1
3 2 2 1
1 1 1 1

1 1 2 2 1
1 3 2 3 2
3 1 3 4 1


3 4 3
1 2 2 1
3 2 2 1
1 1 1 1
1 1 2 2 1
1 3 2 3 2
3 1 3 4 1
 */