public class Q55跳跃游戏 {
    public static void main(String[] args) {

    }
    public static boolean canJump(int[] nums) {
        int remainStep=nums[0];
        //已经nums.length-1，只需要到达最后一个元素即可
        for (int i = 0; i < nums.length-1; i++) {
            remainStep=Math.max(remainStep,nums[i]);
            if(i+remainStep>=nums.length-1)
                return true;
            if(remainStep==0)
                return false;
            remainStep--;
        }
        return true;
    }

    public static boolean canJump1(int[] nums) {
        //向右最远距离法
        //贪心算法
        int n = nums.length;
        int rightMost=0;
        for (int i = 0; i < n; i++) {
            //一旦i>rightMost,则快速执行完所有的循环并退出，返回false
            if(i<=rightMost){
                //每走一步更新一次rightmost
                rightMost=Math.max(rightMost,i+nums[i]);
                if(rightMost>=n-1)
                    return true;
            }
        }
        return false;
    }
}
