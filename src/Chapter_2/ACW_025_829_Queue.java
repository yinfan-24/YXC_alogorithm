package Chapter_2;

import java.io.*;

public class ACW_025_829_Queue {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] l = reader.readLine().split(" ");
        int x = Integer.parseInt(l[0]);
        int front = 0, end = 0;
        long[] queue = new long[100010];
        for (int i = 0; i < x; i++) {
            l = reader.readLine().split(" ");
            String op = l[0];
            if (op.equals("push")){
                queue[end++] = Long.parseLong(l[1]);
            } else if (op.equals("pop")) {
                front++;
            } else if (op.equals("query")){
                writer.write(queue[front] + "\n");
            }else {
//                empty
                if (front == end) writer.write("YES\n");
                else writer.write("NO\n");
            }
        }
        reader.close();
        writer.flush();
        writer.close();
    }
}
