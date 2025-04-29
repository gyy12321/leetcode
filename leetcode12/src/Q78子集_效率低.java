import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//一坨大便，自己写的连自己都看不懂
public class Q78子集_效率低 {
    public static void main(String[] args) {
        System.out.println(subsets(new int[]{4,1,2,3}));
    }
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        res.add(new ArrayList<>());
        backtrack(0,nums.length,list,res);
        return res;
    }
    public static void backtrack(int check,int n,List<Integer> list,List<List<Integer>> res){
        if(check==n){
            return;
        }
        if (check==0){
            for (int i = 0; i < n; i++) {
                Collections.swap(list,check,i);
                res.add(new ArrayList<>(list.subList(0,1)));
                backtrack(check+1,n,list,res);
                Collections.swap(list,check,i);
            }
        }
        else {
            for (int i = check; i < n; i++) {
                if(list.get(check-1)<=list.get(i)){
                    Collections.swap(list,check,i);
                    res.add(new ArrayList<>(list.subList(0,check+1)));
                    backtrack(check+1,n,list,res);
                    Collections.swap(list,check,i);
                }
            }
        }

    }
}
