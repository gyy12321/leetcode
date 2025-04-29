import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q131分割回文串_答案1 {

    boolean[][] f;
    List<List<String>> ret = new ArrayList<List<String>>();
    List<String> ans = new ArrayList<String>();
    int n;

    public static void main(String[] args) {
        System.out.println(new Q131分割回文串_答案1().partition("cbbbcc"));
    }

    public List<List<String>> partition(String s) {
        n = s.length();
        f = new boolean[n][n];
        //官方写法少一个for循环
//        for (int i = 0; i < n; ++i) {
        //得益于这一步，f[3][2]也是true，为长度为2的子串的判定带来方便
//            Arrays.fill(f[i], true);
//        }
//
        //方向是从后往前
//        for (int i = n - 1; i >= 0; --i) {
//            for (int j = i + 1; j < n; ++j) {
//                f[i][j] = (s.charAt(i) == s.charAt(j)) && f[i + 1][j - 1];
//            }
//        }

        for (int i = 0; i < n; i++) {
            Arrays.fill(f[i], true);
        }
        for(int i=0;i<n-1;i++){
            if(s.charAt(i)==s.charAt(i+1))
                f[i][i+1]=true;
        }
        //i是步子大小，j是起始点,千万别搞错了
        for(int i=2;i<n;i++){
            for(int j=0;j+i<n;j++){
                f[j][i+j]=(s.charAt(j)==s.charAt(i+j))&&f[j+1][i+j-1];
            }
        }
        dfs(s, 0);
        return ret;
    }

    public void dfs(String s, int i) {
        if(i==n){
            ret.add(new ArrayList<>(ans));
            return;
        }
        for(int j=i;j<n;++j){
            if(f[i][j]){
                ans.add(s.substring(i,j+1));
                dfs(s,j+1);
                ans.remove(ans.size()-1);
            }
        }
    }
}
