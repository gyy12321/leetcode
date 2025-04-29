public class Q240搜索二维矩阵II {
    public static void main(String[] args) {
        
    }
    //暴力求解
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j]==target)
                    return true;
            }
        }
        return false;
    }
    //每一行都二叉搜索
    public boolean searchMatrix1(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            if(target<matrix[i][0])
                break;
            if(target>matrix[i][n-1])
                continue;
            int left=0,right=n-1,middle;
            while (left<=right){
                middle=(left+right)/2;
                if(matrix[i][middle]==target)
                    return true;
                else if(matrix[i][middle]>target){
                    right=middle-1;
                }
                else {
                    left=middle+1;
                }
            }
        }
        return false;
    }
    //最好的z型搜索，往下往左一步步走
    public boolean searchMatrix2(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int x=0,y=n-1;
        while (x<m&&y>=0){
            if(matrix[x][y]==target)
                return true;
            else if (matrix[x][y]>target){
                y--;
            }
            else {
                x++;
            }
        }
        return false;
    }
}
