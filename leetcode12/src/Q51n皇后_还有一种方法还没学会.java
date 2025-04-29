import java.util.ArrayList;
import java.util.List;

public class Q51n皇后_还有一种方法还没学会 {
    public static void main(String[] args) {
        System.out.println(new Q51n皇后_还有一种方法还没学会().solveNQueens(15));
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res=new ArrayList<>();
        List<String> list=new ArrayList<>();
        boolean[][] queen=new boolean[n][n];

        String[] s=new String[n];
        String tmp="";
        StringBuilder stringBuilder;
        for (int i = 0; i < n; i++) {
            tmp+=".";
        }
        for (int i = 0; i < n; i++) {
            stringBuilder= new StringBuilder(tmp);
            stringBuilder.setCharAt(i,'Q');
            s[i]=stringBuilder.toString();
        }

        dfs(0,n,res,list,queen,s);
        return res;
    }
    public void dfs(int line,int n,List<List<String>> res,List<String> list,boolean[][] queen,String[] s){
        if(line==n){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < n; i++) {
            if(isValid(queen,line,i)){
                queen[line][i]=true;
                list.add(s[i]);
                dfs(line+1,n,res,list,queen,s);
                list.remove(list.size()-1);
                queen[line][i]=false;
            }
        }
    }

    public boolean isValid(boolean[][] queen,int x,int y){
        //列
        for (int i = 0; i < x; i++) {
            if(queen[i][y])
                return false;
        }
        //左上，右下是空的，不用判定
        int x1=x,y1=y;
        while (y1-1>=0&&x1-1>=0){
            y1--;x1--;
            if(queen[x1][y1])
                return false;
        }
        //右上，左下也是空的，不需要判定
        int x2=x,y2=y;
        while (y2+1<queen.length&&x2-1>=0){
            y2++;x2--;
            if(queen[x2][y2])
                return false;
        }
        return true;
    }
}
