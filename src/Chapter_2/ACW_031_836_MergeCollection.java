package Chapter_2;

import java.io.*;

public class ACW_031_836_MergeCollection {
    static final int N = 100010;
    static int[] p = new int[N];
    public static int find(int x){
//        优化连接
        if (p[x] != x) p[x] = find(p[x]);
        return p[x];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] line = reader.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
//        初始化每个节点的父节点就是他自己
        for (int i = 1; i <= n; i++) p[i] = i;
        for (int i = 0; i < m; i++) {
            line = reader.readLine().split(" ");
            int a = Integer.parseInt(line[1]);
            int b = Integer.parseInt(line[2]);
            if (line[0].equals("M")){
//                合并
                p[find(a)] = find(b);
            }else {
//                查询
                if (find(a) == find(b)) writer.write("Yes\n");
                else writer.write("No\n");
            }
        }

        reader.close();
        writer.flush();
        writer.close();
    }
}

/*
5 10
M 2 3
Q 2 3
M 1 5
Q 3 2
M 1 4
Q 4 5
Q 1 2
Q 2 4
M 4 1
Q 5 3

Yes
Yes
Yes
No
No
No
 */