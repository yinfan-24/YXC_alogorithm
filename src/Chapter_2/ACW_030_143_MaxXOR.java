package Chapter_2;

import java.io.*;

import static java.lang.Math.max;

public class ACW_030_143_MaxXOR {
    static int N = 3100010, idx;
    static int[][] son = new int [N][2];
    static int[] a = new int[N];

    public static void insert(int x){
        int p = 0;
        for (int i = 30; i >= 0; i--) {
            int u = x >> i & 1;
            if (son[p][u] == 0) son[p][u] = ++idx;
            p = son[p][u];
        }
    }

    public static int query(int x){
        int p = 0, res = 0;
        for (int i = 30; i >= 0; i--){
            int u = x >> i & 1;
//            存在与当前节点相反的，异或的结果一定是1
            if(son[p][1-u] != 0){
                res += 1 << i;
                p = son[p][1-u];
            }else {
//                不存在的话，异或的结果一定为0，不用加入res中
                p = son[p][u];
            }
        }
        return res;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(reader.readLine());
        String[] line = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(line[i]);
            insert(a[i]);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = max(res, query(a[i]));
        }
        reader.close();
        writer.write(res + "");
        writer.flush();
        writer.close();

    }
}


/*
10
181262 369842 1036879 546331 868986 496157 646816 459571 215643 448018
 */