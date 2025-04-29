public class Q97交错字符串 {

    //答案基础上做修改，更好理解，虽然代码变多了
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length(), m = s2.length(), t = s3.length();

        if (n + m != t) {
            return false;
        }

        boolean[][] f = new boolean[n + 1][m + 1];

        f[0][0] = true;
        //多维动态规划先初始化行和列
        for (int i = 1; i <= n; i++) {
            if(s1.charAt(i-1)==s3.charAt(i-1))
                f[i][0]=true;
            else
                break;
        }
        for (int i = 1; i <= m; i++) {
            if(s2.charAt(i-1)==s3.charAt(i-1))
                f[0][i]=true;
            else
                break;
        }
        //f[i][j]是s1的前i个以及s2的前j个能不能组成前i+j个的s3
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= m; ++j) {
                int p = i + j - 1;
                //重要逻辑
                f[i][j] = (f[i - 1][j] && s1.charAt(i - 1) == s3.charAt(p))
                        ||(f[i][j - 1] && s2.charAt(j - 1) == s3.charAt(p));
            }
        }
        return f[n][m];
    }

}

class Solution97_1 {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length(), m = s2.length(), t = s3.length();

        if (n + m != t) {
            return false;
        }

        boolean[][] f = new boolean[n + 1][m + 1];

        f[0][0] = true;
        for (int i = 0; i <= n; ++i) {
            for (int j = 0; j <= m; ++j) {
                int p = i + j - 1;
                if (i > 0) {
                    f[i][j] = f[i][j] || (f[i - 1][j] && s1.charAt(i - 1) == s3.charAt(p));
                }
                if (j > 0) {
                    f[i][j] = f[i][j] || (f[i][j - 1] && s2.charAt(j - 1) == s3.charAt(p));
                }
            }
        }

        return f[n][m];
    }
}

//空间优化，没看
class Solution97_2 {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length(), m = s2.length(), t = s3.length();

        if (n + m != t) {
            return false;
        }

        boolean[] f = new boolean[m + 1];

        f[0] = true;
        for (int i = 0; i <= n; ++i) {
            for (int j = 0; j <= m; ++j) {
                int p = i + j - 1;
                if (i > 0) {
                    f[j] = f[j] && s1.charAt(i - 1) == s3.charAt(p);
                }
                if (j > 0) {
                    f[j] = f[j] || (f[j - 1] && s2.charAt(j - 1) == s3.charAt(p));
                }
            }
        }

        return f[m];
    }
}



