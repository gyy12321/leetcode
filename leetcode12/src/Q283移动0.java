public class Q283移动0 {
    public static void main(String[] args) {

    }
    public void moveZeroes(int[] nums) {
        int zeros=0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==0)
                zeros++;
            else
                nums[i-zeros]=nums[i];
        }
        int begin=nums.length-1;
        while (zeros>0){
            nums[begin--]=0;
            zeros--;
        }
    }
}
