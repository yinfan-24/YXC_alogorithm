package Solution;

import netscape.security.UserTarget;

import java.util.Arrays;
import java.util.Stack;

public class Hot100_035_084_largestRectangleArea {
    public int largestRectangleArea(int[] heights) {

        int n = heights.length;
        int[] leftMin = new int[n];
        Arrays.fill(leftMin, -1);
        int stkPtr = -1;
        int[] stk = new int[n];

        int res = 0;
        for (int i = 0; i < n; i++) {
            int height = heights[i];
//            找到第一个小于height的元素索引
            while (stkPtr >= 0 && heights[stk[stkPtr]] >= height){
                int idx = stk[stkPtr--];
//                i是idx的右边界，因为i到idx之间没有其余的更小值
                res = Math.max(res, calArea(leftMin[idx], i, heights[idx]));
            }
            if (stkPtr >= 0) leftMin[i] = stk[stkPtr];
            stk[++stkPtr] = i;
        }
//        处理未出栈的元素：右边的元素都比它大
        while (stkPtr >= 0){
            int idx = stk[stkPtr--];
            res = Math.max(res, calArea(leftMin[idx], n, heights[idx]));
        }
        return res;
    }

    private static int calArea(int l, int r, int h){
        return (r-l-1) * h;
    }
}
