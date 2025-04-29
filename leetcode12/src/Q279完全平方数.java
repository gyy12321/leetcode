public class Q279完全平方数 {
    public static void main(String[] args) {
        System.out.println(numSquares(13));
    }
    //自己写的效率极低
    public static int numSquares1(int n){
        int[] dp=new int[n+1];
        for (int i = 1; i <= n; i++) {
            dp[i]=Integer.MAX_VALUE;
        }
        //dp[i]表示i最少需要多少个完全平方数表示,初始为最大整数
        for(int i=1;i<=n;++i){
            int sqrt = (int)(Math.sqrt(i));
            if(i==sqrt*sqrt){
                dp[i]=1;
                continue;
            }
            for(int j=1;j<=i/2;++j)
                //拆分为两个子问题
                dp[i]=Math.min(dp[i],dp[j]+dp[i-j]);
        }
        return dp[n];
    }

    //标准答案效率高，
    public static int numSquares(int n) {
        int[] f = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int minn = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                //关键一步，显著降低复杂度
                minn = Math.min(minn, f[i - j * j]);
            }
            f[i] = minn + 1;
        }
        return f[n];
    }

    //把标准答案改的更简单后反而效率低了些
    public static int numSquares2(int n) {
        int[] f = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            f[i] = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                f[i]=Math.min(f[i],f[i-j*j]+1);
            }
        }
        return f[n];
    }
}
