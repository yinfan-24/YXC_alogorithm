package Chapter_1;

import java.io.*;
import java.util.*;

public class ACW_019_802_IntervalSum {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] l_input = reader.readLine().split(" ");
        int n = Integer.parseInt(l_input[0]);
        int m = Integer.parseInt(l_input[1]);
        int N = 300010;

        int[] a = new int[N];
        int[] s = new int[N];
        List<Pair> nums = new ArrayList<>();
        List<Pair> query = new ArrayList<>();
        List<Integer> alls = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] l_add = reader.readLine().split(" ");
            int x = Integer.parseInt(l_add[0]);
            int c = Integer.parseInt(l_add[1]);
            nums.add(new Pair(x, c));
            alls.add(x);
        }

        for (int i = 0; i < m; i++) {
            String[] l_query = reader.readLine().split(" ");
            int l = Integer.parseInt(l_query[0]);
            int r = Integer.parseInt(l_query[1]);
            query.add(new Pair(l, r));
            alls.add(l);
            alls.add(r);
        }
        Collections.sort(alls);
        int unique = unique(alls);
        alls = alls.subList(0, unique);

        for (Pair item : nums){
            int index = find(item.first, alls);
            a[index] += item.second;
        }

        for (int i = 1; i <= unique; i++) {
            s[i] = s[i-1] + a[i];
        }

        for (Pair item:query){
            int l = find(item.first, alls);
            int r = find(item.second, alls);
            writer.write((s[r] - s[l-1]) + "\n");
        }

        writer.flush();
        writer.close();
        reader.close();

    }

    public static int find(int x, List<Integer> list){
        int l = 0;
        int r = list.size()-1;
        while (l < r){
            int mid = (l + r)/2;
            if (list.get(mid) >= x) r = mid;
            else l = mid + 1;
        }
        return l+1;
    }

    public static int unique(List<Integer> list){
        int j = 0;
        for (int i = 0; i < list.size(); i++) {
            if (i == 0 || list.get(i) != list.get(i-1)){
                list.set(j, list.get(i));
                j++;
            }
        }
        return j;
    }

}


class Pair {
    public int first;
    public int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
/*
14 3
-9 -100
-7 8
-7 53
-6 27
-6 25
-6 978
-1 65
2 2
2 78
2 25
2 8
3 8
8 53
10 22
-7 2
-9 -6
-1 3
 */

/*
10 5
-50 9524
-19 -5705
33 1729
-8 -9723
-33 -5185
-29 7088
19 -4988
-37 985
-29 8888
-46 -5976

19 29
38 42
-17 24
25 49
9 24
 */