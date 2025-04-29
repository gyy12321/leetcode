import java.util.HashSet;
import java.util.Set;

public class Q136只出现一次的数字 {
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{1,1,2,2,4,3,3}));
    }
    //空间复杂度为O(n)的方法有三种，答案里有写
    public static int singleNumber(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for (int num : nums) {
            if(set.contains(num))
                set.remove(num);
            else {
                set.add(num);
            }
        }
        for (Integer integer : set) {
            return integer;
        }
        return -1;
    }
}
//异或运算，数组中的全部元素的异或运算结果即为数组中只出现一次的数字
class Solution136_1 {
    //异或运算
    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }
}
