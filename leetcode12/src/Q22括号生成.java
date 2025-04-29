import java.util.ArrayList;
import java.util.List;

public class Q22括号生成 {

    public static void main(String[] args) {
        System.out.println(new Q22括号生成().generateParenthesis(3));
    }
    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();
        dfs(0,0,n,new StringBuilder(),res);
        return res;
    }

    //自己写的，分类情况稍微多了些，这道题主要难点在于如何分类
    public void dfs(int l,int r,int n,StringBuilder s,List<String> res){
        if(r==n){
            res.add(new String(s));
            return;
        }
        if(l==r){
            s.append('(');
            dfs(l+1,r,n,s,res);
            s.deleteCharAt(s.length()-1);
        }
        else if(l==n){
            s.append(')');
            dfs(l,r+1,n,s,res);
            s.deleteCharAt(s.length()-1);
        }
        else {
            s.append('(');
            dfs(l+1,r,n,s,res);
            s.deleteCharAt(s.length()-1);

            s.append(')');
            dfs(l,r+1,n,s,res);
            s.deleteCharAt(s.length()-1);
        }
    }

    //用stringbuilder效率更高
    //官方解法
//    public void dfs(int l,int r,int n,StringBuffer s,List<String> res){
//        if(r==n){
//            res.add(new String(s));
//            return;
//        }
//        要么加左括号要么加右括号，但加这两种都有条件限制
//        if(l<n){
//            s.append('(');
//            dfs(l+1,r,n,s,res);
//            s.deleteCharAt(s.length()-1);
//        }
//        if(r<l) {
//            s.append(')');
//            dfs(l,r+1,n,s,res);
//            s.deleteCharAt(s.length()-1);
//        }
//    }
}
