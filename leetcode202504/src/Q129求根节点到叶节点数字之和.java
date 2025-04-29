import java.util.LinkedList;
import java.util.Queue;

public class Q129求根节点到叶节点数字之和 {
    public static void main(String[] args) {

    }
    public int sumNumbers(TreeNode root) {
        if(root==null)
            return 0;
        return sumNumbersHelp(root,0);
    }
    //100
    public int sumNumbersHelp(TreeNode root,int val) {
        int cur=val*10+root.val;
        if (root.left==null&&root.right==null)
            return cur;
        else if(root.left!=null&&root.right!=null)
            return sumNumbersHelp(root.left,cur)+sumNumbersHelp(root.right,cur);
        else if(root.left!=null)
            return sumNumbersHelp(root.left,cur);
        else
            return sumNumbersHelp(root.right,cur);
    }
}
//100答案写法明显更简洁，和我的思想差不多
class Solution129_1 {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int prevSum) {
        if (root == null) {
            return 0;
        }
        int sum = prevSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        } else {
            return dfs(root.left, sum) + dfs(root.right, sum);
        }
    }
}
//广度100
class Solution129_2 {
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        Queue<Integer> numQueue = new LinkedList<Integer>();
        nodeQueue.offer(root);
        numQueue.offer(root.val);
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            int num = numQueue.poll();
            TreeNode left = node.left, right = node.right;
            if (left == null && right == null) {
                sum += num;
            } else {
                if (left != null) {
                    nodeQueue.offer(left);
                    numQueue.offer(num * 10 + left.val);
                }
                if (right != null) {
                    nodeQueue.offer(right);
                    numQueue.offer(num * 10 + right.val);
                }
            }
        }
        return sum;
    }
}


