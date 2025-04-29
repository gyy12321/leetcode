public class Q509使用最小花费爬楼梯 {
    public static void main(String[] args) {
        minCostClimbingStairs(new int[]{
                1,100,1,1,1,100,1,1,100,1
        });
    }

    public static int minCostClimbingStairs(int[] cost) {
        int height = cost.length;
        if(height==2)
            return cost[0]>=cost[1]?cost[1]:cost[0];
        int[] lowest=new int[height+1];
        lowest[0]=lowest[1]=0;
        int x,y;
        for (int i = 2; i <= height; i++) {
            x=lowest[i-2]+cost[i-2];
            y=lowest[i-1]+cost[i-1];
            lowest[i]=x>=y?y:x;

        }
        return lowest[height];
    }
}
