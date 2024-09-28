package Chapter_1;


import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ACW_019_802_IntervalSum_YXC {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] l_input = reader.readLine().split(" ");
        int n = Integer.parseInt(l_input[0]);
        int m = Integer.parseInt(l_input[1]);
        int N = 300010;
        int[] a = new int[N];
        int[] s = new int[N];


        List<Integer> alls = new ArrayList<>();
        List<Pair_YXC> add = new ArrayList<>();
        List<Pair_YXC> query = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] line_arr_input = reader.readLine().split(" ");
            int x = Integer.parseInt(line_arr_input[0]);
            int c = Integer.parseInt(line_arr_input[1]);
            add.add(new Pair_YXC(x, c));
            alls.add(x);
        }
        for (int i = 0; i < m; i++) {
            String[] line_query = reader.readLine().split(" ");
            int l = Integer.parseInt(line_query[0]);
            int r = Integer.parseInt(line_query[1]);
            query.add(new Pair_YXC(l, r));
            alls.add(l);
            alls.add(r);
        }

        Collections.sort(alls);
        int unique = unique(alls);
        alls = alls.subList(0, unique);

        for (Pair_YXC item : add){
            int index = find(item.first, alls);
            a[index] += item.second;
        }
        for (int i = 1; i <= alls.size(); i++) {
            s[i] = s[i-1] + a[i];
        }
        for (Pair_YXC item : query){
            int l = find(item.first, alls);
            int r = find(item.second, alls);
            writer.write((s[r] - s[l-1]) + "\n");
        }

        reader.close();
        writer.flush();
        writer.close();

    }
    public static int find(int x, List<Integer> list){
        int l = 0;
        int r = list.size() - 1;
        while (l < r){
            int mid = (l + r) / 2;
            if (list.get(mid) >= x) r = mid;
            else l = mid + 1;
        }
        return l + 1;
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
class Pair_YXC{
    int first;
    int second;
    public Pair_YXC(int x, int c){
        this.first = x;
        this.second = c;
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