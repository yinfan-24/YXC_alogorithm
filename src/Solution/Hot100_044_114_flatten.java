package Solution;

import java.util.ArrayList;
import java.util.List;

public class Hot100_044_114_flatten {

    public void flatten(TreeNode root) {
        while (root != null){
            TreeNode cur = root.left;
            if (cur != null){
                while (cur.right != null){
                    cur = cur.right;
                }
                cur.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            root = root.right;
        }
    }


}
