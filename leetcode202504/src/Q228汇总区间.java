import java.util.ArrayList;
import java.util.List;

public class Q228汇总区间 {
    public static void main(String[] args) {
//        Solution228_2.summaryRanges(new int[]{0,1,2,4,5,7});
    }
    //38
    public List<String> summaryRanges(int[] nums) {
        List<String> list=new ArrayList<>();
        if(nums.length==0)
            return list;
        if(nums.length==1){
            list.add(nums[0]+"");
            return list;
        }
        int l=0;
        int i;
        for (i = 1; i < nums.length; i++) {
            if(nums[i]!=nums[i-1]+1){
                if(i-1==l)
                    list.add(nums[l]+"");
                else {
                    list.add(nums[l]+"->"+nums[i-1]);
                }
                l=i;
            }
        }
        //最后一次不能忘记
        if(l==nums.length-1)
            list.add(nums[l]+"");
        else
            list.add(nums[l]+"->"+nums[i-1]);
        return list;
    }
}
//答案一次遍历100，没有像我分多个情况
class Solution228_1 {
    public static List<String> summaryRanges(int[] nums) {
        List<String> ret = new ArrayList<String>();
        int i = 0;
        int n = nums.length;

        //嵌套的循环，边界条件比较难搞
        while (i < n) {
            int low = i;
            i++;
            //若比前一个始终大1，。则不断后移i
            while (i < n && nums[i] == nums[i - 1] + 1) {
                i++;
            }
            int high = i - 1;
            //找到开始位置low以及结束位置high
            StringBuffer temp = new StringBuffer(Integer.toString(nums[low]));
            //区间长度大于一特殊的->格式
            if (low < high) {
                temp.append("->");
                temp.append(Integer.toString(nums[high]));
            }
            //区间加入list
            ret.add(temp.toString());
        }
        return ret;
    }
}

//自己仿照答案写的，i略有不同
class Solution228_1m {
    public static List<String> summaryRanges(int[] nums) {
        List<String> ret = new ArrayList<String>();
        int i = 0;
        int n = nums.length;

        //嵌套的循环，边界条件比较难搞
        while (i < n) {
            int low = i;
            //若比前一个始终大1，。则不断后移i
            while (i+1 < n && nums[i+1] == nums[i] + 1) {
                i++;
            }
            int high = i;
            //找到开始位置low以及结束位置high
            //Integer.tostring效率比字符串拼接要高
            StringBuffer temp = new StringBuffer(Integer.toString(nums[low]));
            //区间长度大于一特殊的->格式
            if (low < high) {
                temp.append("->");
                temp.append(nums[high]);
            }
            //区间加入list
            ret.add(temp.toString());
            i++;
        }
        return ret;
    }
}