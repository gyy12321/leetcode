public class Q104二叉树的最大深度_广度优先方法之后再看 {
    public static void main(String[] args) {

    }
    //广度优先方法之后再看
    public int maxDepth(TreeNode root) {
        if(root==null)
            return 0;
        else {
            return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
        }
    }
}
