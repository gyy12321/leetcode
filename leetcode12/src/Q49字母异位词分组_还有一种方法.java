import java.util.*;

public class Q49字母异位词分组_还有一种方法 {
    public static void main(String[] args) {
//        Map<String,List<String>> map=new HashMap<>();
//        ArrayList<String> list = new ArrayList<>();
//        list.add("456");
//        map.put("123",list);
//        List<String> list1 = map.get("123");
//        list1.add("789");
//        System.out.println(map.get("123"));
        List<List<String>> lists = groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        System.out.println(lists);
//        ArrayList<Integer> integers = new ArrayList<>();
//        integers.add(1);
//        System.out.println(integers.hashCode());
//        int[] aa=new int[11];
//        System.out.println(aa);
//        System.out.println(aa.hashCode());
//        System.out.println(Integer.parseInt("15aeb7ab",16));
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
//        Map<String,List<String>> map=new HashMap<>();
//        for (int i = 0; i < strs.length; i++) {
//            String s=strs[i];
//            char[] charArray = s.toCharArray();
//            Arrays.sort(charArray);
//            //特别注意，不可以用tostring！！！！！！
//            //！！！！！！！！
//            //!!!!!!!!!!!!
//            //!!!!!!!!!!!!!
//            String key = Arrays.toString(charArray);
//            List<String> list = map.getOrDefault(key, new ArrayList<String>());
//            list.add(s);
//            map.put(key,list);
//        }
//
//        return new ArrayList<List<String>>(map.values());
        Map<String,List<String>> map=new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String s=new String(charArray);
            List<String> list = map.getOrDefault(s, new ArrayList<String>());
            list.add(str);
            map.put(s,list);
        }
        List<List<String>> res=new ArrayList<>();
        for (List<String> value : map.values()) {
            res.add(value);
        }
        return res;
    }
}

//方法二还不会，方法一会了
class Solution49_1 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String s=new String(charArray);
            List<String> list = map.getOrDefault(s, new ArrayList<String>());
            list.add(str);
            map.put(s,list);
        }
        List<List<String>> res=new ArrayList<>();
        for (List<String> value : map.values()) {
            res.add(value);
        }
        return res;
    }
}
