import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Q94二叉树的中序遍历 {
    public static void main(String[] args) {


    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        if(root==null)
            return list;
        else {
            List<Integer> list1=inorderTraversal(root.left);
            List<Integer> list2=inorderTraversal(root.right);
            for (Integer integer : list1) {
                list.add(integer);
            }
            list.add(root.val);
            for (Integer integer : list2) {
                list.add(integer);
            }
            return list;
        }
    }

    //另一种递归写法
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        inorder(root,list);
        return list;
    }

    public void inorder(TreeNode node,List<Integer> list){
        if(node!=null){
            inorder(node.left,list);
            list.add(node.val);
            inorder(node.right,list);
        }
    }

    //中序遍历，非递归写法，重点掌握,恶心死了,实在不行就死记硬背吧
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        TreeNode cur=root;
        Deque<TreeNode> stack=new LinkedList<>();
        while (cur!=null || !stack.isEmpty()){
            while (cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            cur=stack.peek();
            stack.pop();
            list.add(cur.val);
            cur=cur.right;
        }
        return list;
    }

}


class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

