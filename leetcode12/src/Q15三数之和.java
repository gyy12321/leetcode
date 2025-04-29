import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//经典题，有点难
public class Q15三数之和 {
    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4}));
        System.out.println();
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        Arrays.sort(nums);
        if(nums[0]>0)
            return res;
        for (int i = 0; i < nums.length; i++) {
            if(i>0&&nums[i]==nums[i-1])
                continue;
            int left=i+1;
            int right=nums.length-1;
            while (left<right){
                if(nums[i]+nums[left]+nums[right]==0){
                    List<Integer> l = Arrays.asList(nums[i], nums[left], nums[right]);
                    res.add(l);
                    left++;
                    while (left<right&&nums[left]==nums[left-1]){
                        left++;
                    }
                }
                else if(nums[i]+nums[left]+nums[right]>0){
                    right--;
                }
                else {
                    left++;
                }
            }
        }
        return res;
    }
}

//官方题解
class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // 枚举 a
        for (int first = 0; first < n; ++first) {
            // 需要和上一次枚举的数不相同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // c 对应的指针初始指向数组的最右端
            int third = n - 1;
            int target = -nums[first];
            // 枚举 b
            for (int second = first + 1; second < n; ++second) {
                // 需要和上一次枚举的数不相同
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
}

