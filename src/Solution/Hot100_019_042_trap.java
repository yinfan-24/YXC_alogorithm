package Solution;

public class Hot100_019_042_trap {
    public static int trap(int[] height) {
        if (height == null || height.length <= 2) return 0;
        int res = 0;
        int n = height.length;
        int[] left_height = new int[n+1];
        int[] right_height = new int[n+1];
        left_height[0] = height[0];
        right_height[n-1] = height[n-1];
//        从左往右看的每个位置的最大值
        for (int i = n-2; i >=0 ; i--) {
            right_height[i] = Math.max(height[i], right_height[i+1]);
        }
//        左边柱子高度的最大值
        for (int i = 1; i < n; i++) {
            left_height[i] = Math.max(height[i], left_height[i-1]);
        }
//        遍历每个位置
        for (int i = 0; i < n; i++) {
            int h = Math.min(left_height[i], right_height[i]);
            if (h > height[i]) {
                res += h - height[i];
            }
        }
        return res;
    }
}
