package Chapter_2;

import java.io.*;


public class ACW_027_154_MonotonicQueue {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] l = reader.readLine().split(" ");
        int n = Integer.parseInt(l[0]);
        int k = Integer.parseInt(l[1]);
        l = reader.readLine().split(" ");
//        维护一个实时更新的队列
        int N = 1000010;
        int[] q = new int[N];//队列(存的是插入数的下标)
        int[] a = new int[N];//输入的数
        int hh = 0, tt = -1;
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(l[i]);
        for (int i = 0; i < n; i++) {
//            hh永远小于等于tt
//            1、控制hh指针。hh超过窗口范围时需要更新（队列的左边界）。
            while (hh <= tt && q[hh] < i-k+1) hh++;
//            2、控制tt指针。如果即将插入的元素比tt指针的小，则踢出队尾元素。（永远保持升序序列）
            while (hh <= tt && a[i] <= a[q[tt]]) tt--;
//            3、写入当前元素下标
            q[++tt] = i;
//            输出的条件：下标大于等于窗口元素才开始输出
            if(i >= k-1) writer.write(a[q[hh]] + " ");
        }
        writer.write("\n");
        hh = 0; tt = -1;
        for (int i = 0; i < n; i++) {
//            1、hh指针。超出窗口则++。
            while (hh <= tt && q[hh] < i-k+1) hh++;
//            2、tt指针。现在插入的元素比队尾大，tt--。
            while (hh <= tt && a[i] > a[q[tt]]) tt--;
//            3、写入当前元素。它一定要比处理后的队尾元素小。
            q[++tt] = i;
//            4、输出队头元素。
            if (i >= k-1) writer.write(a[q[hh]] + " ");
        }
        reader.close();
        writer.flush();
        writer.close();
    }
}

/*
8 3
1 3 -1 -3 5 3 6 7

8 3
1 3 -1 -3 5 3 6 7

 */