package Solution;

public class Hot100_015_031_nextPermutation {
    public static void nextPermutation(int[] nums) {
//        if (nums.length <= 1) return;

//        从后往前数，遇到的第一个： nums[i] < nums[i+1]的
        int n = nums.length;
        int flag = n - 2;
        while (flag >= 0 && nums[flag] >= nums[flag+1]){
//            从右往左找，找到第一个升序的地方
            flag --;
        }
//        如果整个序列都是降序，所有的都逆序
        if (flag < 0) swapAll(nums, 0, n-1);
        else {
//            正常情况：遇到了第一个升序的位置
            int l = flag + 1;
            int r = n - 1;
            while (l < r){
//                二分查找，先找到使得flag交换后后能够按照降序排列的位置
//                找到第一个比flag大的数
                int mid = l + r + 1 >> 1;
                if (nums[mid] > nums[flag]){
                    l = mid;
                }
                else r = mid -1;
            }
            swap(nums, flag, l);
            swapAll(nums, flag+1, n-1);
        }
    }

    public static void swapAll(int[] arr, int l, int r){
        while (l < r){
            swap(arr, l, r);
            l ++;
            r --;
        }
    }

    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
