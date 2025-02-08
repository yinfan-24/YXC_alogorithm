package Solution;

public class Hot100_015_031_nextPermutation {
    public static void main(String[] args) {
//        int[] tmp = {1, 7, 6, 5, 4};
//        System.out.println(nextPermutation(tmp));
    }
    public static void nextPermutation(int[] nums) {
        int len = nums.length;
//        找到第一个升序的位置记为 flag
        int flag = len-2;
        while (flag >= 0 && nums[flag] >= nums[flag+1]){
            flag--;
        }
        if (flag < 0) {
            swapAll(nums, 0, len-1);
            return;
        }
//            二分查找，找到降序序列中第一个比flag大的数
        int l = flag+1;
        int r = len-1;
        while (l<r){
            int mid = l+r+1 >> 1; // 偏向于取右边界
            if (nums[mid] > nums[flag]){
                l = mid;
            } else {
                r = mid-1;
            }
        }
//        直接顺序查找也是0ms
//        int first = len-1;
//        while (nums[first] < nums[flag]) first--;
//        swap(nums, first, flag);
//        交换两个数，然后交换所有逆序部分
        System.out.println(l);
        swap(nums, l, flag);
        swapAll(nums, flag+1, len-1);
    }

    public static void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void swapAll(int[] nums, int l, int r){
        while (l < r){
            swap(nums, l, r);
            l++;
            r--;
        }
    }
}
