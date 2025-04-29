import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q46全排列_自己写第二遍 {
    public static void main(String[] args) {

        List<List<Integer>> permute = permute(new int[]{1, 4});
        for (List<Integer> integers : permute) {
            System.out.println(integers);
        }
    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        backtrack(0,nums.length,list,res);
        return res;
    }
    public static void backtrack(int check,int n,List<Integer> list,List<List<Integer>> res){
        if(check==n){
            res.add(new ArrayList<>(list));
        }
        for (int i = check; i < n; i++) {
            Collections.swap(list,check,i);
            backtrack(check+1,n,list,res);
            Collections.swap(list,check,i);
        }
    }
}
