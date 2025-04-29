import java.util.HashSet;
import java.util.Set;

public class Q36有效的数独 {
    public static void main(String[] args) {

    }
    //41
    public boolean isValidSudoku(char[][] board) {
        //每一行检测
        for (int i = 0; i < 9; i++) {
            Set<Character> set=new HashSet<>();
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if(c!='.'){
                    if(set.contains(c))
                        return false;
                    set.add(c);
                }
            }
        }

        //每一列检测
        for (int i = 0; i < 9; i++) {
            Set<Character> set=new HashSet<>();
            for (int j = 0; j < 9; j++) {
                char c = board[j][i];
                if(c!='.'){
                    if(set.contains(c))
                        return false;
                    set.add(c);
                }
            }
        }

        for(int x=0;x<=6;x+=3){
            for(int y=0;y<=6;y+=3){
                //每一个小九宫格做一次检测
                Set<Character> set=new HashSet<>();
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        char c = board[x+i][y+j];
                        if(c!='.'){
                            if(set.contains(c))
                                return false;
                            set.add(c);
                        }
                    }
                }
            }
        }
        return true;
    }
}
//只需要一次遍历比较巧妙
class Solution36_1 {
    public boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][10];
        int[][] columns = new int[9][10];
        int[][][] subboxes = new int[3][3][10];
        //一次遍历
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                //里面存放了数字才需要处理
                if (c != '.') {
                    int index = c - '0';
                    //i行数字index的数量+1
                    rows[i][index]++;
                    //j列数字index数量+1
                    columns[j][index]++;
                    //小九宫格数字index数量+1
                    subboxes[i / 3][j / 3][index]++;
                    //任何一个数量超过1都不符合题意，返回false;
                    if (rows[i][index] > 1 || columns[j][index] > 1 || subboxes[i / 3][j / 3][index] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}

