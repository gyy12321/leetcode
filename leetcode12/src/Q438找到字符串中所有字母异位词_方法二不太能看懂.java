import java.util.*;

//good
public class Q438找到字符串中所有字母异位词_方法二不太能看懂 {
    public static void main(String[] args) {
        Set<Integer> set1=new HashSet<>();
        Set<Integer> set2=new HashSet<>();
        set1.add(1);
        set1.add(2);
        set2.add(1);
        set2.add(2);
        System.out.println(set1.equals(set2));
        System.out.println();
    }
    //方法一
    public List<Integer> findAnagrams11(String s, String p) {
        if(s.length()<p.length())
            return new ArrayList<>();
        List<Integer> res=new ArrayList<>();
        int sLen = s.length();
        int pLen = p.length();
        int[] sNum=new int[26];
        int[] pNum=new int[26];
        for (int i = 0; i < pLen; i++) {
            sNum[s.charAt(i)-'a']++;
            pNum[p.charAt(i)-'a']++;
        }
        if(Arrays.equals(sNum,pNum))
            res.add(0);
        for(int i=0;i+pLen<sLen;++i){
            sNum[s.charAt(i)-'a']--;
            sNum[s.charAt(i+pLen)-'a']++;
            if(Arrays.equals(sNum,pNum))
                res.add(i+1);
        }
        return res;

    }

//    public static List<Integer> findAnagrams(String s, String p) {
//        List<Integer> res=new ArrayList<>();
//        int n = p.length();
//        for (int i = 0; i+n-1 < s.length(); i++) {
//            String substring = s.substring(i, i + n);
//            if(isValid(p,substring))
//                res.add(i);
//        }
//        return res;
//    }
//    public static boolean isValid(String p, String subString){
//        char[] array1 = p.toCharArray();
//        char[] array2 = subString.toCharArray();
//        Arrays.sort(array1);
//        Arrays.sort(array2);
//        for (int i = 0; i < array1.length; i++) {
//            if(array1[i]!=array2[i])
//                return false;
//        }
//        return true;
//    }

    public List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        List<Integer> res=new ArrayList<>();
        if(sLen<pLen)
            return new ArrayList<Integer>();
        int[] nums=new int[26];
        int[] change=new int[26];
        for (int i = 0; i < pLen; i++) {
            char c1 = p.charAt(i);
            char c2 = s.charAt(i);
            nums[c1-'a']++;
            change[c2-'a']++;
        }
        if(Arrays.equals(nums,change))
            res.add(0);
        for (int i = 0; i+pLen < sLen; ++i) {
            char c = s.charAt(i);
            change[c-'a']--;
            char c1 = s.charAt(i + pLen);
            change[c1-'a']++;
            if(Arrays.equals(nums,change))
                res.add(i+1);
        }

        return res;

    }
}

//官方方法二能看懂了，节约空间
class Solution_2 {
    public List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length(), pLen = p.length();

        if (sLen < pLen) {
            return new ArrayList<Integer>();
        }

        List<Integer> ans = new ArrayList<Integer>();
        int[] count = new int[26];
        for (int i = 0; i < pLen; ++i) {
            ++count[s.charAt(i) - 'a'];
            --count[p.charAt(i) - 'a'];
        }

        int differ = 0;
        for (int j = 0; j < 26; ++j) {
            if (count[j] != 0) {
                ++differ;
            }
        }

        if (differ == 0) {
            ans.add(0);
        }

        for (int i = 0; i < sLen - pLen; ++i) {
            if (count[s.charAt(i) - 'a'] == 1) {  // 窗口中字母 s[i] 的数量与字符串 p 中的数量从不同变得相同
                --differ;
            } else if (count[s.charAt(i) - 'a'] == 0) {  // 窗口中字母 s[i] 的数量与字符串 p 中的数量从相同变得不同
                ++differ;
            }
            --count[s.charAt(i) - 'a'];

            if (count[s.charAt(i + pLen) - 'a'] == -1) {  // 窗口中字母 s[i+pLen] 的数量与字符串 p 中的数量从不同变得相同
                --differ;
            } else if (count[s.charAt(i + pLen) - 'a'] == 0) {  // 窗口中字母 s[i+pLen] 的数量与字符串 p 中的数量从相同变得不同
                ++differ;
            }
            ++count[s.charAt(i + pLen) - 'a'];

            if (differ == 0) {
                ans.add(i + 1);
            }
        }

        return ans;
    }
}

