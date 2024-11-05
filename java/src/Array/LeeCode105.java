package src.Array;

import src.TreeNode.TreeNode;

/**
 * 根据前序遍历和中序遍历的结果构造二叉树
 * 1 2 3 pre
 * 2 1 3 in
 * 前序遍历的第一个结果是根节点
 * 递归：找到根节点之后，依次构造左右子树即可
 */
public class LeeCode105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length- 1, inorder, 0, inorder.length - 1);
    }
    private TreeNode buildTree(int[] preorder, int preLeft, int preRight,
                               int[] inorder, int inLeft, int inRight) {
        // 先写出来递归的终止条件
        if (preLeft > preRight || inLeft > inRight) return null;
        // 找到属于当前子树的根节点
        int rootVal = preorder[preLeft];
        TreeNode root = new TreeNode(rootVal);
        // 在中序遍历结果中找到下标
        int pivot = 0;
        while(inorder[pivot] != rootVal) pivot++;
        // 分别构造左右子树，难点，构建左子树的时候，需要找到左子树的前序遍历结果范围，在这个范围中构建
        root.left = buildTree(preorder,preLeft + 1,pivot - inLeft + preLeft,
                inorder,inLeft,pivot-1);
        root.right = buildTree(preorder,pivot - inLeft + preLeft + 1,preRight,
                inorder,pivot+1,inRight);
        return root;
    }
}
