package Chapter_2;

import java.io.*;

public class ACW_035_839_SimulateHeap {
    static int N = 100010, size, m;
    static int[] h  = new int[N];
    static int[] hp  = new int[N];
    static int[] ph  = new int[N];

    public static void swap(int[] a, int x, int y){
        int tmp = a[x];
        a[x] = a[y];
        a[y] = tmp;
    }

    public static void heap_swap(int x, int y) {
       swap(ph, hp[x], hp[y]);
       swap(hp, x, y);
       swap(h, x, y);
    }
    public static void down(int x){
        int t = x;
        if (2*x <= size && h[2*x] < h[t]) t = 2*t + 1;
        if (2*x + 1 <= size && h[2*x + 1] < h[t]) t = 2*x + 1;
        if (t != x){
            heap_swap(x, t);
            down(t);
        }
    }
    public static void up(int x){
        while (x / 2 >0 && h[x / 2] > h[x]){
            heap_swap(x, x/2);
            x = x / 2;
        }
    }
    //    小根堆
//    1、插入：每次从队尾加入
//    2、删除：尾结点覆盖，然后down。

//    I x，      插入一个数 x
//    PM，       输出当前集合中的最小值；
//    DM，       删除当前集合中的最小值（数据保证此时的最小值唯一）；
//    D k，      删除第 k个插入的数；
//    C k x，    修改第 k个插入的数，将其变为 x



    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(reader.readLine());
        size = 0;
        m = 0;
        for (int i = 0; i < n; i++) {
            String[] line = reader.readLine().split(" ");
            if (line[0].equals("I")){
                int a = Integer.parseInt(line[1]);
                size++; m++;
                ph[m] = size; hp[size] = m;
                h[size] = a;
                up(size);
            } else if (line[0].equals("PM")) {
                writer.write(h[1] + "\n");
            } else if (line[0].equals("DM")) {
                heap_swap(1, size);
                size--;
                down(1);
            } else if (line[0].equals("D")) {
//                删除第k个插入的数
                int a = Integer.parseInt(line[1]);
                a = ph[a];
                heap_swap(a, size);
                size--;
                up(a);
                down(a);
            }else {
//                修改第k个插入的数
                int a = Integer.parseInt(line[1]);
                int b = Integer.parseInt(line[2]);
                a = ph[a];
                h[a] = b;
                up(a);
                down(a);
            }
        }
        reader.close();
        writer.flush();
        writer.close();
    }
}

/*
I -10
PM
I -10
D 1
C 2 8
I 6
PM
DM
 */