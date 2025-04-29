public class Q153寻找旋转排序数组中的最小值_ {
    public static void main(String[] args) {

    }
    public int findMin(int[] nums) {
        int n = nums.length;
        if(n==1)
            return nums[0];
        if(n==2)
            return Math.min(nums[0],nums[1]);
        int l=0; int r=n-1;int middle;
        while (l<=r){
            middle=(l+r)/2;
            if(nums[middle]<nums[(middle+1)%n]&&nums[middle]<nums[(middle-1)%n])
                return nums[middle];
            if(nums[l]<nums[middle]&&nums[middle]<nums[r])
                return nums[l];
            //左边有序
            if(nums[l]<=nums[middle]){
                l=middle+1;
            }
            else {
                r=middle-1;
            }
        }
        return 1;
    }
//    public int findMin(int[] nums) {
//        int n = nums.length;
//        if(n==1)
//            return nums[0];
//        if(n==2)
//            return Math.min(nums[0],nums[1]);
//        int l=0; int r=n-1;int middle;
//        if(nums[0]<nums[r/2]&&nums[r/2]<nums[r])
//            return nums[l];
//        while (l<=r){
//            middle=(l+r)/2;
//            if(nums[middle]<nums[(middle+1)%n]&&nums[middle]<nums[(middle-1)%n])
//                return nums[middle];
//
//            //左边有序
//            if(nums[0]<=nums[middle]){
//                l=middle+1;
//            }
//            else {
//                r=middle-1;
//            }
//        }
//        return 1;
//    }
}
