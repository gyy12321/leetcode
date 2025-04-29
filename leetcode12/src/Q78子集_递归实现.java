import java.util.ArrayList;
import java.util.List;

public class Q78子集_递归实现 {
    List<Integer> temp=new ArrayList<>();
    List<List<Integer>> res=new ArrayList<>();
    public static void main(String[] args) {
        Q78子集_递归实现 q78子集_递归实现 = new Q78子集_递归实现();
        System.out.println(q78子集_递归实现.subsets(new int[]{1,2,3,4}));
    }

    public List<List<Integer>> subsets(int[] nums) {
        dfs(0,nums);
        return res;
    }

    public void dfs(int cur,int[] nums){
        //n时加入一个结果
        if (cur==nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        //共有0~n-1位都要决定，选该元素还是不选该元素
        temp.add(nums[cur]);
        dfs(cur+1,nums);
        temp.remove(temp.size()-1);
        dfs(cur+1,nums);
    }
}
