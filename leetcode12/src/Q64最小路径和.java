public class Q64最小路径和 {
    public static void main(String[] args) {
        System.out.println(minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}}));
    }
    public static int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] ways=new int[m][n];
        ways[0][0]=grid[0][0];
        for (int i = 1; i < m; i++) {
            ways[i][0]=ways[i-1][0]+grid[i][0];
        }
        for (int i = 1; i < n; i++) {
            ways[0][i]=ways[0][i-1]+grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                ways[i][j]=Math.min(ways[i-1][j],ways[i][j-1])+grid[i][j];
            }
        }
        return ways[m-1][n-1];
    }
}
