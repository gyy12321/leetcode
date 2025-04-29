import java.util.Arrays;

public class Q45跳跃游戏2 {
    public static void main(String[] args) {

    }
    //效率太低
    public int jump(int[] nums) {
        int n = nums.length;
        if(n==1)
            return 0;
        int[] lags=new int[n];
        Arrays.fill(lags,Integer.MAX_VALUE);
        lags[0]=0;
        int begin=0;
        int end=0;
        while (true){
            for (int i=begin;i<=end;i++){
                int end1=end;
                for (int j = 1; j <= nums[i]; j++) {
                    if(i+j<=end)
                        continue;
                    if(i+j==n-1)
                        return lags[i]+1;
                    lags[i+j]=Math.min(lags[i+j],lags[i]+1);
                    end1=Math.max(end1,i+j);
                }
                begin=end+1;
                end=end1;
            }
        }


    }
    //版本二效率高,jump1和jump2差不多，jump2是第二次3.17写的
    public int jump1(int[] nums) {
        int n = nums.length;
        if(n==1)
            return 0;
        int begin=0;
        int end=0;
        int maxRange=0;
        int legs=0;
        while (true){
            legs++;
            for (int i=begin;i<=end;i++){
                maxRange=Math.max(maxRange,i+nums[i]);
                if(maxRange>=n-1)
                    return legs;
            }
            begin=end+1;
            end=maxRange;
        }
    }

    public int jump2(int[] nums) {
        int n = nums.length;
        int rightmost=0;
        int steps=0;
        int begin=0;
        int end=0;
        while (rightmost<n-1){
            //rightmost乱变，用temp代替rightmost
            for(int i=begin;i<=end;i++){
                if(i+nums[i]>rightmost){
                    rightmost=i+nums[i];
                }
            }
            steps++;
            begin=end+1;
            end=rightmost;
        }
        return steps;
    }

    //官方解法，稍微有点难理解
    public int jump3(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            //到达i-1的最远点，必须要再往前走一步了
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }



}
