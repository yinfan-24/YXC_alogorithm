package Solution;

public class Hot100_025_055_canJump {
    public boolean canJump(int[] nums) {
        int end = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (end < i) return false;
            end = Math.max(end, i + nums[i]);
        }
        return true;
    }
}
