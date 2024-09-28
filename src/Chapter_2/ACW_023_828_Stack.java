package Chapter_2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ACW_023_828_Stack {
//    static List<Long> stack = new ArrayList<Long>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] line_in = reader.readLine().split(" ");
        int m  = Integer.parseInt(line_in[0]);
        int[] arr = new int[100010];
        int tt = 0;

        for (int i = 0; i < m; i++) {
            String[] line_ops = reader.readLine().split(" ");
            String op = line_ops[0];
            if (op.equals("push")){
                int x = Integer.parseInt(line_ops[1]);
                arr[++tt] = x;
            } else if (op.equals("pop")) {
                tt--;
            } else if (op.equals("empty")) {
                if (tt > 0) writer.write("No\n");
                else writer.write("Yes\n");
            }else {
                writer.write(arr[tt] + "\n");
            }
        }

        writer.flush();
        writer.close();
        reader.close();
    }
}
