public class Q516最长回文子序列 {
    public static void main(String[] args) {
        System.out.println(longestPalindromeSubseq("abcdf"));
    }

    //转移方程不是很好得到
    public static int longestPalindromeSubseq(String s) {
        int length = s.length();
        int[][] PalindromeLength=new int[length][length];
        char[] charArray = s.toCharArray();
        for (int i = 0; i < length; i++) {
            PalindromeLength[i][i]=1;
        }
        for (int i = 0; i < length-1; i++) {
            if(charArray[i]==charArray[i+1])
                PalindromeLength[i][i+1]=2;
            else
                PalindromeLength[i][i+1]=1;
        }
        for (int step = 2; step < length; step++) {
            for (int i = 0; i+step< length; i++) {
                //PalindromeLength[i][i+step]
                if(charArray[i]==charArray[i+step])
                    PalindromeLength[i][i+step]=PalindromeLength[i+1][i+step-1]+2;
                else {
                    PalindromeLength[i][i+step]=Math.max(PalindromeLength[i+1][i+step],PalindromeLength[i][i+step-1]);
                }
            }
        }
        return PalindromeLength[0][length-1];
    }

    //官方更简便的写法
    public int longestPalindromeSubseq1(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            char c1 = s.charAt(i);
            for (int j = i + 1; j < n; j++) {
                char c2 = s.charAt(j);
                if (c1 == c2) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }


}
