import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q26删除有序数组中的重复项 {
    public int removeDuplicates(int[] nums) {
        Set<Integer> set=new HashSet<>();
        int index=0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if(!set.contains(num)) {
                set.add(num);
                nums[index++] = num;
            }
        }
        return index;
    }
    //双指针思想，和答案基本一样
    public int removeDuplicates1(int[] nums) {
        int left=1;
        int right=1;
        while (right<nums.length){
            if(nums[right]!=nums[left-1]){
                nums[left]=nums[right];
                left++;
            }
            right++;
        }
        return left;
    }
}

