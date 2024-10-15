package Chapter_2;

import java.io.*;

public class ACW_037_841_StringHash {
    static int N = 100010, P = 131;
    static long[] h = new long[N];  // 存放hash前缀值的数组
    static long[] p = new long[N];  //  存放p的次方的数组
    public static long get(int l, int r){
        return h[r] - h[l-1] * p[r - l + 1];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] line = reader.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        String s = reader.readLine();
        p[0] = 1;
//        初始化hash数组
        for (int i = 1; i <= n; i++) {
            p[i] = p[i-1] * P;
            h[i] = h[i-1] * P + s.charAt(i-1);
        }
        for (int i = 0; i < m; i++) {
            line = reader.readLine().split(" ");
            int l1 = Integer.parseInt(line[0]);
            int r1 = Integer.parseInt(line[1]);
            int l2 = Integer.parseInt(line[2]);
            int r2 = Integer.parseInt(line[3]);
            if (get(l1, r1) == get(l2, r2)) writer.write("Yes\n");
            else writer.write("No\n");
        }
        
        reader.close();
        writer.flush();
        writer.close();

    }
}
