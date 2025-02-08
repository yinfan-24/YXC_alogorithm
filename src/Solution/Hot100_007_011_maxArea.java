package Solution;

public class Hot100_007_011_maxArea {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }
    public static int maxArea(int[] height) {
        int res = 0;
//        双指针算法，每次都移动短的板
        for (int l = 0, r = height.length-1; l < r ; ) {
            res = Math.max(res, (r-l) * Math.min(height[l], height[r]));
            if (height[l] < height[r]) l++;
            else r--;
        }
        return res;
    }

//    public static int maxArea(int[] height) {
//        int res = 0;
//        for (int l = 0, r = height.length-1; l < r;) {
//            res = Math.max(res, (r-l) * Math.min(height[l], height[r]));
//            if (height[l] > height[r]){
//                r --;
//            } else l++;
//        }
//        return res;
//    }
}
