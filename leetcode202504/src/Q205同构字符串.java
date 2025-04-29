import java.util.HashMap;
import java.util.Map;

public class Q205同构字符串 {
    public static void main(String[] args) {


    }

    //80多
    public boolean isIsomorphic(String s, String t) {
        Map<Character,Character> map=new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            //有这个映射规则
            if (map.containsKey(c1)) {
                //保证同样的key映射到同样的value
                if(map.get(c1)!=c2)
                    return false;
            }
            //没有这个映射规则
            else {
                //加了这么一句，保证不同的keg不能映射到同一个value
                if(map.containsValue(c2))
                    return false;
                //添加这个映射规则
                map.put(c1,c2);
            }
        }
        return true;
    }
}

//答案用两个map，实现双射。效率23
class Solution205_1 {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> s2t = new HashMap<Character, Character>();
        Map<Character, Character> t2s = new HashMap<Character, Character>();
        int len = s.length();
        for (int i = 0; i < len; ++i) {
            char x = s.charAt(i), y = t.charAt(i);
            if ((s2t.containsKey(x) && s2t.get(x) != y) || (t2s.containsKey(y) && t2s.get(y) != x)) {
                return false;
            }
            s2t.put(x, y);
            t2s.put(y, x);
        }
        return true;
    }
}
