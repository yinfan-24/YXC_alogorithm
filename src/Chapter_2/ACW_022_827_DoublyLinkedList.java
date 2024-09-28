package Chapter_2;

import java.io.*;

public class ACW_022_827_DoublyLinkedList {
    static int N = 100010;
    static int idx;
    static int[] e = new int[N];
    static int[] l = new int[N];
    static int[] r = new int[N];
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] l_in = reader.readLine().split(" ");
        int m = Integer.parseInt(l_in[0]);

        r[0] = 1;
        l[1] = 0;
        idx = 2;

        while (m-- > 0){
            String[] ops_line = reader.readLine().split(" ");
            String op = ops_line[0];
            if (op.equals("L")){
                int x = Integer.parseInt(ops_line[1]);
                add_all(0, x);
            } else if (op.equals("R")) {
                int x = Integer.parseInt(ops_line[1]);
                add_all(l[1], x);
            } else if (op.equals("D")) {
                int k = Integer.parseInt(ops_line[1]);
                remove(k+1);
            } else if (op.equals("IL")) {
                int k = Integer.parseInt(ops_line[1]);
                int x = Integer.parseInt(ops_line[2]);
                add_all(l[k+1], x);
            }else {

                int k = Integer.parseInt(ops_line[1]);
                int x = Integer.parseInt(ops_line[2]);
                add_all(k+1, x);
            }

        }


        for (int i = r[0]; i != 1; i = r[i]) {
            writer.write(e[i] + " ");
        }


        reader.close();
        writer.flush();
        writer.close();

    }

    static void remove(int k){
        r[l[k]] = r[k];
        l[r[k]] = l[k];
    }

    static void add_all(int k, int x){
        e[idx] = x;
        r[idx] = r[k];
        l[idx] = k;
        l[r[k]] = idx;
        r[k] = idx++;
    }


}
