package Solution;

import java.util.Arrays;

public class Hot100_036_085_maximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int maxArea = 0;
        int[] height = new int[matrix[0].length];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] == '1'){
                    height[col] += 1;
                }else height[col] = 0;
            }
            maxArea = Math.max(maxArea, largestRectangleArea(height));
        }
        return maxArea;
    }

    public static int largestRectangleArea(int[] heights){
        int n = heights.length;
        int[] leftMin = new int[n];
        Arrays.fill(leftMin, -1);
        int[] stack = new int[n];
        int stkPtr = -1;

        int res = 0;
        for (int i = 0; i < n; i++) {
            int height = heights[i];
            while (stkPtr >= 0 && heights[stack[stkPtr]] >= height){
                int idx = stack[stkPtr--];
                res = Math.max(res, calArea(leftMin[idx], i, heights[idx]));
            }
            if (stkPtr >=0 ) leftMin[i] = stack[stkPtr];
            stack[++stkPtr] = i;
        }

        while (stkPtr >= 0){
            int idx = stack[stkPtr--];
            res = Math.max(res, calArea(leftMin[idx], n, heights[idx]));
        }
        return res;
    }

    private static int calArea(int l, int r, int h){
        return (r-l-1) * h;
    }

}
