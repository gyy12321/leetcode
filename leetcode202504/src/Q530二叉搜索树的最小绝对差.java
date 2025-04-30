import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Q530二叉搜索树的最小绝对差 {
    public static void main(String[] args) {

    }

    //38
    public int getMinimumDifference(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        int min = 100000;
        int cur = -100001;
        while (!deque.isEmpty() || root != null) {
            while (root != null) {
                deque.push(root);
                root = root.left;
            }
            root = deque.pop();
            min = Math.min(min, root.val-cur);
            cur = root.val;
            root = root.right;
        }
        return min;
    }
    public int getMinimumDifference1(TreeNode root) {
        Deque<TreeNode> deque=new LinkedList<>();
        int min=100000;
        List<Integer> list=new ArrayList<>();
        while (!deque.isEmpty()||root!=null){
            while (root!=null){
                deque.push(root);
                root=root.left;
            }
            root=deque.pop();
           list.add(root.val);
            root=root.right;
        }
        for (int i = 0; i < list.size()-1; i++) {
            min=Math.min(min,list.get(i+1)-list.get(i));
        }
        return min;
    }
}

//递归形式的中序遍历，100
class Solution530_1 {
    int pre;
    int ans;

    public int getMinimumDifference(TreeNode root) {
        ans = Integer.MAX_VALUE;
        pre = -1;
        dfs(root);
        return ans;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (pre == -1) {
            pre = root.val;
        } else {
            ans = Math.min(ans, root.val - pre);
            pre = root.val;
        }
        dfs(root.right);
    }
}

