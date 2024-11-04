package Solution;

import com.sun.org.apache.xpath.internal.operations.Neg;

public class Hot100_038_096_numTrees {
//    1~N 的序列，以 i 为根节点所能构建的二叉搜索树的个数为：G(i) = G(i-1) * G(n-i)
    public int numTrees(int n) {
        int[] G = new int[n+10];
        G[0] = 1;
        G[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                G[i] += G[j-1] * G[i-j];
            }
        }
        return G[n];
    }
}
