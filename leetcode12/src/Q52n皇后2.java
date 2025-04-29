import java.util.ArrayList;
import java.util.List;

public class Q52n皇后2 {
    int result=0;
    public static void main(String[] args) {
        System.out.println(new Q52n皇后2().totalNQueens(5));
    }
    public int totalNQueens(int n) {
        boolean[][] queen=new boolean[n][n];

        dfs(0,n,queen);
        return result;
    }
    public void dfs(int line,int n,boolean[][] queen){
        if(line==n){
            result++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if(isValid(queen,line,i)){
                queen[line][i]=true;
                dfs(line+1,n,queen);
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
        //左上
        int x1=x,y1=y;
        while (y1-1>=0&&x1-1>=0){
            y1--;x1--;
            if(queen[x1][y1])
                return false;
        }
        //右上
        int x2=x,y2=y;
        while (y2+1<queen.length&&x2-1>=0){
            y2++;x2--;
            if(queen[x2][y2])
                return false;
        }
        return true;
    }
}
