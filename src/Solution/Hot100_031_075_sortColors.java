package Solution;

public class Hot100_031_075_sortColors {
//    从小到大排序
    public void sortColors(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    public static void quickSort(int[] nums, int begin, int end){
        if (begin >= end) return;
        int ref = nums[begin + end >> 1];
        int l = begin - 1, r = end + 1;
        while (l < r){
            while (nums[++l] < ref);
            while (nums[--r] > ref);
            if (l < r){
                int tmp = nums[l];
                nums[l] = nums[r];
                nums[r] = tmp;
            }
        }
        quickSort(nums, begin, r);
        quickSort(nums,r+1, end);
    }
}
