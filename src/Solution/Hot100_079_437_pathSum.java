package Solution;

public class Hot100_079_437_pathSum {
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;

        int ret = rootSum(root, targetSum);
        ret += pathSum(root.left, targetSum);
        ret += pathSum(root.right, targetSum);
        return ret;
    }

    public int rootSum(TreeNode root, long targetSum){
        if (root == null) return 0;

        int ret = 0;
        int val = root.val;
        if (val == targetSum) ret++;
        ret += rootSum(root.left, targetSum - val);
        ret += rootSum(root.right, targetSum - val);
        return ret;
    }
}
