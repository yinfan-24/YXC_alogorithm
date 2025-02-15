package Solution;

public class Hot100_067_215_findKthLargest {
    public int findKthLargest(int[] nums, int k){
        return quickSelct(nums, nums.length-k, 0, nums.length-1);
    }

    public static int quickSelct(int[] nums, int k, int begin, int end){
//        需要返回索引为k的元素
        if (begin == end) return nums[k];

        int ref = nums[begin+end >> 1];
        int l = begin-1, r = end+1;
        while (l < r){
            while (nums[++l] < ref);
            while (nums[--r] > ref);
            if (l < r){
                int tmp = nums[l];
                nums[l] = nums[r];
                nums[r] = tmp;
            }
        }
        if (r >= k) return quickSelct(nums, k, begin, r);
        else return quickSelct(nums, k, r+1, end);
    }
}
