import java.util.ArrayList;
import java.util.List;

public class Q131分割回文串_自己尝试高效版 {
    public static void main(String[] args) {
        System.out.println(new Q131分割回文串_自己尝试高效版().partition("abbaca"));
    }
    public List<List<String>> partition(String s) {
        int length = s.length();
        boolean[][] isPalindrome=new boolean[length][length];
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

        List<List<String>> res=new ArrayList<>();
        List<String> list=new ArrayList<>();
        dfs(0,s,res,list,isPalindrome);
        return res;
    }
    public void dfs(int n,String s,List<List<String>> res,List<String> list,boolean[][] isPalindrome){
        if(n==s.length()){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i=n;i<s.length();i++){
            if(isPalindrome[n][i]){
                list.add(s.substring(n,i+1));
                dfs(i+1,s,res,list,isPalindrome);
                list.remove(list.size()-1);
            }
        }
    }
}
