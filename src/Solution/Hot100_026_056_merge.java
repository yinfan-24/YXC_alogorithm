package Solution;

import java.util.*;

public class Hot100_026_056_merge {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)-> Integer.compare(a[0], b[0]));

        List<int[]> res = new LinkedList<>();
        int[] merged = intervals[0];
        for (int[] interval: intervals){
            if (interval[0] > merged[1]){
                res.add(merged);
                merged = interval;
            }else {
                merged[1] = Math.max(interval[1], merged[1]);
            }
        }
        res.add(merged);
        return res.toArray(new int[res.size()][]);
    }
}


