import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q236二叉树的最近公共祖先 {
    public static void main(String[] args) {

    }
    //效率高，但稍微难以理解
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }

    //方法二用map存储父节点，效率较低
//    Map<Integer, TreeNode> parent = new HashMap<Integer, TreeNode>();
//    Set<Integer> visited = new HashSet<Integer>();
//
//    public void dfs(TreeNode root) {
//        if(root.left!=null){
//            parent.put(root.left.val,root);
//            dfs(root.left);
//        }
//        if(root.right!=null){
//            parent.put(root.right.val,root);
//            dfs(root.right);
//        }
//    }
//
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        dfs(root);
//        while (p!=null){
//            visited.add(p.val);
//            p=parent.get(p.val);
//        }
//        while (true){
//            if(visited.contains(q.val))
//                return q;
//            q=parent.get(q.val);
//        }
//    }
//

}
