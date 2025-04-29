import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q5最长回文子串 {
    public static void main(String[] args) {

    }


    //我的传统写法
    public static String longestPalindrome1(String s) {
        int length = s.length();
        boolean[][] isPalindrome = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            isPalindrome[i][i]=true;
        }
        for (int i = 0; i < length-1; i++) {
            if(s.charAt(i)==s.charAt(i+1))
                isPalindrome[i][i+1]=true;
        }
        for (int step = 2; step < length; step++) {
            for (int i = 0; i+step< length; i++) {
                if(isPalindrome[i+1][i+step-1]&&s.charAt(i)==s.charAt(i+step))
                    isPalindrome[i][i+step]=true;
            }
        }
        String result=s.substring(0,1);
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                if(isPalindrome[i][j]&&j-i+1>result.length())
                    result=s.substring(i,j+1);
            }
        }
        return  result;
    }

    //更简洁写法,但效率不太高
    public static String longestPalindrome2(String s) {
        int length = s.length();
        boolean[][] isPalindrome = new boolean[length][length];
        String result=s.substring(0,1);
        for (int i = 0; i < length; ++i) {
            //例如isPalindrome[3][2]=true; 为长度为2时提供方便
            Arrays.fill(isPalindrome[i], true);
        }
        //答案特殊的遍历方式
        for (int i = length - 1; i >= 0; --i) {
            for (int j = i + 1; j < length; ++j) {
                isPalindrome[i][j] = (s.charAt(i) == s.charAt(j)) && isPalindrome[i + 1][j - 1];
                //更新最长回文串
                if(isPalindrome[i][j]&&j-i+1>result.length())
                    result=s.substring(i,j+1);
            }
        }
        return  result;
    }

    //不知道哪里来的写法，错误写法
    public static String longestPalindrome3(String s) {
        String longestString=s.charAt(0)+"";
        for (int i = 0; i < s.length(); i++) {
            int lr=1;
            String temp;
            while (true){
                if(i-lr<0||i+lr>s.length()-1)
                    break;
                if(s.charAt(i-lr)==s.charAt(i+lr))
                    lr++;
                else
                    break;
            }
            temp=s.substring(i-lr+1,i+lr);
            if(temp.length()>longestString.length())
                longestString=temp;
        }
        return longestString;
    }
}

//动态规划
class Solution5_1 {

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;
        // dp[i][j] 表示 s[i..j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        // 初始化：所有长度为 1 的子串都是回文串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();
        // 递推开始
        // 先枚举子串长度
        for (int L = 2; L <= len; L++) {
            // 枚举左边界，左边界的上限设置可以宽松一些
            for (int i = 0; i < len; i++) {
                // 由 L 和 i 可以确定右边界，即 j - i + 1 = L 得
                int j = L + i - 1;
                // 如果右边界越界，就可以退出当前循环
                if (j >= len) {
                    break;
                }

                //i，j表示左右端
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 只要 dp[i][j] == true 成立，就表示子串 s[i..j] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
}

//中心拓展法，效率较高
class Solution5_2 {
    public String longestPalindrome(String s) {

        if (s == null || s.length() < 1) {
            return "";
        }
        // 记录回文子串的起始位置和结束位置（包含）
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            //长度为奇数
            int len1 = expandAroundCenter(s, i, i);
            //长度为偶数
            int len2 = expandAroundCenter(s, i, i + 1);
            //取出最大长度
            int len = Math.max(len1, len2);
            //更新最大长度对应的起点和终点，我这儿另外加了一个1
            if (len > end - start+1) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return right - left - 1;
    }
}

//中心拓展法，效率较高,将标准答案的begin end 改为begin和maxLen
class Solution5_2_ {
    public String longestPalindrome(String s) {

        if (s == null || s.length() < 1) {
            return "";
        }
        // 记录回文子串的起始位置和结束位置（包含）
        int start = 0;
        int maxLen=1;
        for (int i = 0; i < s.length(); i++) {
            //长度为奇数
            int len1 = expandAroundCenter(s, i, i);
            //长度为偶数
            int len2 = expandAroundCenter(s, i, i + 1);
            //取出最大长度
            int len = Math.max(len1, len2);
            //更新最大长度对应的起点和终点，我这儿另外加了一个1
            if (len > maxLen) {
                start = i - (len - 1) / 2;
                maxLen=len;
            }
        }
        return s.substring(start,start+maxLen);
    }

    public int expandAroundCenter(String s, int left, int right) {
        //核心算法
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return right - left - 1;
    }
}

//某种看不懂的奇怪算法
class Solution5_3 {
    public String longestPalindrome(String s) {
        int start = 0, end = -1;
        StringBuffer t = new StringBuffer("#");
        for (int i = 0; i < s.length(); ++i) {
            t.append(s.charAt(i));
            t.append('#');
        }
        t.append('#');
        s = t.toString();

        List<Integer> arm_len = new ArrayList<Integer>();
        int right = -1, j = -1;
        for (int i = 0; i < s.length(); ++i) {
            int cur_arm_len;
            if (right >= i) {
                int i_sym = j * 2 - i;
                int min_arm_len = Math.min(arm_len.get(i_sym), right - i);
                cur_arm_len = expand(s, i - min_arm_len, i + min_arm_len);
            } else {
                cur_arm_len = expand(s, i, i);
            }
            arm_len.add(cur_arm_len);
            if (i + cur_arm_len > right) {
                j = i;
                right = i + cur_arm_len;
            }
            if (cur_arm_len * 2 + 1 > end - start) {
                start = i - cur_arm_len;
                end = i + cur_arm_len;
            }
        }

        StringBuffer ans = new StringBuffer();
        for (int i = start; i <= end; ++i) {
            if (s.charAt(i) != '#') {
                ans.append(s.charAt(i));
            }
        }
        return ans.toString();
    }

    public int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return (right - left - 2) / 2;
    }
}

