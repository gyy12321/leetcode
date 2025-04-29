import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q46全排列__标准答案 {
    public static void main(String[] args) {
        List<List<Integer>> permute = permute(new int[]{1, 2, 4, 3});
        for (int i = 0; i < permute.size(); i++) {
            System.out.println(permute.get(i));
        }
    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        List<Integer> output = new ArrayList<Integer>();
        for (int num : nums) {
            output.add(num);
        }

        int n = nums.length;
        backtrack(n, output, res, 0);
        return res;
    }

    //output为每一个答案，res为最后提交的所有答案的集合，n为数字个数，first表示处理到第几个数字了
    public static void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
        // 所有数都填完了
        if (first == n-1) {
            //output会变的，所以不可以直接加入output
            res.add(new ArrayList<Integer>(output));
        }
        //first=0时候0~n-1的数依次和第0位交换
        for (int i = first; i < n; i++) {
            // 动态维护数组，
            Collections.swap(output, first, i);
            // 继续递归填下一个数，第first位已经确定了，需要不断变更first+1位
            backtrack(n, output, res, first + 1);
            // 撤销操作
            Collections.swap(output, first, i);
        }
    }
}
