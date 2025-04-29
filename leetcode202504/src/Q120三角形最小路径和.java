import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Q120三角形最小路径和 {
    public static void main(String[] args) {

    }
    //自己写的修改后时间从击败80多到击败90多，和答案已经类似
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        //不需要讨论
//        if(size==1)
//            return triangle.get(0).get(0);
        int[] dp=new int[size];
        //这一步也不需要，注意
//        for (int i = 0; i < size; i++) {
//            Arrays.fill(dp,Integer.MAX_VALUE);
//        }
        //00
        //10,11
        //20,21,22
        //30,31,32,33
        dp[0]=triangle.get(0).get(0);
        //画草图模拟一下，主要问题是防止O(n)时间复杂度，先后顺序导致的覆盖问题导致的错误。O(n2)没有这个问题
        for(int i=1;i<=size-1;++i){
            //先更新最后边
            dp[i]=dp[i-1]+triangle.get(i).get(i);
            //从右往左更新除第0个以及最后一个之外的其他元素
            for(int j=i-1;j>=1;--j)
                dp[j]= Math.min(dp[j-1],dp[j])+triangle.get(i).get(j);
            //更新第0个元素
            dp[0]+=triangle.get(i).get(0);
        }
        int res=dp[0];
        for (int i : dp)
            res=Math.min(res,i);
        return res;
    }
}

//二维
class Solution120_1 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] f = new int[n][n];
        f[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; ++i) {
            f[i][0] = f[i - 1][0] + triangle.get(i).get(0);
            for (int j = 1; j < i; ++j) {
                f[i][j] = Math.min(f[i - 1][j - 1], f[i - 1][j]) + triangle.get(i).get(j);
            }
            f[i][i] = f[i - 1][i - 1] + triangle.get(i).get(i);
        }
        int minTotal = f[n - 1][0];
        for (int i = 1; i < n; ++i) {
            minTotal = Math.min(minTotal, f[n - 1][i]);
        }
        return minTotal;
    }
}

//1维度空间优化
class Solution120_2 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] f = new int[2][n];
        f[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; ++i) {
            int curr = i % 2;
            int prev = 1 - curr;
            f[curr][0] = f[prev][0] + triangle.get(i).get(0);
            for (int j = 1; j < i; ++j) {
                f[curr][j] = Math.min(f[prev][j - 1], f[prev][j]) + triangle.get(i).get(j);
            }
            f[curr][i] = f[prev][i - 1] + triangle.get(i).get(i);
        }
        int minTotal = f[(n - 1) % 2][0];
        for (int i = 1; i < n; ++i) {
            minTotal = Math.min(minTotal, f[(n - 1) % 2][i]);
        }
        return minTotal;
    }
}

