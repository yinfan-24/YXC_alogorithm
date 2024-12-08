package Solution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Hot100_083_337_rob {


    public int rob(TreeNode root) {
        int[] res = robInternal(root);
        return Math.max(res[0], res[1]);
    }

    public int[] robInternal(TreeNode root){
        if (root == null) return new int[2];
        int[] res = new int[2];

        int[] left = robInternal(root.left);
        int[] right = robInternal(root.right);

        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = left[0] + right[0] + root.val;

        return res;
    }
}
