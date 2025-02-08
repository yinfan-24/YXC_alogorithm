package Solution;

public class Hot100_031_075_sortColors {
//    从小到大排序
    public void sortColors(int[] nums) {
        quickSort(nums, 0, nums.length-1);
    }

    private static void quickSort(int[] nums, int begin, int end){
        if (begin >= end) return;
        int ref = nums[begin+end >> 1];
        int l = begin--, r = end++;
        while (l < r){
            while (nums[++l] < ref);
            while (nums[--r] > ref);
            if (l < r){
                swap(nums, l, r);
            }
        }
        quickSort(nums, begin, r);
        quickSort(nums, r+1, end);
    }

    private static void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
