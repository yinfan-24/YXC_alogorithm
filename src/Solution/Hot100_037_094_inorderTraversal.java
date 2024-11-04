package Solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Hot100_037_094_inorderTraversal {
//    中序遍历的思想：先不断入栈，然后指向当前指针的左孩子
//                    入栈顺序：中心，左孩
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    public void inorder(TreeNode root, List<Integer> res){
        if (root == null) return;

        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }
}
