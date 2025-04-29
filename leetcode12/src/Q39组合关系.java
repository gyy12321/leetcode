import java.util.ArrayList;
import java.util.List;

public class Q39组合关系 {
    //收货挺大
    List<List<Integer>> res=new ArrayList<>();
    List<Integer> ans =new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(new Q39组合关系().combinationSum(new int[]{2,3,6,7},7));
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        Arrays.sort(candidates);
        dfs(target,candidates,0);
        return res;
    }

    public void dfs(int n,int[] candidates,int preIndex){
        if(n==0){
            res.add(new ArrayList<>(ans));
            return;
        }
        //从上一个取了的地方以及之后再取，不能取前面的
        for (int i = preIndex; i < candidates.length; i++) {
            //带有剪枝功能
            if(n-candidates[i]>=0){
                ans.add(candidates[i]);
                dfs(n-candidates[i],candidates,i);
                ans.remove(ans.size()-1);
            }
        }
    }

}

//答案解法，需要好好理解一下
class Solution39_1 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> combine = new ArrayList<Integer>();
        dfs(candidates, target, ans, combine, 0);
        return ans;
    }

    public void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> combine, int idx) {
        if (idx == candidates.length) {
            return;
        }
        if (target == 0) {
            ans.add(new ArrayList<Integer>(combine));
            return;
        }
        // 直接跳过
        dfs(candidates, target, ans, combine, idx + 1);
        // 选择当前数
        if (target - candidates[idx] >= 0) {
            combine.add(candidates[idx]);
            dfs(candidates, target - candidates[idx], ans, combine, idx);
            combine.remove(combine.size() - 1);
        }

    }
}



