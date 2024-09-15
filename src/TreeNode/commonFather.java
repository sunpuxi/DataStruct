package src.TreeNode;

/**
 * 两个二叉树节点的公共祖先
 */
public class commonFather {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 特殊情况
        if(root == null || root == p || root == q) return root;
        // 依次递归左边和右边
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 如果左右两边都有返回当前节点即可
        if (left!=null && right!=null) return root;
        // 如果只有一边
        if (left!=null) return left;
        else return right;
    }
    // 二叉搜索树中的情况
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        int val = root.val;
        if(p.val < val && q.val < val) return lowestCommonAncestor(root.left,p,q);
        if(p.val > val && q.val > val) return lowestCommonAncestor(root.right,p,q);
        return root;
    }

}
