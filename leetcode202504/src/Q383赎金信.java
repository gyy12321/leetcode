import java.util.HashMap;
import java.util.Map;

public class Q383赎金信 {
    public static void main(String[] args) {

    }
    //30
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character,Integer> map=new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            //remain有可能为null需要注意，所以用getordefault
            Integer remain = map.getOrDefault(c,0);
            if(remain==0)
                return false;
            map.put(c,--remain);
        }
        return true;
    }

    //99
    public boolean canConstruct1(String ransomNote, String magazine) {
        int[] letters=new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            letters[c-'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            //remain有可能为null需要注意，所以用getordefault
            int index=c-'a';
            if(letters[index]==0)
                return false;
            letters[index]--;
        }
        return true;
    }

}


class Solution383_1{
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        int[] cnt = new int[26];
        //tochararray可以遍历string的每一个字符
        for (char c : magazine.toCharArray()) {
            cnt[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            cnt[c - 'a']--;
            if(cnt[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}

