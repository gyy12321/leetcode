import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class S二叉树遍历 {
    public static void main(String[] args) {
        TreeNode node1=new TreeNode(1);
        TreeNode node2=new TreeNode(2);
        TreeNode node3=new TreeNode(3);
        TreeNode node4=new TreeNode(4);
        TreeNode node5=new TreeNode(5);
        TreeNode node6=new TreeNode(6);
        node1.left=node2;
        node1.right=node3;
        node2.left=node4;
        node2.right=node5;
        node3.right=node6;
        List<Integer> list1 = inorderTraversal(node1);
        list1.forEach(System.out::println);
        System.out.println("----------------------------");
        List<Integer> list2 = preorderTraversal(node1);
        list2.forEach(System.out::println);


    }
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        TreeNode cur=root;
        Deque<TreeNode> stack=new LinkedList<>();
        while (cur!=null || !stack.isEmpty()){
            while (cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            cur=stack.pop();
            list.add(cur.val);
            cur=cur.right;
        }
        return list;
    }
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        TreeNode cur=root;
        Deque<TreeNode> stack=new LinkedList<>();
        while (cur!=null || !stack.isEmpty()){
            while (cur!=null){
                stack.push(cur);
                list.add(cur.val);
                cur=cur.left;
            }
            cur=stack.pop();
            cur=cur.right;
        }
        return list;
    }
}
