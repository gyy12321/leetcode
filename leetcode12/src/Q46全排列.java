import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

//效率很低，不知道为什么
public class Q46全排列 {
    public static void main(String[] args) {
        List<List<Integer>> permute = permute(new int[]{1, 2, 4, 3});
        for (int i = 0; i < permute.size(); i++) {
            System.out.println(permute.get(i));
        }
    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        backtrack(0,nums,list);
        return list;
    }
    public static void backtrack(int n,int[] nums,List<List<Integer>> list){
        if(n==nums.length-1){
            //boxed将基本数据类型转化为包装类型
            List<Integer> temp = Arrays.stream(nums).boxed().collect(Collectors.toList());
            list.add(temp);
        }
        for (int i=n;i<nums.length;i++){
            swap(nums,i,n);
            backtrack(n+1,nums,list);
            swap(nums,i,n);
        }
    }

    public static void swap(int[] nums,int index1,int index2){
        int temp=nums[index1];
        nums[index1]=nums[index2];
        nums[index2]=temp;
    }
}
