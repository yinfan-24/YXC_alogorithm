package Solution;

public class Hot100_091_538_convertBST {
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root != null){
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }


}
