import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q1两数之和_ {
    public static void main(String[] args) {
        int[] res = twoSum(new int[]{3,2,4}, 6);
        Arrays.stream(res).forEach(System.out::println);
    }
    public static int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        if(target%2==0){
            int value=target/2;
            int times=0;
            int[] res=new int[2];
            for (int i = 0; i < n; i++) {
                if(nums[i]==value)
                    res[times++]=i;
            }
            if(times==2)
                return res;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(nums[i],i);
        }
        for (int i = 0; i < n; i++) {
            Integer j = map.get(target - nums[i]);
            if(i!=j&&j!=null)
                return new int[]{i,j};
        }
        return null;
    }

    //官方解答
//    public int[] twoSum(int[] nums, int target) {
//        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
//        for (int i = 0; i < nums.length; ++i) {
//            if (hashtable.containsKey(target - nums[i])) {
//                return new int[]{hashtable.get(target - nums[i]), i};
//            }
//            hashtable.put(nums[i], i);
//        }
//        return new int[0];
//    }


}
