public class Q27移出元素 {
    public static void main(String[] args) {
        int[] ints = {0, 1, 2, 2, 3, 0, 4, 2};
        System.out.println(removeElement(ints,2));
        System.out.println("-----------------");
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }

    }
    public static int removeElement(int[] nums, int val) {
        int num=0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==val)
                num++;
            else
                nums[i-num]=nums[i];
        }
        return num;
    }
    //双指针
    public static int removeElement1(int[] nums, int val) {
        int n = nums.length;
        int left = 0;
        for (int right = 0; right < n; right++) {
            if (nums[right] != val) {
                nums[left] = nums[right];
                left++;
            }
        }
        return left;
    }
}

//双指针优化
class Solution27_2 {
    public int removeElement(int[] nums, int val) {
        int left = 0;
        int right = nums.length-1;
        //注意边界条件
        while (left <= right) {
            if (nums[left] == val) {
                nums[left] = nums[right];
                right--;
            } else {
                left++;
            }
        }
        return left;
    }
}
