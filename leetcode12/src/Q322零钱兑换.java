import java.util.Arrays;

public class Q322零钱兑换 {
    public static void main(String[] args) {

    }
    public int coinChange(int[] coins, int amount) {
        if (amount == 0)
            return 0;
        int[] dp = new int[amount + 1];
        // for (int i = 1; i <= amount; i++) {
        // dp[i]=-1;
        // }
        Arrays.sort(coins);
        dp[0]=0;
        for (int i = 1; i <= amount; i++) {
            dp[i] = -1;
            for (int j = 0; j < coins.length; j++) {
                if (coins[j]<=i&&dp[i - coins[j]] != -1) {
                    if (dp[i] == -1)
                        dp[i] = dp[i - coins[j]] + 1;
                    else
                        dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }

            }
        }
        return dp[amount];
    }

    public int coinChange1(int[] coins, int amount) {
        if(amount==0)
            return 0;
        int[] dp=new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0]=0;
        Arrays.sort(coins);
        for(int i=1;i<=amount;i++){
            for (int coin : coins) {
                if(i>=coin)
                    dp[i]=Math.min(dp[i],dp[i-coin]+1);
                else
                    break;
            }
        }
        return dp[amount]>amount?-1:dp[amount];
    }
}

class Solution322_1 {
    public int coinChange(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }
        return coinChange(coins, amount, new int[amount]);
    }

    //精髓在于count做了记录，虽然看懂了，但效率比方法二低
    private int coinChange(int[] coins, int rem, int[] count) {
        if (rem < 0) {
            return -1;
        }
        if (rem == 0) {
            return 0;
        }
        if (count[rem - 1] != 0) {
            return count[rem - 1];
        }
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChange(coins, rem - coin, count);
            if (res >= 0 && res < min) {
                min = 1 + res;
            }
        }
        count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[rem - 1];
    }
}


//方法二更好，更容易看懂好理解
class Solution322_2 {
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}


