public class Q392判断子序列 {
    public static void main(String[] args) {

    }
    //判断 s 是否为 t 的子序列
    //100
    public boolean isSubsequence(String s, String t) {
        int slen = s.length();
        int tlen = t.length();
        int index=0;
        //依次遍历比较短序列的每一位
        for (int i = 0; i < slen; i++) {
            char c = s.charAt(i);
            boolean find=false;
            //在t里寻找s中的第i位
            while (index<tlen){
                if(t.charAt(index)==c){
                    find=true;
                    index++;
                    break;
                }
                index++;
            }
            if(!find)
                return false;
        }
        return true;
    }
}

//90.66

class Solution392_1 {
    public boolean isSubsequence(String s, String t) {
        int n = s.length(), m = t.length();
        int i = 0, j = 0;
        //一个循环简单不少
        while (i < n && j < m) {
            //找到了s的第i位，则找寻s的i+1位
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            //每一轮t字符串的指针都要后移一位
            j++;
        }
        //探寻过所有都能找到，索引到达最后一个位置的下一个位置，超出范围，则寻找成功
        return i == n;
    }
}

//动态规划解法，花好久看懂,值得学习

class Solution392_2 {
    public boolean isSubsequence(String s, String t) {
        int n = s.length(), m = t.length();

        //f[i][j]表示字符串t的位置i以及之后，第一次出现字母j的位置。j=0表示a，1表示b。。。。。
        int[][] f = new int[m + 1][26];
        //设置初始状态，为了之后的递推逻辑做准备。位置m本身并没有啥意义
        for (int i = 0; i < 26; i++) {
            f[m][i] = m;
        }

        //t字符串从尾到头遍历，构建f二维数组
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                //如果t的第i个位置是a则f[i][0]=i否则等于f[i+1][0]
                if (t.charAt(i) == j + 'a')
                    f[i][j] = i;
                else
                    f[i][j] = f[i + 1][j];
            }
        }
        int add = 0;
        //依次检查s中的所有字符
        for (int i = 0; i < n; i++) {
            //在t的add位置以及之后位置多没有出现s.charat(i)
            if (f[add][s.charAt(i) - 'a'] == m) {
                return false;
            }
            add = f[add][s.charAt(i) - 'a'] + 1;
        }
        return true;
    }
}

