import java.util.HashMap;
import java.util.Map;

public class Q290单词规律 {
    public static void main(String[] args) {
        System.out.println(wordPattern("abba","dog cat cat dog"));
    }
    //93.57
    public static boolean wordPattern(String pattern, String s) {
        Map<Character,String> map=new HashMap<>();
        String[] ss = s.split(" ");
        if(ss.length!=pattern.length())
            return false;

        for (int i = 0; i < pattern.length(); i++) {
            char c1 = pattern.charAt(i);
            String s1 = ss[i];
            //有这个映射规则
            if (map.containsKey(c1)) {
                //保证同样的key映射到同样的value
                if(!map.get(c1).equals(s1))
                    return false;
            }
            //没有这个映射规则
            else {
                //加了这么一句，保证不同的keg不能映射到同一个value!!!!!!!!!!!!!!!!!
                // !!!!!!!!!!!!!!!!!!
                if(map.containsValue(s1))
                    return false;
                //添加这个映射规则
                map.put(c1,s1);
            }
        }
        return true;
    }
}
