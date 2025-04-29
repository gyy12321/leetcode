import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q73矩阵置零 {
    public static void main(String[] args) {

    }
//    public void setZeroes(int[][] matrix) {
//        int m = matrix.length;
//        int n = matrix[0].length;
//        boolean[] visitedRows=new boolean[n];
//        int[][] res=new int[m][n];
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                res[i][j]=matrix[i][j];
//            }
//        }
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if(matrix[i][j]==0)
//                    setHelp(res,i,j);
//            }
//        }
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                matrix[i][j]=res[i][j];
//            }
//        }
//    }
//    public void setHelp(int[][] matrix,int x,int y){
//        int m = matrix.length;
//        int n = matrix[0].length;
//        for (int i = 0; i < m; i++) {
//            matrix[i][y]=0;
//        }
//        for (int i = 0; i < n; i++) {
//            matrix[x][i]=0;
//        }
//    }


    //第二个方法效率依然不高
//    public void setZeroes(int[][] matrix) {
//        int m = matrix.length;
//        int n = matrix[0].length;
//        Set<Integer> rows=new HashSet<>();
//        Set<Integer> columns=new HashSet<>();
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if(matrix[i][j]==0){
//                    rows.add(i);
//                    columns.add(j);
//                }
//            }
//        }
//        for (Integer row : rows) {
//            setHelpRows(matrix,row);
//        }
//        for (Integer column : columns) {
//            setHelpColumns(matrix,column);
//        }
//    }
//    public void setHelpRows(int[][] matrix,int a){
//        int n = matrix[0].length;
//        for (int i = 0; i < n; i++) {
//            matrix[a][i]=0;
//        }
//    }
//    public void setHelpColumns(int[][] matrix,int a){
//        int m = matrix.length;
//        for (int i = 0; i < m; i++) {
//            matrix[i][a]=0;
//        }
//    }

    //good，大部分人的方法官方第一种解法，简单但却自己没想到 空间O(m+n)
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = col[j] = true;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }

    }

    //good good方法二使用两个标记变量,空间更优为O(1),能看懂，重点掌握
    public void setZeroes1(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean row0=false;
        boolean column0=false;
        for (int i = 0; i < n; i++) {
            if(matrix[0][i]==0){
                row0=true;
                break;
            }
        }
        for (int i = 0; i < m; i++) {
            if(matrix[i][0]==0){
                column0=true;
                break;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(matrix[i][j]==0){
                    matrix[i][0]=matrix[0][j]=0;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(matrix[i][0]==0||matrix[0][j]==0){
                    matrix[i][j]=0;
                }
            }
        }
        if(column0){
            for (int i = 0; i < m; i++) {
                matrix[i][0]=0;
            }
        }
        if(row0){
            for (int i = 0; i < n; i++) {
                matrix[0][i]=0;
            }
        }

    }
    //方法三太复杂，暂时不看了
//    class Solution {
//        public void setZeroes(int[][] matrix) {
//            int m = matrix.length, n = matrix[0].length;
//            boolean flagCol0 = false;
//            for (int i = 0; i < m; i++) {
//                if (matrix[i][0] == 0) {
//                    flagCol0 = true;
//                }
//                for (int j = 1; j < n; j++) {
//                    if (matrix[i][j] == 0) {
//                        matrix[i][0] = matrix[0][j] = 0;
//                    }
//                }
//            }
//            for (int i = m - 1; i >= 0; i--) {
//                for (int j = 1; j < n; j++) {
//                    if (matrix[i][0] == 0 || matrix[0][j] == 0) {
//                        matrix[i][j] = 0;
//                    }
//                }
//                if (flagCol0) {
//                    matrix[i][0] = 0;
//                }
//            }
//        }
//    }



}
