public class Q123买卖股票的最佳时机III {

}
//看官方详细题解
class Solution_1 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        //初始化
        int buy1 = -prices[0], sell1 = 0;
        int buy2 = -prices[0], sell2 = 0;
        //每一天结束时候有四个状态，只买过一次，买卖各一次，买卖一次加买一次，买卖各两次
        //一天中可以多次买和卖
        for (int i = 1; i < n; ++i) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return sell2;
    }
}

