public class Q108将有序数组转换为二叉搜索树 {
    public static void main(String[] args) {

    }
    //答案有三种写法，本质还是一样的，我这种对应答案的第一种
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBSTHelp(nums,0,nums.length-1);
    }

    public TreeNode sortedArrayToBSTHelp(int[] nums,int left,int right){
        if(left>right)
            return null;
        int middle=(right+left)/2;
        TreeNode node=new TreeNode(nums[middle]);
        node.left=sortedArrayToBSTHelp(nums,left,middle-1);
        node.right=sortedArrayToBSTHelp(nums,middle+1,right);
        return node;
    }
}
