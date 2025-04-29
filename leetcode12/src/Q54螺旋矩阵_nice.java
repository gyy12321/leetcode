import java.util.ArrayList;
import java.util.List;

public class Q54螺旋矩阵_nice {
    public static void main(String[] args) {
        System.out.println(spiralOrder2(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}}));
    }
    public static List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int stepDownAndUp=m;
        int stepLeftAndRight=n;
        int count=0;
        List<Integer> list=new ArrayList<>();
        //第一行先进去
        for (int i = 0; i < n; i++) {
            list.add(matrix[0][i]);
        }
        int x=0;
        int y=n-1;
        while (true){
            count++;
            if(count%4==1){
                if(stepDownAndUp-1==0)
                    break;
                else {
                    stepDownAndUp--;
                    for (int i = 0; i < stepDownAndUp; i++) {
                        x++;
                        list.add(matrix[x][y]);
                    }
                }
            }
            else if(count%4==2){
                if(stepLeftAndRight-1==0)
                    break;
                else {
                    stepLeftAndRight--;
                    for (int i = 0; i < stepLeftAndRight; i++) {
                        y--;
                        list.add(matrix[x][y]);
                    }
                }
            }
            else if(count%4==3){
                if(stepDownAndUp-1==0)
                    break;
                else {
                    stepDownAndUp--;
                    for (int i = 0; i < stepDownAndUp; i++) {
                        x--;
                        list.add(matrix[x][y]);
                    }
                }
            }
            else {
                if(stepLeftAndRight-1==0)
                    break;
                else {
                    stepLeftAndRight--;
                    for (int i = 0; i < stepLeftAndRight; i++) {
                        y++;
                        list.add(matrix[x][y]);
                    }
                }
            }
        }
        return list;
    }

    //自我简化
    //和官方的解法一的思路大致相似good
    public static List<Integer> spiralOrder1(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int stepDownAndUp=m;
        int stepLeftAndRight=n+1;

        List<Integer> list=new ArrayList<>();
        int x=0;
        int y=-1;
        while (true){
            if(stepLeftAndRight-1==0)
                break;
            else {
                //左上到右上可以走stepLeftAndRight步
                stepLeftAndRight--;
                for (int i = 0; i < stepLeftAndRight; i++) {
                    y++;
                    list.add(matrix[x][y]);
                }
            }
            //右上到右下
            if(stepDownAndUp-1==0)
                break;
            else {
                stepDownAndUp--;
                for (int i = 0; i < stepDownAndUp; i++) {
                    x++;
                    list.add(matrix[x][y]);
                }
            }
            //
            if(stepLeftAndRight-1==0)
                break;
            else {
                stepLeftAndRight--;
                for (int i = 0; i < stepLeftAndRight; i++) {
                    y--;
                    list.add(matrix[x][y]);
                }
            }
            //
            if(stepDownAndUp-1==0)
                break;
            else {
                stepDownAndUp--;
                for (int i = 0; i < stepDownAndUp; i++) {
                    x--;
                    list.add(matrix[x][y]);
                }
            }
        }
        return list;
    }

    //模拟官解法
    //和官方的解法2差不多
    public static List<Integer> spiralOrder2(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int top=0;
        int left=0;
        int down=m;
        int right=n;
        List<Integer> res=new ArrayList<>();
        while (left<right&&top<down){
            for(int i=left;i<right;++i){
                res.add(matrix[top][i]);
            }
            ++top;
            if(top==down)
                break;

            for(int i=top;i<down;++i){
                res.add(matrix[i][right-1]);
            }
            --right;
            if(right==left)
                break;

            for(int i=right-1;i>=left;--i){
                res.add(matrix[down-1][i]);
            }
            --down;
            if(top==down)
                break;

            for(int i=down-1;i>=top;--i){
                res.add(matrix[i][left]);
            }
            ++left;
            if(right==left)
                break;
        }
        return res;
    }
}

//官解1，模拟
class Solution54_1 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> order = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return order;
        }
        int rows = matrix.length, columns = matrix[0].length;
        boolean[][] visited = new boolean[rows][columns];
        int total = rows * columns;
        int row = 0, column = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directionIndex = 0;
        for (int i = 0; i < total; i++) {
            order.add(matrix[row][column]);
            visited[row][column] = true;
            int nextRow = row + directions[directionIndex][0], nextColumn = column + directions[directionIndex][1];
            if (nextRow < 0 || nextRow >= rows || nextColumn < 0 || nextColumn >= columns || visited[nextRow][nextColumn]) {
                directionIndex = (directionIndex + 1) % 4;
            }
            row += directions[directionIndex][0];
            column += directions[directionIndex][1];
        }
        return order;
    }
}

//官解2按层模拟good
class Solution54_2 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> order = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return order;
        }
        int rows = matrix.length, columns = matrix[0].length;
        int left = 0, right = columns - 1, top = 0, bottom = rows - 1;
        while (left <= right && top <= bottom) {
            for (int column = left; column <= right; column++) {
                order.add(matrix[top][column]);
            }
            for (int row = top + 1; row <= bottom; row++) {
                order.add(matrix[row][right]);
            }
            if (left < right && top < bottom) {
                for (int column = right - 1; column > left; column--) {
                    order.add(matrix[bottom][column]);
                }
                for (int row = bottom; row > top; row--) {
                    order.add(matrix[row][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return order;
    }
}


