public class Q226翻转二叉树 {
    public static void main(String[] args) {

    }
    public TreeNode invertTree(TreeNode root) {
        if(root==null)
            return null;
        TreeNode node1=invertTree(root.right);
        TreeNode node2=invertTree(root.left);
        root.left=node1;
        root.right=node2;
        return root;
    }
}
