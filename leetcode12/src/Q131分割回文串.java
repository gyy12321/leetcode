import java.util.ArrayList;
import java.util.List;

//和答案的主要区别在于判断是否是回文串的逻辑不一样
public class Q131分割回文串 {
    public static void main(String[] args) {
        System.out.println(new Q131分割回文串().partition("abbaca"));
    }
    public List<List<String>> partition(String s) {
        List<List<String>> res=new ArrayList<>();
        List<String> list=new ArrayList<>();
        dfs(0,s,res,list);
        return res;
    }
    public void dfs(int n,String s,List<List<String>> res,List<String> list){
        if(n==s.length()){
            res.add(new ArrayList<>(list));
            return;
        }
        //0~n-1都已经处理好了
        for(int i=n;i<s.length();i++){
            String substring = s.substring(n, i + 1);
            if(isHuiwen(substring)){
                list.add(substring);
                dfs(i+1,s,res,list);
                list.remove(list.size()-1);
            }
        }
    }
    public boolean isHuiwen(String s){
        return new StringBuilder(s).reverse().toString().equals(s);
    }
}
