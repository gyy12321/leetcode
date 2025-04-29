public class Q33搜索旋转排序数组_ {
    public static void main(String[] args) {
        System.out.println(search(new int[]{1},1));
    }
    public static int search(int[] nums, int target) {
        int low=0;
        int high=nums.length-1;
        int middle;
        while (low<=high){
            middle=low+(high-low)/2;
            if(nums[middle]==target)
                return middle;
            if(nums[middle]>=nums[0]){
                if(target>=nums[0]&&target<nums[middle]){
                    high=middle-1;
                }
                else {
                    low=middle+1;
                }
            }
            else{
                if(nums[middle]<target&&target<=nums[nums.length-1]){
                    low=middle+1;
                }
                else
                    high=middle-1;
            }
        }
        return -1;
    }
//    public static int searchHelp(int[] nums,int target,int low,int high){
//
//        int l=low;
//        int r=high;
//        int m;
//        while (l<=r){
//            //改
//            m=l+(r-l)/2;
//            if(nums[m]<target)
//                l=m+1;
//            else
//                r=m-1;
//        }
//        if(nums[l]==target)
//            return l;
//        else
//            return -1;
//    }
}
