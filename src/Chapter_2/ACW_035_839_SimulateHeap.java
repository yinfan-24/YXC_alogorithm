package Chapter_2;

import java.io.*;

public class ACW_035_839_SimulateHeap {
    static final int N = 100010;
    static int[] heap  = new int[N];
    static int size;

//    小根堆
//    1、插入：每次从队尾加入
//    2、删除：尾结点覆盖，然后down。


    public static void swap(int x, int y){
        int t = heap[x];
        heap[x] = heap[y];
        heap[y] = t;
    }

    public static void down(int u){
        int t = u;
//        t选择3个点中最小的那个
        if (u*2 <= size && heap[u*2] < heap[t]) t = u*2;
        if (u*2 + 1 <= size && heap[u*2 + 1] < heap[t]) t = u*2 + 1;
        if (t != u){
            swap(t, u);
//            继续下沉至不冲突的位置
            down(t);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] line = reader.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        line = reader.readLine().split(" ");
        for (int i = 1; i <= n; i++) heap[i] = Integer.parseInt(line[i-1]);
        size = n;
//        只用排序最后一层以上的节点
        for (int i = n/2; i >= 1; i--) down(i);

        while (m-- > 0){
            writer.write(heap[1] + " " );
            heap[1] = heap[size--];
            down(1);
        }
        reader.close();
        writer.flush();
        writer.close();
    }
}

