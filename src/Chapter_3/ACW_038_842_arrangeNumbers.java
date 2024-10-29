package Chapter_3;

import java.io.*;

public class ACW_038_842_arrangeNumbers {
    static int N = 10, n;
    static int[] path = new int[N];
    static boolean[] st = new boolean[N];
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(reader.readLine());
        dfs(0);
        reader.close();
        writer.flush();
        writer.close();
    }

    public static void dfs(int u) throws IOException {
        if (u == n){
            for (int i = 0; i < n; i++) {
                writer.write(path[i] + " ");
            }
            writer.write("\n");
        }
        for (int i = 1; i <= n ; i++){
            if (!st[i]){
                st[i] = true;
                path[u] = i;
                dfs(u+1);
                st[i] = false;
            }
        }
    }
}
