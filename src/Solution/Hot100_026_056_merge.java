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
        List<Pair> res = new ArrayList<>();
        int start = Integer.MIN_VALUE;
        int end = Integer.MIN_VALUE;
        int j = 0;
        for (int i = 0; i < unmerge.size(); i++) {
            int l = unmerge.get(i).first;
            int r = unmerge.get(i).second;
            if (j == 0){
                start = l;
                end = r;
                j = 1;
                continue;
            }
            if (l > end){
//                下一组区间与上一组没有共同部分，将上一组加入结果
                res.add(new Pair(start, end));
                start = l;
                end = r;
                continue;
            }
            if (r > end) end = r;
        }
//        最后一组必定没有在循环里面加入结果
        res.add(new Pair(start, end));
        int[][] ans = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            ans[i][0] = res.get(i).first;
            ans[i][1] = res.get(i).second;
        }
        return ans;
    }
}


