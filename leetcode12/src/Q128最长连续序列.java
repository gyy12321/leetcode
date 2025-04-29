import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Q128最长连续序列 {
    public static void main(String[] args) {

    }
    //类似官解,用集合存
    public int longestConsecutive(int[] nums) {
//        if(nums.length==0)
//            return 0;
//        Set<Integer> set=new HashSet<>();
//        for (int num : nums) {
//            set.add(num);
//        }
//        int res=1;
//        for (Integer x : set) {
//            if(!set.contains(x-1)) {
//                int temp = x + 1;
//                while (set.contains(temp))
//                    temp++;
//                res = Math.max(res, temp - x);
//            }
//        }
//        return res;
        if(nums.length==0)
            return 0;
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res=1;
        for (Integer x : set) {
            if(!set.contains(x-1)){
                int max=x;
                while (set.contains(max+1))
                    max++;
                res=Math.max(res,max-x+1);
            }
        }
        return res;
    }
}
