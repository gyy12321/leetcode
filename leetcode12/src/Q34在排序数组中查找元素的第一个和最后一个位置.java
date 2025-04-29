import java.util.Arrays;

public class Q34在排序数组中查找元素的第一个和最后一个位置 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange1(new int[]{5,7,7,8,8,10},8)));
    }
    public static int[] searchRange(int[] nums, int target) {

        int length = nums.length;
        int l=0;
        int r=length-1;
        int m;
        while (l<=r){
            //改
            m=l+(r-l)/2;
            if(nums[m]<target)
                l=m+1;
            else
                r=m-1;
        }
        if(l==length||nums[l]!=target)
            return new int[]{-1,-1};
        int lm=l,rm=l;
        while (lm>=0&&nums[lm]==target){
            lm--;
        }
        lm++;
        while (rm<length&&nums[rm]==target){
            rm++;
        }
        rm--;
        return new int[]{lm,rm};
    }

    public static int[] searchRange1(int[] nums, int target) {
        int length = nums.length;
        int l=0;
        int r=length-1;
        int m;
        while (l<=r){
            //改
            m=l+(r-l)/2;
            if(nums[m]<target-0.5)
                l=m+1;
            else
                r=m-1;
        }

        int l1=0;
        int r1=length-1;
        int m1;
        while (l1<=r1){
            //改
            m1=l1+(r1-l1)/2;
            if(nums[m1]<target+0.5)
                l1=m1+1;
            else
                r1=m1-1;
        }
        if(l==l1)
            return new int[]{-1,-1};
        else
            return new int[]{l,l1-1};
    }

    // 两次二分查找，分开查找第一个和最后一个
    // 时间复杂度 O(log n), 空间复杂度 O(1)
    // [1,2,3,3,3,3,4,5,9]
    public int[] searchRange2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int first = -1;
        int last = -1;
        // 找第一个等于target的位置
        while (left <= right) {
            int middle = (left + right) / 2;
            if (nums[middle] == target) {
                first = middle;
                right = middle - 1; //重点
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }


        // 最后一个等于target的位置
        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (nums[middle] == target) {
                last = middle;
                left = middle + 1; //重点
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return new int[]{first, last};
    }
}
