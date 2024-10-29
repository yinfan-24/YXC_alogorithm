package Solution;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Hot100_026_056_merge {
    public int[][] merge(int[][] intervals) {
        List<Pair> unmerge = new ArrayList<>();
//        先对各个离散区间，依据左端点进行排序
        int n = intervals.length;
        for (int i = 0; i < n; i++) {
            unmerge.add(new Pair(intervals[i][0], intervals[i][1]));
        }
        Collections.sort(unmerge);
//        依次遍历，如果当前右端点的最大值够不到左端点。那么加入结果。
        int[][] res = new int[n][2];
        

    }
}


