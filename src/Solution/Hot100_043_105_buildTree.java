package Solution;

import java.util.HashMap;
import java.util.Map;

public class Hot100_043_105_buildTree {
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

    }

    public TreeNode dfs(int[] preorder, int[] inorder, int pl, int pr, int il, int ir){
        if (pl > pr || il > ir) return null;
        int rootVal = preorder[pl];
    }
}
