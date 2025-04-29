import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//非常非常经典
public class Q560和为k的子数组_ {
    public static void main(String[] args) {
        ArrayList<Integer> a1 = new ArrayList<>();
        a1.add(1);
        ArrayList<Integer> a2 = (ArrayList<Integer>)a1.clone();
        System.out.println(a2);
        System.out.println(a1.equals(a2));
        System.out.println(a1==a2);
        System.out.println(subarraySum(new int[]{1,2,3},3));
    }
    //方法二，看了好久终于理解了，配合动画
    public static int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int pre=0;
        int res=0;
        //对于pre[i]，用hash表得到值为pre[i]-k的pre[j]个数，并加到结果里
        //hash(x.y)：前缀和为x的个数是y
        //用pre代替pre[i]数组，可以进一步节约空间
        for (int num : nums) {
            pre+=num;
            if(map.containsKey(pre-k)){
                res+=map.get(pre-k);
            }
            map.put(pre,map.getOrDefault(pre,0)+1);
        }
        return res;
    }

    //方法一：枚举法没有什么难度
//    public static int subarraySum(int[] nums, int k) {
//        int res=0;
//        for (int i = 0; i < nums.length; i++) {
//            int temp=0;
//            for (int j = i; j < nums.length; j++) {
//                temp+=nums[j];
//                if(temp==k)
//                    res++;
//            }
//        }
//        return res;
//    }



}
