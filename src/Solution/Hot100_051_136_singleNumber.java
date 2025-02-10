package Solution;

public class Hot100_051_136_singleNumber {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num: nums){
            res ^= num;
        }
        return res;
    }
}
