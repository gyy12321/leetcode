import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q139单词拆分 {
    public static void main(String[] args) {

    }
    //我第一次写的
    public static boolean wordBreak(String s, List<String> wordDict) {
        int length = s.length();
        //dp[i]表示0-i可以由单词字典组成
        boolean[] dp=new boolean[length];
        for (int i = 0; i < length; i++) {
            if(wordDict.contains(s.substring(0,i+1))){
                dp[i]=true;
                continue;
            }
            for (int j = 0; j < i; j++) {
                if(dp[j]&&wordDict.contains(s.substring(j+1,i+1))){
                    dp[i]=true;
                    break;
                }
            }
        }

        return dp[length-1];
    }
    //官方题解，但效率不佳
    public boolean wordBreak1(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            //这一个循环导致效率偏低
            for (int j = 0; j < i; j++) {
                //关键逻辑
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    //我第二次写的，70%
    public boolean wordBreak2(String s, List<String> wordDict) {
        int length = s.length();
        //dp[i]表示第0~i-1能否由字母组成
        boolean[] dp=new boolean[length+1];
        //长度为0的字符串肯定可以由单词组成
        dp[0]=true;
        for (int i = 1; i <= length; i++) {
            for (String word : wordDict) {
                int l = word.length();
                //关键逻辑
                if(l<=i&&dp[i-l]&&s.substring(i-l,i).equals(word))
                    dp[i]=true;
            }
        }
        return dp[length];
    }

}
