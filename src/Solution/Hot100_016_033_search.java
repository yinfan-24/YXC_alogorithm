package Solution;

public class Hot100_016_033_search {
    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0){
            return -1;
        }

        int l = 0, r = nums.length - 1;
//        先找到旋转点
        while (l < r){
            int mid = l + r >> 1;
            if (nums[mid] < nums[0]) r = mid;
            else l = mid + 1;
        }
        if (nums[l] == target) return l;

        if (nums[0] > target){
//            target在右边
            l = l;
            r = nums.length - 1;
        }else {
            l = 0;
            r = r - 1;
        }

        while (l < r){
            int mid = l + r >> 1;
            if (nums[mid] >= target) r = mid;
            else l = mid + 1;
        }
        if (nums[l] == target) return l;
        return -1;
    }
}
