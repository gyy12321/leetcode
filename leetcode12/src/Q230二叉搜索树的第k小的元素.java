import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Q230二叉搜索树的第k小的元素 {
    public static void main(String[] args) {

    }
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack=new LinkedList<>();
        while (!stack.isEmpty() || root!=null){
            while (root!=null){
                stack.push(root);
                root=root.left;
            }
            root=stack.pop();
            k--;
            if(k==0)
                break;
            root=root.right;
        }
        return root.val;
    }

    //方法二来自官方答案，是经典做法，但是太麻烦，效率也不高
//    class Solution {
//        public int kthSmallest(TreeNode root, int k) {
//            MyBst bst = new MyBst(root);
//            return bst.kthSmallest(k);
//        }
//    }
//
//    class MyBst {
//        TreeNode root;
//        Map<TreeNode, Integer> nodeNum;
//
//        public MyBst(TreeNode root) {
//            this.root = root;
//            this.nodeNum = new HashMap<TreeNode, Integer>();
//            countNodeNum(root);
//        }
//
//        // 返回二叉搜索树中第k小的元素
//        public int kthSmallest(int k) {
//            TreeNode node = root;
//            while (node != null) {
//                int left = getNodeNum(node.left);
//                if (left < k - 1) {
//                    node = node.right;
//                    k -= left + 1;
//                } else if (left == k - 1) {
//                    break;
//                } else {
//                    node = node.left;
//                }
//            }
//            return node.val;
//        }
//
//        // 统计以node为根结点的子树的结点数
//        private int countNodeNum(TreeNode node) {
//            if (node == null) {
//                return 0;
//            }
//            nodeNum.put(node, 1 + countNodeNum(node.left) + countNodeNum(node.right));
//            return nodeNum.get(node);
//        }
//
//        // 获取以node为根结点的子树的结点数
//        private int getNodeNum(TreeNode node) {
//            return nodeNum.getOrDefault(node, 0);
//        }
//    }


}
