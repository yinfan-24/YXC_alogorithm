package Chapter_2;

import java.io.*;

public class ACW_029_835_TireString {
    static int N = 100010,idx = 0;
    static int[][] son = new int[N][26];
    static int[] cnt  = new int[N];
//    static char[] str = new char[N];
    public static void insert(char[] str){
        int p = 0;
        for (int i = 0; i < str.length; i++) {
            int u = str[i] - 'a';
//            为没有插入过的节点赋编号
//            第一坐标为编号，第二坐标为二十六个字母编号
            if (son[p][u] == 0) son[p][u] = ++idx;
            p = son[p][u];
        }
        cnt[p]++;
    }
    public static int query(char[] str){
        int p = 0;
        for (int i = 0; i < str.length; i++) {
            int u = str[i] - 'a';
            if (son[p][u] == 0) return 0;
            p = son[p][u];
        }
        return cnt[p];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] line = reader.readLine().split(" ");
            if (line[0].equals("I")) {
                insert(line[1].toCharArray());
            }
            else{
                writer.write(query(line[1].toCharArray()) + "\n");
            }
        }

        reader.close();
        writer.flush();
        writer.close();
    }
}


/*
3
aba
5
ababa
 */