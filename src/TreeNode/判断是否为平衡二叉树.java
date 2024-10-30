package src.TreeNode;

public class 判断是否为平衡二叉树 {
    public boolean isBalanced(TreeNode root) {
        return getLength(root) != -1;
    }

    public int getLength(TreeNode root){
        // 终止条件
        if(root == null) return 0;
        int left = getLength(root.left);
        if (left == -1) return -1;  // 只要发现一颗子树不是平衡的，那么直接返回即可。
        int right = getLength(root.right);
        if (Math.abs(right - left) > 1 || right == -1) return -1;
        return Math.max(right,left) + 1;
    }
}
