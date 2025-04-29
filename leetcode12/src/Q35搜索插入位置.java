import java.util.Arrays;

public class Q35搜索插入位置 {
    public static void main(String[] args) {
        int i = searchInsert(new int[]{1, 3, 4, 5}, -1);
        System.out.println(i);
    }
    public static int searchInsert(int[] nums, int target) {
        int i=0;
        int j=nums.length-1;
        int m;
        while (i<=j){

            //改
            m=(i+j)/2;
            if(nums[m]==target)
                return m;
            else if(nums[m]<target)
                i=m+1;
            else
                j=m-1;
        }
        return i;
    }
//    另一种类似写法
//    class Solution {
//        public:
//        int searchInsert(vector<int>& nums, int target) {
//            int n = nums.size();
//            int l=0,r=n-1;
//            while(l<=r){
//                int mid=l+(r-l)/2;
//                if(nums[mid]<target)
//                    l=mid+1;
//                else r=mid-1;
//            }
//            return l;
//        }
//    };
}
