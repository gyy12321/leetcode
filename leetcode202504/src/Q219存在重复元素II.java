import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q219存在重复元素II {
    public static void main(String[] args) {

    }
    //42
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if(map.containsKey(num)){
                if(i-map.get(num)<=k)
                    return true;
            }
            map.put(num,i);
        }
        return false;
    }

    //自己的滑动窗口的写法，又臭又长
    public boolean containsNearbyDuplicate1(int[] nums, int k) {

        Set<Integer> set=new HashSet<>();
        if(k>nums.length-1){
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                if(set.contains(num))
                    return true;
                set.add(num);
            }

        }
        else {
            int left=0;
            int right=k+1;
            for (int i = 0; i <= k; i++) {
                int num = nums[i];
                if(set.contains(num))
                    return true;
                set.add(num);
            }
            while (right<nums.length){
                set.remove(nums[left]);
                int num = nums[right];
                if(set.contains(num))
                    return true;
                set.add(num);
                left++;
                right++;
            }
        }
        return false;
    }
}

//滑动窗口写法，答案的写法比较的巧妙
class Solution219_1 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            //前面几个只管往集合里加，到后面才需要去掉滑动窗口的首个元素
            if (i > k) {
                set.remove(nums[i - k - 1]);
            }
            //添加滑动窗口的最右边元素，若失败则表示窗口里已经有这个元素了，返回true
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }
}
