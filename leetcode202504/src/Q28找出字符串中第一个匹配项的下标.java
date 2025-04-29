public class Q28找出字符串中第一个匹配项的下标 {
    public int strStr(String haystack, String needle) {
        int l1 = haystack.length();
        int l2 = needle.length();
        for(int i=0;i+l2<=l1;i++){
            //haystack从i下标开始进行一次单词匹配
            boolean flag=true;
            for(int j=i;j<=i+l2-1;++j){
                if(haystack.charAt(j)!=needle.charAt(j-i)){
                    flag=false;
                    break;
                }
            }
            if(flag)
                return i;
        }
        return -1;
    }
}



//

//暴力匹配
class Solution28_1 {
    public int strStr(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        for (int i = 0; i + m <= n; i++) {
            boolean flag = true;
            for (int j = 0; j < m; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return i;
            }
        }
        return -1;
    }
}
