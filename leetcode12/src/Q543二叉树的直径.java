import java.util.HashMap;
import java.util.Map;

public class Q543二叉树的直径 {
    public static void main(String[] args) {

    }
    //自己写的效率有些低
//    public int diameterOfBinaryTree(TreeNode root) {
//        if(root==null)
//            return 0;
//        int leftMax=diameterOfBinaryTree(root.left);
//        int rightMax=diameterOfBinaryTree(root.right);
//        int middleMax=height(root.left)+height(root.right);
//        return Math.max(Math.max(leftMax,rightMax),middleMax);
//    }
//    public int height(TreeNode root){
//        if(root==null)
//            return 0;
//        else
//            return Math.max(height(root.right),height(root.left))+1;
//    }



    //虽然经过优化，速度快了很多，但击败的人还是很少，还是一个垃圾方法
//    Map<TreeNode,Integer> map;
//    public int diameterOfBinaryTree(TreeNode root) {
//        map=new HashMap<>();
//        height(root);
//        return diameterOfBinaryTreeHelp(root);
//    }
//    public int diameterOfBinaryTreeHelp(TreeNode root) {
//        if(root==null)
//            return 0;
//        int leftMax=diameterOfBinaryTreeHelp(root.left);
//        int rightMax=diameterOfBinaryTreeHelp(root.right);
//        int middleMax=map.getOrDefault(root.left,0)+
//                map.getOrDefault(root.right,0);
//        return Math.max(Math.max(leftMax,rightMax),middleMax);
//    }
//    public int height(TreeNode root){
//        if(root==null)
//            return 0;
//        else{
//            int a=height(root.left);
//            int b=height(root.right);
//            int height=Math.max(a,b)+1;
//            map.put(root,height);
//            return height;
//        }
//    }


    //官方答案写法，-1+1这儿可以稍作修改，都无妨，理解就行
    int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        depth(root);
        return ans-1 ;
    }
    public int depth(TreeNode node) {
        if (node == null) {
            return 0; // 访问到空节点了，返回0
        }
        int L = depth(node.left); // 左儿子为根的子树的深度
        int R = depth(node.right); // 右儿子为根的子树的深度
        ans = Math.max(ans, L+R+1); // 计算d_node即L+R+1 并更新ans
        return Math.max(L, R) + 1; // 返回该节点为根的子树的深度
    }
}
