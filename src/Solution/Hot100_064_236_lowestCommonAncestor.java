package Solution;

public class Hot100_064_236_lowestCommonAncestor {

    private TreeNode ans;

//    public Solution(){
//        this.ans = null;
//    }
    public boolean dfs(TreeNode root, TreeNode p, TreeNode q){
//        判断当前节点的左右子树是否包含p节点和q节点。
        if (root == null) return false;
        boolean lson = dfs(root.left, p, q);
        boolean rson = dfs(root.right, p, q);
//        自底向下：当前节点的左右子树包含p、q节点；当前节点为p或q节点，左右子树包含另一个节点
        if (lson && rson){
            ans = root;
        }
        if ( (lson||rson) && (root.val == p.val || root.val == q.val) ){
            ans = root;
        }
//          return 当前节点及其子树是否包含p或者q
        return lson || rson || root.val == p.val || root.val == q.val;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return this.ans;
    }
}
