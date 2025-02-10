package Solution;

import java.util.HashMap;
import java.util.Map;

public class Hot100_043_105_buildTree {
    static HashMap<Integer, Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return dfs(preorder, 0, preorder.length-1, 0, inorder.length);
    }

    static TreeNode dfs(int[] preorder, int pl, int pr, int il, int ir){
        if (pl > pr || il > ir) return null;
        TreeNode root = new TreeNode(preorder[pl]);
        int mid = map.get(root.val);
        int l_len = mid - il;
        root.left = dfs(preorder, pl+1, pl+l_len, il, mid-1);
        root.right = dfs(preorder, pl+l_len+1, pr, mid+1, ir);
        return root;
    }

}
