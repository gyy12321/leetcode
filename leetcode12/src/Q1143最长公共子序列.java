public class Q1143最长公共子序列 {
    public int longestCommonSubsequence1(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        //这些是多余的，可写可不写，默认就是0
//        //dp[i][j]表示0~i-1的text1和0~j-1的text2的最长公共子序列长度
//        for (int i = 0; i <= len1; i++) {
//            //任意长度的text1和长度为0的text2的最长公共子序列长度为0
//            dp[i][0]=0;
//        }
//        for (int j = 0; j <= len2; j++) {
//            //任意长度的text2和长度为0的text1的最长公共子序列长度为0
//            dp[0][j]=0;
//        }
        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1))
                    dp[i][j]=dp[i-1][j-1]+1;
                else {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[len1][len2];
    }
}
class Solution1143_1{
    //效率稍微高一点点
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp=new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            char c1=text1.charAt(i-1);
            for (int j = 1; j <= n; j++) {
                char c2=text2.charAt(j-1);
                if(c1==c2)
                    dp[i][j]=dp[i-1][j-1]+1;
                else {
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        return dp[m][n];
    }
}
