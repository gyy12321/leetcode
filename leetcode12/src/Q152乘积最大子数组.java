public class Q152乘积最大子数组 {
    public static void main(String[] args) {

    }
    //暴力法
//    public int maxProduct(int[] nums) {
//        int max=Integer.MIN_VALUE;
//        for (int i = 0; i < nums.length; i++) {
//            int temp=1;
//            for(int j=i;j<nums.length;j++){
//                temp*=nums[j];
//                max=Math.max(max,temp);
//            }
//        }
//        return max;
//    }
    //cur_min[i]表示以第 i 个元素结尾的乘积最小子数组的乘积
    public int maxProduct(int[] nums){
        int n = nums.length;
        int[] cur_max=new int[n];
        int[] cur_min=new int[n];
        cur_max[0]=nums[0];
        cur_min[0]=nums[0];
        int res=cur_max[0];
        for (int i = 1; i < n; i++) {
            //三者里的最大值
            cur_max[i]=Math.max(Math.max(cur_min[i-1]*nums[i],nums[i]),cur_max[i-1]*nums[i]);
            //三者的最小值
            cur_min[i]=Math.min(Math.min(cur_max[i-1]*nums[i],nums[i]),cur_min[i-1]*nums[i]);
            //更新结果
            res=Math.max(res,cur_max[i]);
        }
        return res;
        //int的范围是-2147483648到2147483647
        //long的范围是-9223372036854775808到9223372036854775807
    }
}
