package Solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Hot100_039_098_isValidBST {
    public boolean isValidBST(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()){
            if (cur != null){
                stack.push(cur);
                cur = cur.left;
            }else {
                TreeNode top = stack.pop();
                if (!res.isEmpty() && top.val < res.get(res.size()-1)){
                    return false;
                }
                res.add(top.val);
                cur = top.right;
            }
        }

        return true;
    }
}
