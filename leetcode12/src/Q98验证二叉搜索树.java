import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Q98验证二叉搜索树 {
    public static void main(String[] args) {

    }
    //写法一
    public boolean isValidBST(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        inorder(root,list);
        int x=list.get(0);
        for(int i=1;i<list.size();i++){
            if(x>=list.get(i))
                return false;
            x=list.get(i);
        }
        return true;
    }
    public void inorder(TreeNode node, List<Integer> list){
        if(node!=null){
            inorder(node.left,list);
            list.add(node.val);
            inorder(node.right,list);
        }
    }

    //飞递归写法，写法二
    public boolean isValidBST1(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        //非常重要，MINVALUE是0
        double value=-Double.MAX_VALUE;

        while (!stack.isEmpty() || root!=null){
            while (root!=null){
                stack.push(root);
                root=root.left;
            }
            root = stack.pop();
            if(root.val<=value)
                return false;
            value=root.val;
            root=root.right;
        }
        return true;
    }
    //最优写法，递归写法，来自官方，写法三
    public boolean isValidBST2(TreeNode root) {
        return isValidBST2Help(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST2Help(TreeNode node, long lower, long upper) {
        if(node==null)
            return true;
        else if (node.val<=lower||node.val>=upper)
            return false;
        else {
            return isValidBST2Help(node.left,lower,node.val)&&
                    isValidBST2Help(node.right,node.val,upper);
        }
    }


}
