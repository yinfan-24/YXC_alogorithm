package Chapter_2;

import java.io.*;

public class ACW_036_840_SimulateHashMap {
    static int N = 100010, idx;
    static int[] h = new int[N];
    static int[] e = new int[N];
    static int[] ne = new int[N];

    public static void add(int x){
        int k = (x % N + N) % N;
        e[idx] = x;
        ne[idx] = h[k];
        h[k] = idx++;
    }
    public static boolean find(int x){
        int k = (x % N + N) % N;
        for (int i = h[k]; i != -1; i = ne[i]){
            if (e[i] == x) return true;
        }
        return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < N; i++) h[i] = -1;
        for (int i = 0; i < n; i++) {
            String[] line = reader.readLine().split(" ");
            if (line[0].equals("I")){
                add(Integer.parseInt(line[1]));
            }else {
                if (find(Integer.parseInt(line[1]))) {
                    writer.write("Yes\n");
                }else writer.write("No\n");
            }
        }
        reader.close();
        writer.flush();
        writer.close();
    }

}
