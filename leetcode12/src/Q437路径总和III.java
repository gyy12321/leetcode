public class Q437路径总和III {
    public static void main(String[] args) {

    }

    public int pathSum(TreeNode root, int targetSum) {
        if(root==null)
            return 0;
        int res=rootSum(root,targetSum);
        res+=pathSum(root.left,targetSum);
        res+=pathSum(root.right,targetSum);
        return res;
    }

    public int rootSum(TreeNode root,int targetSum){
        if (root==null)
            return 0;
        int res=0;
        int val=root.val;
        if(val==targetSum)
            res++;
        res+=rootSum(root.left,targetSum-val);
        res+=rootSum(root.right,targetSum-val);
        return res;
    }

//    第二种前缀和解法还不太会需要再掌握
    //
    //
    //
    //
}
