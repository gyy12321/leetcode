import java.util.LinkedList;
import java.util.Queue;

public class Q112路径总和 {
    public static void main(String[] args) {

    }
    //100
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null)
            return false;
        int remainVal = targetSum-root.val;

        //保证是从根到底部，而不是中途结束
        if(remainVal==0&&root.left==null&&root.right==null)
            return true;
        return hasPathSum(root.left,remainVal)||hasPathSum(root.right,remainVal);

    }
}
//100
class Solution112_2 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
//效率8
class Solution112_1 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queNode = new LinkedList<TreeNode>();
        Queue<Integer> queVal = new LinkedList<Integer>();
        queNode.offer(root);
        queVal.offer(root.val);
        while (!queNode.isEmpty()) {
            TreeNode now = queNode.poll();
            int temp = queVal.poll();
            if (now.left == null && now.right == null) {
                if (temp == sum) {
                    return true;
                }
                continue;
            }
            if (now.left != null) {
                queNode.offer(now.left);
                queVal.offer(now.left.val + temp);
            }
            if (now.right != null) {
                queNode.offer(now.right);
                queVal.offer(now.right.val + temp);
            }
        }
        return false;
    }
}

