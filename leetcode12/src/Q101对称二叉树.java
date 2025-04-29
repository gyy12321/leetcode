import java.util.LinkedList;
import java.util.Queue;

public class Q101对称二叉树 {
    public static void main(String[] args) {

    }
    //题目看错了
//    public boolean isSymmetric(TreeNode root) {
//        if(root.left==null&&root.right==null)
//            return true;
//        if(root.left!=null&&root.right!=null&&root.left.val==root.right.val)
//            return isSymmetric(root.left)&&isSymmetric(root.right);
//        return false;
//    }

    public boolean isSymmetric(TreeNode root) {
        return like(root.left,root.right);
    }
    public boolean like(TreeNode left,TreeNode right){
        if(left==null&&right==null)
            return true;
        if(left!=null&&right!=null&&left.val==right.val){
            return like(left.left,right.right)&&like(left.right,right.left);
        }
        return false;
    }

//    public boolean isSymmetric(TreeNode root) {
//        return check(root.left, root.right);
//    }
//
//    //递归答案跟我的很相似，但稍微更好一些
//    public boolean check(TreeNode p, TreeNode q) {
//        if (p == null && q == null) {
//            return true;
//        }
//        if (p == null || q == null) {
//            return false;
//        }
//        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
//    }


    //非递归写法，把答案稍微做了优化，从原来两次比较变为一次
//    public boolean isSymmetric(TreeNode root) {
//        return check(root.left, root.right);
//    }
//
//    public boolean check(TreeNode u, TreeNode v) {
//        Queue<TreeNode> q = new LinkedList<TreeNode>();
//        q.offer(u);
//        q.offer(v);
//        while (!q.isEmpty()) {
//            u = q.poll();
//            v = q.poll();
//            if (u == null && v == null) {
//                continue;
//            }
//            if ((u == null || v == null) || (u.val != v.val)) {
//                return false;
//            }
//
//            q.offer(u.left);
//            q.offer(v.right);
//
//            q.offer(u.right);
//            q.offer(v.left);
//        }
//        return true;
//    }

}
