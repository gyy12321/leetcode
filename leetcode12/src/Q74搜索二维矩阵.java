public class Q74搜索二维矩阵 {
    public static void main(String[] args) {
        boolean b = searchMatrix(new int[][]{{1, 2, 3,4}, { 5, 6,7,8}, {9,10,11,12}}, 2);
        System.out.println(b);
    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        int length = matrix.length;
        int l=0;
        int r=length-1;
        int m;
        while (l<=r){
            //改
            m=l+(r-l)/2;
            if(matrix[m][0]<target)
                l=m+1;
            else
                r=m-1;
        }
        if(l!=length&&matrix[l][0]==target)
            return true;
        if(l==0)
            return false;

        int row=l-1;
        length = matrix[0].length;
        l=0;
        r=length-1;

        while (l<=r){
            //改
            m=l+(r-l)/2;
            if(matrix[row][m]==target)
                return true;
            else if(matrix[row][m]<target)
                l=m+1;
            else
                r=m-1;
        }
        return false;
    }

    //一次二分搜索
//    public boolean searchMatrix(int[][] matrix, int target) {
//        int m = matrix.length, n = matrix[0].length;
//        int low = 0, high = m * n - 1;
//        while (low <= high) {
//            int mid = (high - low) / 2 + low;
//            int x = matrix[mid / n][mid % n];
//            if (x < target) {
//                low = mid + 1;
//            } else if (x > target) {
//                high = mid - 1;
//            } else {
//                return true;
//            }
//        }
//        return false;
//    }

}
