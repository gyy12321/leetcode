public class Q121买卖股票的最佳时机_ {
    public static void main(String[] args) {

    }

    public static int maxProfit(int[] prices) {
        if(prices.length==1)
            return 0;
        // 记录最小值和最大值
        int[] mins=new int[prices.length];
        int[] maxs=new int[prices.length];
        int temp1=prices[0];
        int temp2=prices[prices.length-1];
        for (int i = 0; i < prices.length-1; i++) {
            if(prices[i]<temp1){
                temp1=prices[i];
            }
            mins[i]=temp1;
            if(prices[prices.length-i-1]>temp2){
                temp2=prices[prices.length-i-1];
            }
            maxs[prices.length-i-2]=temp2;
        }
        int result=0;
        // 遍历求result最大值
        for (int i = 0; i < prices.length-1; i++) {
            result=maxs[i]-mins[i]>result?maxs[i]-mins[i]:result;
        }
        return result;
    }

    //答案写法更简答，思路不算难，一次遍历

    public int maxProfit1(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        //只需要遍历一次
        //i决定在哪一天卖掉股票
        for (int i = 0; i < prices.length; i++) {
            //第i天是前面这么多天里最便宜的，哪一天肯定不能卖
            if (prices[i] < minprice) {
                minprice = prices[i];
            }
            //第i天卖，相较之前最便宜的某一天买入，能赚到的利润比之前的利润多，就更新
            else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }
        //返回最大利润
        return maxprofit;
    }


}
