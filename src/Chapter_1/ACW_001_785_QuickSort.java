package Chapter_1;

import java.io.*;
import java.util.*;

public class ACW_001_785_QuickSort {
    static final int N = 100010;
    static int[] num = new int[N];
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(reader.readLine().split(" ")[0]);
        String[] arr_line = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) num[i] = Integer.parseInt(arr_line[i]);

        quickSort(0, n-1);
        for (int i = 0; i < n; i++) writer.write(num[i] + " ");
        reader.close();
        writer.flush();
        writer.close();
    }

    public static void quickSort(int begin, int end){
        if (begin >= end) return;
        int ref = num[begin + end >> 1];
        int l = begin - 1, r = end + 1;
        while (l < r){
            while (num[++l] < ref);
            while (num[--r] > ref);
            if (l < r){
                int tmp = num[l];
                num[l] = num[r];
                num[r] = tmp;
            }
        }// …… , r, l, ……

        quickSort(begin, r);
        quickSort(r+1, end);
    }

}

/*
10
49 59 88 37 98 97 68 54 31 3
 */