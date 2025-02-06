package Solution;

public class Hot100_025_055_canJump {
    public boolean canJump(int[] nums) {
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            if (end < i) return false;
            end = Math.max(i+nums[i], end);
        }
        return true;
    }
}
