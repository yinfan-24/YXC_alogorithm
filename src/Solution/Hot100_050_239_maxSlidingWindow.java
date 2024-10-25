package Solution;

public class Hot100_050_239_maxSlidingWindow {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n-k+1];
        int idx = 0;

//        q是一个优先队列，存储的是下标
        int[] q = new int[n+1];
//        q[hh]存储最大值的下标，q[tt]存储最小值的下标
        int hh = 0, tt = -1;

        for (int i = 0; i < n; i++) {
            while (hh <= tt && q[hh] < i-k+1){
//                如果hh小于tt，且hh对应的下标即将超过限制
                hh++;
            }
            while (hh <= tt && nums[i] > nums[q[tt]]){
//                如果即将加入的元素比队尾的要大，那就弹出tt
                tt--;
            }
            q[++tt] = i;
            if (i >= k-1) res[idx++] = nums[q[hh]];
        }

        return res;
    }
}
