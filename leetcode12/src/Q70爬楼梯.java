public class Q70爬楼梯 {
    public static void main(String[] args) {
        System.out.println(climbStairs2(45));
    }

    public static int climbStairs(int n) {
        if(n==2)
            return 2;
        else if(n==1)
            return 1;
        else
            return climbStairs(n-2)+climbStairs(n-1);
    }

    public static int climbStairs2(int n) {
        if(n==1)
            return 1;
        if(n==2)
            return 2;
        int[] steps=new int[n+1];
        steps[1]=1;
        steps[2]=2;
        for (int i = 3; i <= n; i++) {
            steps[i]=steps[i-2]+steps[i-1];
        }
        return steps[n];
    }
}
