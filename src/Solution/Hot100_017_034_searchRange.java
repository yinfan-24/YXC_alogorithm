package Solution;

public class Hot100_017_034_searchRange {
    public static void main(String[] args) {
        int[] nums= {5,7,7,8,8,10};
        int[] res = searchRange(nums, 6);
        for (int idx: res){
            System.out.println(idx);
        }
    }
    public static int[] searchRange(int[] nums, int target) {
        if (nums.length == 0 || nums == null){
            int[] tmp = {-1, -1};
            return tmp;
        }
        int[] res = new int[2];
        int l = 0, r = nums.length - 1;

        while(l < r){
//            左边界
            int mid = l + r  >> 1;
            if (nums[mid] >= target) r = mid;
            else l = mid + 1;
        }
        int left_bound = l;

        l = 0;
        r = nums.length - 1;
//        右边界
        while(l < r){
            int mid = l + r + 1 >> 1;
            if (nums[mid] <= target) l = mid;
            else r = mid - 1;
        }
        int right_bound = l;

        if (nums[left_bound] == target){
            res[0] = left_bound;
        }else res[0] = -1;
        if (nums[right_bound] == target){
            res[1] = right_bound;
        }else res[1] = -1;

        return res;
    }
}
