package Solution;

import java.util.HashMap;
import java.util.Map;

public class Hot100_043_105_buildTree {
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return dfs(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
    }

    public TreeNode dfs(int[] preorder, int[] inorder, int pl, int pr, int il, int ir){
        if (pl > pr || il > ir) return null;
        int rootVal = preorder[pl];
        TreeNode root = new TreeNode(rootVal);
        int mid = map.get(rootVal);
        int num = mid - il;
        root.left = dfs(preorder, inorder, pl+1, pl+num, il, mid-1);
        root.right = dfs(preorder, inorder, pl+1+num, pr, mid+1, ir);
        return root;
    }
}
