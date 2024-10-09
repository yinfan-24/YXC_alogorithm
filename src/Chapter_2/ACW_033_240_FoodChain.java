package Chapter_2;

import java.io.*;

public class ACW_033_240_FoodChain {
    static final int N = 50010, K = 100010;
//    存储父节点的编号
    static int[] p = new int[N];
//    存储当前节点距离父节点的距离
    static int[] d = new int[N];

    public static int find(int x){
//        路径压缩
        if (p[x] != x){
            int t = find(p[x]);
            d[x] += d[p[x]];
            p[x] = t;
        }
        return p[x];
    }
//    只要有过相关操作就加入一个集合，通过修改路径的权重值，决定关系
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] line = reader.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        int res = 0;
//        初始化每个节点的父节点都是自己，有多少个节点就有多少个集合
        for (int i = 1; i <= n; i++) p[i] = i;
        for (int i = 0; i < m; i++) {
            line = reader.readLine().split(" ");
            int op = Integer.parseInt(line[0]);
            int x = Integer.parseInt(line[1]);
            int y = Integer.parseInt(line[2]);
            if (x > n || y > n) {
                res++;
            }else {
                int px = find(x), py = find(y);
                if (op == 1){
//                声明 x 和 y是同类

                    if (px == py && (d[x] - d[y]) % 3 != 0) res++;
                    else if (px != py) {
//                    声明成立，将x加入到y的集合种来
//                    find函数执行时就会做路径压缩，这里直接连通即可
                        p[px] = py;
                        d[px] = d[y] - d[x];
                    }
                }else {
//                声明x 吃 y
//                    TODO:为什么x吃y的关系不是(d[x] - d[y]) % 3 != 1，而是 (d[x] - d[y] - 1) % 3 != 0
                    if (px == py && (d[x] - d[y] - 1) % 3 != 0) res++;
                    else if (px != py) {
                        p[px] = py;
                        d[px] = d[y] - d[x] + 1;
                    }
                }
            }


        }
        writer.write(res + "");
        reader.close();
        writer.flush();
        writer.close();
    }
}

