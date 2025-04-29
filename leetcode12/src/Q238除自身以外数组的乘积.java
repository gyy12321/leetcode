public class Q238除自身以外数组的乘积 {
    public static void main(String[] args) {

    }
    //前缀与后缀相乘得到答案，总体比较简单，但可能难想到
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] pre=new int[n];
        int[] end=new int[n];
        int[] res=new int[n];
        int mul1=1;
        int mul2=1;
        for (int i = 0; i <= n-2; i++) {
            mul1*=nums[i];
            pre[i]=mul1;
        }
        for (int i = n-1; i >=1; i--) {
            mul2*=nums[i];
            end[i]=mul2;
        }
        res[0]=end[1];
        res[n-1]=pre[n-2];
        for (int i = 1; i < n-1; i++) {
            res[i]=pre[i-1]*end[i+1];
        }
        return res;
    }
    //更统一，更好一些
//    public int[] productExceptSelf(int[] nums) {
//        int length = nums.length;
//
//        // L 和 R 分别表示左右两侧的乘积列表
//        int[] L = new int[length];
//        int[] R = new int[length];
//
//        int[] answer = new int[length];
//
//        // L[i] 为索引 i 左侧所有元素的乘积
//        // 对于索引为 '0' 的元素，因为左侧没有元素，所以 L[0] = 1
//        L[0] = 1;
//        for (int i = 1; i < length; i++) {
//            L[i] = nums[i - 1] * L[i - 1];
//        }
//
//        // R[i] 为索引 i 右侧所有元素的乘积
//        // 对于索引为 'length-1' 的元素，因为右侧没有元素，所以 R[length-1] = 1
//        R[length - 1] = 1;
//        for (int i = length - 2; i >= 0; i--) {
//            R[i] = nums[i + 1] * R[i + 1];
//        }
//
//        // 对于索引 i，除 nums[i] 之外其余各元素的乘积就是左侧所有元素的乘积乘以右侧所有元素的乘积
//        for (int i = 0; i < length; i++) {
//            answer[i] = L[i] * R[i];
//        }
//
//        return answer;
//    }
//
//    作者：力扣官方题解
//    链接：https://leetcode.cn/problems/product-of-array-except-self/solutions/272369/chu-zi-shen-yi-wai-shu-zu-de-cheng-ji-by-leetcode-/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


    //最优解法，空间复杂度为1
    public int[] productExceptSelf1(int[] nums) {
        int n = nums.length;
        int[] res=new int[n];
        int mul=1;
        res[0]=1;
        //往右一次
        for (int i = 1; i < n; i++)
            res[i]=res[i-1]*nums[i-1];

        //往左一次
        for (int i = n-1; i >=0; i--){
            res[i]*=mul;
            mul*=nums[i];
        }
        return res;
    }

}
