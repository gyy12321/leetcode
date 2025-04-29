import java.util.ArrayList;
import java.util.List;

public class Q77组合 {

    public static void main(String[] args) {
        List<List<Integer>> res=new Q77组合().combine(5,3);
        System.out.println(res);

    }
    //自己写的做法，效率96还行
    List<List<Integer>> res;
    List<Integer> list;
    public List<List<Integer>> combine(int n, int k) {
        res=new ArrayList<>();
        list=new ArrayList<>();
        combineHelp(1,1,n,k);
        return res;
    }
    public void combineHelp(int begin,int step, int n, int k) {
        if(step>k){
            res.add(new ArrayList<>(list));
            return;
        }
        //第step轮加入的数的范围是begin~n-k+step,begin比上一轮的数大1.
        //生成的结果是递增顺序的
        for(int i=begin;i<=n-k+step;++i){
            list.add(i);
            combineHelp(i+1,step+1,n,k);
            list.remove(list.size()-1);
        }
    }

    //简单写法，效率稍微低一些.没有做到精准控制，必败7.3%
//    public void combineHelp1(int begin, int n, int k) {
//        if(list.size()==k){
//            res.add(new ArrayList<>(list));
//            return;
//        }
//        if(begin>n)
//            return;
//        for(int i=begin;i<=n;++i){
//            list.add(i);
//            combineHelp1(i+1,n,k);
//            list.remove(list.size()-1);
//        }
//    }

    public void dfs(int cur,int n){
        if(cur==n+1){

        }
    }
}

//答案不一样的递归实现，不错
class Solution77_1 {
    List<Integer> temp = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> combine(int n, int k) {
        dfs(1, n, k);
        return ans;
    }

    public void dfs(int cur, int n, int k) {
        // 剪枝：temp 长度加上区间 [cur, n] 的长度小于 k，不可能构造出长度为 k 的 temp
        if (temp.size() + (n - cur + 1) < k) {
            return;
        }
        // 记录合法的答案
        if (temp.size() == k) {
            ans.add(new ArrayList<Integer>(temp));
            return;
        }
        // 考虑选择当前位置
        temp.add(cur);
        dfs(cur + 1, n, k);
        temp.remove(temp.size() - 1);
        // 考虑不选择当前位置
        dfs(cur + 1, n, k);
    }
}

//字典序法，又臭又长，懒得看
class Solution77_2 {
    List<Integer> temp = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> combine(int n, int k) {
        List<Integer> temp = new ArrayList<Integer>();
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // 初始化
        // 将 temp 中 [0, k - 1] 每个位置 i 设置为 i + 1，即 [0, k - 1] 存 [1, k]
        // 末尾加一位 n + 1 作为哨兵
        for (int i = 1; i <= k; ++i) {
            temp.add(i);
        }
        temp.add(n + 1);

        int j = 0;
        while (j < k) {
            ans.add(new ArrayList<Integer>(temp.subList(0, k)));
            j = 0;
            // 寻找第一个 temp[j] + 1 != temp[j + 1] 的位置 t
            // 我们需要把 [0, t - 1] 区间内的每个位置重置成 [1, t]
            while (j < k && temp.get(j) + 1 == temp.get(j + 1)) {
                temp.set(j, j + 1);
                ++j;
            }
            // j 是第一个 temp[j] + 1 != temp[j + 1] 的位置
            temp.set(j, temp.get(j) + 1);
        }
        return ans;
    }
}

