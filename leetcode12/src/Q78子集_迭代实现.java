import java.util.ArrayList;
import java.util.List;

public class Q78子集_迭代实现 {
    List<Integer> t = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    public static void main(String[] args) {

    }
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        //0~2的n次方-1对应所有的子集的元素情况
        for (int mask = 0; mask < (1 << n); ++mask) {
            //清空
            t.clear();
            for (int i = 0; i < n; ++i) {
                //和n位01串作与操作，若某一位为1则将该位对应的数字加进去
                if ((mask & (1 << i)) != 0) {
                    t.add(nums[i]);
                }
            }
            //结果集中加入一个
            ans.add(new ArrayList<Integer>(t));
        }
        return ans;
    }

}
