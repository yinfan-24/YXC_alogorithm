package Solution;

import java.util.Arrays;

public class Hot100_084_287_findDuplicate {
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
//        先让快慢指针相遇
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
//        再重置，然后同时出发
        slow = 0;
        while (slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
