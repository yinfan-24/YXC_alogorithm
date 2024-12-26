package Solution;

import java.util.Arrays;

public class Hot100_093_312_maxCoins {
    int[][] store;
    int[] arr;
    public int maxCoins(int[] nums) {
        arr = new int[nums.length + 2];
        System.arraycopy(nums, 0, arr, 1, nums.length);
        arr[0] = arr[nums.length + 1] = 1;

        store = new int[arr.length][arr.length];

        for (int n = 2; n < arr.length; n++) {
            for (int i = 0; i < arr.length - n; i++) {
                range_coin(i, i + n);
            }
        }

        return store[0][arr.length-1];
    }

    public void range_coin(int i, int j){
        int tmp_max = 0;
        for (int k = i+1; k < j; k++) {
            tmp_max = Math.max(tmp_max, store[i][k] + store[k][j] + arr[i]*arr[j]*arr[k]);
        }
        store[i][j] = tmp_max;
    }


}
