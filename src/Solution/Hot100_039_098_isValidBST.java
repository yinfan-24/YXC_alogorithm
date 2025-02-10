package Solution;

import java.util.*;

public class Hot100_039_098_isValidBST {
    public boolean isValidBST(TreeNode root) {
        return searchBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean searchBST(TreeNode root, long min, long max){
        if (root == null) return true;
        if (root.val <= min || root.val >= max ) return false;
        return searchBST(root.left, min, root.val) && searchBST(root.right, root.val, max);
    }


}
