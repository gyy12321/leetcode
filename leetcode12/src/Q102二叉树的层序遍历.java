import java.util.*;

public class Q102二叉树的层序遍历 {
    public static void main(String[] args) {

    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        if(root==null)
            return res;
        int numbers=1;
        Deque<TreeNode> queue=new LinkedList<>();
        queue.addLast(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.removeFirst();
            list.add(node.val);
            numbers--;
            if(node.left!=null)
                queue.addLast(node.left);
            if(node.right!=null)
                queue.addLast(node.right);
            if(numbers==0){
                numbers=queue.size();
                res.add(list);
                list=new ArrayList<>();
            }
        }
        return res;
    }

    //答案解法思路基本相同，稍微有些不一样，更清爽好理解一些
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (root == null) {
            return ret;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
            int currentLevelSize = queue.size();
            for (int i = 1; i <= currentLevelSize; ++i) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ret.add(level);
        }

        return ret;
    }







}
