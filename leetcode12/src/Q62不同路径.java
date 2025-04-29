public class Q62不同路径 {
    public static void main(String[] args) {
        System.out.println(uniquePaths(7,3));
    }
    public static int uniquePaths(int m, int n) {
        int[][] ways=new int[m][n];
        for (int i = 0; i < m; i++) {
            ways[i][0]=1;
        }
        for (int i = 0; i < n; i++) {
            ways[0][i]=1;
        }
        //一行一行遍历
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                //关键点：从左上角到当前位置的路径数等于从左上角到当前位置上方的路径数和从左上角到当前位置左边的路径数之和
                ways[i][j]=ways[i-1][j]+ways[i][j-1];
            }
        }
        //返回右下角的路径数
        return ways[m-1][n-1];
    }
}
