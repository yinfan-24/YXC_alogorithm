package Chapter_1;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ACW_020_803_IntervalMerging {
    //    区间排序
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] l1  = reader.readLine().split(" ");
        int n = Integer.parseInt(l1[0]);
        List<Pair_interval> merge = new ArrayList<>();
        List<Integer> alls = new ArrayList<>();
        List<Pair_interval> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] l_input = reader.readLine().split(" ");
            long l = Integer.parseInt(l_input[0]);
            long r = Integer.parseInt(l_input[1]);
            merge.add(new Pair_interval(l, r));
        }
//        Collections.sort(merge, (p1, p2) -> Integer.compare(p1.first, p2.first));
        Collections.sort(merge, Comparator.comparingLong(p -> p.first));
        int j = 0;
        long start = -1000000010;
        long end = 1000000000+1;
        for (Pair_interval item : merge){
            long l = item.first;
            long r = item.second;
            if (j == 0){
                start = item.first;
                end = item.second;
                j = 1;
                continue;
            }
            if (l > end) {
                res.add(new Pair_interval(start, end));
                start = l;
                end = r;
                continue;
            }
            if (r > end) end = r;
//            if (item.)
        }
        writer.write((res.size()+1) + "");

        writer.flush();
        writer.close();
        reader.close();
    }

}

class Pair_interval {
    public long first;
    public long second;
    public Pair_interval(long first, long second) {
        this.first = first;
        this.second = second;
    }
}

/*
5
1 2
2 4
5 6
7 8
7 9
 */