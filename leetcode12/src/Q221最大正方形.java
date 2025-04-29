public class Q221最大正方形 {
    public static void main(String[] args) {

    }
    public int maximalSquare(char[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int[][] max=new int[m][n];
        int result=0;
        for (int i = 0; i < n; i++) {
            if(matrix[0][i]=='1')
                max[0][i]=1;
            if(max[0][i]>result)
                result=max[0][i];
        }
        for (int i = 0; i < m; i++) {
            if(matrix[i][0]=='1')
                max[i][0]=1;
            if(max[i][0]>result)
                result=max[i][0];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(matrix[i][j]=='1'){
                    int lu=max[i-1][j-1];
                    int l=max[i-1][j];
                    int u=max[i][j-1];
                    int tempMin=Math.min(Math.min(lu,l),u);
                    max[i][j]=tempMin+1;
                }
                if(max[i][j]>result)
                    result=max[i][j];
            }
        }
        return result*result;
    }
}
