package src.TreeNode;

public class TreeNodeOrder {

    /**
     * 初始化二叉树
     *      1
     *  2       3
     */
    public static TreeNode root;
    static {
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
    }

    public static void main(String[] args) {
        function(root);
    }

    /**
     * 前序遍历
     * @param root
     */
    public static void function(TreeNode root){
        if(root.left==null && root.right==null){
            System.out.print(root.val+" ");
            return;
        }
        function(root.left);
        System.out.print(root.val+" ");
        function(root.right);
    }
}
