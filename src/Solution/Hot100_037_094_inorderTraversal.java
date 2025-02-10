package Solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Hot100_037_094_inorderTraversal {
//    中序遍历的思想：先不断入栈，然后指向当前指针的左孩子
//                    入栈顺序：中心，左孩

    static List<Integer> res;
    public List<Integer> inorderTraversal(TreeNode root) {
        res = new LinkedList<>();
        inorderTree(root);
        return res;
    }

    private static void inorderTree(TreeNode root){
        if (root == null){
            return;
        }
        inorderTree(root.left);
        res.add(root.val);
        inorderTree(root.right);
    }
}
