package Solution;

import java.util.ArrayList;
import java.util.List;

public class Hot100_061_336_countBits {
    public int[] countBits(int n) {
        int[] res = new int[n+1];
        for (int i = 0; i <= n; i++) {
            res[i] = countOne(i);
        }
        return res;
    }

    public int countOne(int num){
        int cnt = 0;
        while (num != 0){
            num &= num-1;
            cnt ++;
        }
        return cnt;
    }
}
