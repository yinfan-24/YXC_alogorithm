package Solution;

import java.util.ArrayList;
import java.util.List;

public class Hot100_061_336_countBits {
    public int[] countBits(int n) {
        int[] res = new int[n+1];
        for (int i = 0; i <= n; i++) {
            res[i] = Integer.bitCount(i);
        }
        return res;
    }
}
