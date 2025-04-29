import java.util.ArrayList;
import java.util.List;

public class Q114二叉树展开为链表 {
    public static void main(String[] args) {

    }
    //类似答案的方法一
    //先自己做了一遍，然后在答案基础上稍作修改，达到100%
    // PS也可以迭代方式实现
    public void flatten(TreeNode root) {
        List<TreeNode> list=new ArrayList<>();
        preOrder(root,list);
        for(int i=1;i<list.size();++i){
            list.get(i-1).left=null;
            list.get(i-1).right=list.get(i);
        }
    }

    public void preOrder(TreeNode root, List<TreeNode> list){
        if(root!=null){
            list.add(root);
            preOrder(root.left,list);
            preOrder(root.right,list);
        }
    }
    //


    //答案的方法三真的是一个神奇的做法
    public void flatten1(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode next = curr.left;
                TreeNode predecessor = next;
                while (predecessor.right != null) {
                    predecessor = predecessor.right;
                }
                predecessor.right = curr.right;
                curr.left = null;
                curr.right = next;
            }
            curr = curr.right;
        }
    }
    //答案的方法二暂时没看懂，先不管了


}
