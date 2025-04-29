
//三种方法：辅助数组，一圈一圈转，两次翻转
public class Q48旋转图像_ {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        rotate1(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
    //有多个答案，之后可以再看看

    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        //控制那一圈
        for(int i=n;i>1;i-=2){
            //每一圈中的每一组各自转各自的
            for(int j=0;j<=i-2;j++){
                int x=(n-i)/2;
                int y=(n-i)/2+j;
                int temp=matrix[x][y];
                int times=4;
                //转一组,共四次
                while (times>0){
                    int xNew=y;int yNew=n-1-x;
                    int temp1=matrix[xNew][yNew];
                    matrix[xNew][yNew]=temp;
                    temp=temp1;
                    x=xNew;y=yNew;
                    times--;
                }
            }
        }
    }
    //good溜达虎的方法和官方答案相似，但代码更好理解
    public static void rotate1(int[][] matrix) {
        int n = matrix.length;
        int left=0,top=0;
        int right=n-1,down=n-1;
        while (left<right){
            for(int i=0;i<right-left;++i){
                int topLeft=matrix[top][left+i];
                matrix[top][left+i]=matrix[down-i][left];
                matrix[down-i][left]=matrix[down][right-i];
                matrix[down][right-i]=matrix[top+i][right];
                matrix[top+i][right]=topLeft;
            }
            left++;
            right--;
            top=left;
            down=right;
        }
    }

}
