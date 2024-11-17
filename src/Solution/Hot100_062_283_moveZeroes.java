package Solution;

public class Hot100_062_283_moveZeroes {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int l = 0, r = 0;
        while (r < n){
            if (nums[r] != 0){
                swap(nums, l, r);
                l ++;
            }
            r ++;
        }
    }

    public void swap(int[] nums, int a, int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
