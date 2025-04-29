import java.util.LinkedList;
import java.util.Queue;

public class Q130被围绕的区域 {
    public static void main(String[] args) {

    }
    int m;
    int n;
    //在外围走一圈，明确不能由O变X的所有点位
    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;
        //无需处理的特殊情况
        if(m<=2||n<=2)
            return;
        boolean[][] visited=new boolean[m][n];
        int i;
        int j;
        //正方形四条边依次处理
        i=0;
        for(j=0;j<=n-2;++j){
            process(i,j,visited,board);
        }
        j=n-1;
        for(i=0;i<=m-2;++i){
            process(i,j,visited,board);
        }
        i=m-1;
        for(j=n-1;j>=1;--j){
            process(i,j,visited,board);
        }
        j=0;
        for(i=m-1;i>=1;--i){
            process(i,j,visited,board);
        }


        //修改board矩阵，把能变X的都变为X
        for (int a = 1; a < m-1; a++) {
            for (int b = 1; b < n-1; b++) {
                if(!visited[a][b]&&board[a][b]=='O')
                    board[a][b]='X';
            }
        }
    }

    //深度优先搜索公式
    //探寻所有和board边缘的O点相连的O点块，visited标为true
    public void process(int i,int j,boolean[][] visited,char[][] board){
        if(i<0||j<0||i>=m||j>=n||board[i][j]=='X'||visited[i][j])
            return;
        //上右下左
        //深搜逻辑
        visited[i][j]=true;
        process(i-1,j,visited,board);
        process(i,j+1,visited,board);
        process(i+1,j,visited,board);
        process(i,j-1,visited,board);
    }
}
//题解一和我的思路基本相同，只不过用了巧妙方法，少用了visited数组
class Solution130_1 {
    int m, n;

    public void solve(char[][] board) {
        m = board.length;
        if (m == 0) {
            return;
        }
        n = board[0].length;
        for (int i = 0; i < m; i++) {
            dfs(board, i, 0);
            dfs(board, i, n - 1);
        }
        for (int i = 1; i < n - 1; i++) {
            dfs(board, 0, i);
            dfs(board, m - 1, i);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void dfs(char[][] board, int x, int y) {
        if (x < 0 || x >= m || y < 0 || y >= n || board[x][y] != 'O') {
            return;
        }
        board[x][y] = 'A';
        dfs(board, x + 1, y);
        dfs(board, x - 1, y);
        dfs(board, x, y + 1);
        dfs(board, x, y - 1);
    }
}

//广搜,没看
class Solution130_2 {
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    public void solve(char[][] board) {
        int m = board.length;
        if (m == 0) {
            return;
        }
        int n = board[0].length;
        Queue<int[]> queue = new LinkedList<int[]>();
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                queue.offer(new int[]{i, 0});
                board[i][0] = 'A';
            }
            if (board[i][n - 1] == 'O') {
                queue.offer(new int[]{i, n - 1});
                board[i][n - 1] = 'A';
            }
        }
        for (int i = 1; i < n - 1; i++) {
            if (board[0][i] == 'O') {
                queue.offer(new int[]{0, i});
                board[0][i] = 'A';
            }
            if (board[m - 1][i] == 'O') {
                queue.offer(new int[]{m - 1, i});
                board[m - 1][i] = 'A';
            }
        }
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];
            for (int i = 0; i < 4; i++) {
                int mx = x + dx[i], my = y + dy[i];
                if (mx < 0 || my < 0 || mx >= m || my >= n || board[mx][my] != 'O') {
                    continue;
                }
                queue.offer(new int[]{mx, my});
                board[mx][my] = 'A';
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
