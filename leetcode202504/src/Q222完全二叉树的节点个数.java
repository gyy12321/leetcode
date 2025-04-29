import java.util.Deque;
import java.util.LinkedList;

public class Q222完全二叉树的节点个数 {
    public static void main(String[] args) {

    }
    //6.57
    public int countNodes(TreeNode root) {
        if(root==null)
            return 0;
        Deque<TreeNode> deque=new LinkedList<>();
        int num=0;
        deque.offer(root);
        while (deque.size()!=0){
            TreeNode poll = deque.poll();
            num++;
            if(poll.left!=null)
                deque.offer(poll.left);
            if(poll.right!=null)
                deque.offer(poll.right);
        }
        return num;
    }
}
//100
class Solution222_1 {
    public int countNodes(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = countNodes(root.left);
        int right = countNodes(root.right);

        return left+right+1;

    }
}

//二分查找，位运算，官方解法100，之后在学习
class Solution222_2 {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int level = 0;
        TreeNode node = root;
        while (node.left != null) {
            level++;
            node = node.left;
        }
        int low = 1 << level, high = (1 << (level + 1)) - 1;
        while (low < high) {
            int mid = (high - low + 1) / 2 + low;
            if (exists(root, level, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public boolean exists(TreeNode root, int level, int k) {
        int bits = 1 << (level - 1);
        TreeNode node = root;
        while (node != null && bits > 0) {
            if ((bits & k) == 0) {
                node = node.left;
            } else {
                node = node.right;
            }
            bits >>= 1;
        }
        return node != null;
    }
}

