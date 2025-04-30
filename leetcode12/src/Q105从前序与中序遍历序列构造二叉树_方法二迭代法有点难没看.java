import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q105从前序与中序遍历序列构造二叉树_方法二迭代法有点难没看 {
    public static void main(String[] args) {
        int[] a=new int[]{4,1,3,5,8};
        int[] ints = Arrays.copyOfRange(a, 0, 0);
        System.out.println(ints.length);
    }
//    Map<Integer,Integer> map;
//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        map=new HashMap<>();
//        for (int i = 0; i < inorder.length; i++) {
//            map.put(inorder[i],i);
//        }
//        TreeNode root = buildTreeHelp(preorder, inorder);
//        return root;
//    }
//    public TreeNode buildTreeHelp(int[] preorder, int[] inorder) {
//        if(preorder.length==0||inorder.length==0)
//            return null;
//        int first = preorder[0];
//        TreeNode node=new TreeNode(first);
//        int index=-1;
//        for(int i=0;i<inorder.length;++i){
//            if (first==inorder[i])
//                index=i;
//        }
//        int[] leftPreorder=Arrays.copyOfRange(preorder,1,1+index);
//        int[] rightPreorder=Arrays.copyOfRange(preorder,1+index,preorder.length);
//        int[] leftInorder = Arrays.copyOfRange(inorder, 0, index);
//        int[] rightInorder = Arrays.copyOfRange(inorder, index+1, inorder.length);
//        node.left=buildTreeHelp(leftPreorder,leftInorder);
//        node.right=buildTreeHelp(rightPreorder,rightInorder);
//        return node;
//    }

    //终于对了，参考答案解法1，基本差不多
    Map<Integer,Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map=new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        TreeNode root = buildTreeHelp(preorder, inorder,0,preorder.length-1,0,inorder.length-1);
        return root;
    }

    public TreeNode buildTreeHelp(int[] preorder, int[] inorder,int preLeft,int preRight,int inLeft,int inRight) {
        if(preLeft>preRight)
            return null;
        int first = preorder[preLeft];
        TreeNode node=new TreeNode(first);
        int index=map.get(first);
        //index左边有几个
        int left=index-inLeft;
        node.left=buildTreeHelp(preorder,inorder,preLeft+1,preLeft+left,inLeft,index-1);
        node.right=buildTreeHelp(preorder,inorder,preLeft+left+1,preRight,index+1,inRight);
        return node;
    }
    //方法二迭代法还没看
    //方法二迭代法还没看
    //方法二迭代法还没看
    //方法二迭代法还没看
    //方法二迭代法还没看
}

//由106题后序中序遍历的写法改造而来，也是可以的
class Solution105_1 {
    int pre_idx;
    int[] preorder;
    int[] inorder;
    Map<Integer, Integer> idx_map = new HashMap<Integer, Integer>();

    public TreeNode helper(int in_left, int in_right) {
        // 如果这里没有节点构造二叉树了，就结束
        if (in_left > in_right) {
            return null;
        }

        // 选择 post_idx 位置的元素作为当前子树根节点
        int root_val = preorder[pre_idx];
        TreeNode root = new TreeNode(root_val);

        // 根据 root 所在位置分成左右两棵子树
        int index = idx_map.get(root_val);

        // 下标加1
        pre_idx++;

        // 构造左子树
        root.left = helper(in_left, index - 1);

        // 构造右子树
        root.right = helper(index + 1, in_right);
        return root;
    }

    public TreeNode buildTree(int[] pretorder,int[] inorder) {
        this.preorder = pretorder;
        this.inorder = inorder;
        // 从后序遍历的最后一个元素开始
        pre_idx = 0;

        // 建立（元素，下标）键值对的哈希表
        int idx = 0;
        for (Integer val : inorder) {
            idx_map.put(val, idx++);
        }

        return helper(0, inorder.length - 1);
    }
}

