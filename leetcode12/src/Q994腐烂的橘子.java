import java.util.*;

public class Q994腐烂的橘子 {
//    值 0 代表空单元格；
//    值 1 代表新鲜橘子；
//    值 2 代表腐烂的橘子。
    //还是我自己第一次写的好啊，第二次稍微差一些
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int rotten=0;int total=0;
        Deque<Integer> deque=new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j]==2){
                    rotten++;
                    total++;
                    deque.add(i*n+j);
                }
                if(grid[i][j]==1){
                    total++;
                }
            }
        }
        int minutes=0;
        //rotten==total=0或不为0，时间都是0，不需要while循环
        while (rotten<total){
            //startrotten判定经过这次腐烂有没有新增，没有的话就退出，返回-1，
            // 表示不可能完成腐烂任务。每次必然会新增腐烂（如果能腐烂完的话）
            int startRotten=rotten;
            int size = deque.size();
            //当前队列里的所有烂橘子都要在这一轮传染别人
            for (int i = 0; i < size; i++) {
                int remove = deque.remove();
                int x=remove/n;
                int y=remove%n;
                if(x-1>=0&&grid[x-1][y]==1){
                    deque.add((x-1)*n+y);
                    grid[x-1][y]=2;
                    rotten++;
                }
                //右
                if(y+1<=n-1&&grid[x][y+1]==1){
                    deque.add(x*n+y+1);
                    grid[x][y+1]=2;
                    rotten++;
                }
                //下
                if(x+1<=m-1&&grid[x+1][y]==1){
                    deque.add((x+1)*n+y);
                    grid[x+1][y]=2;
                    rotten++;
                }
                //左
                if(y-1>=0&&grid[x][y-1]==1){
                    deque.add(x*n+y-1);
                    grid[x][y-1]=2;
                    rotten++;
                }
            }
            //一轮结束
            //如果这一轮没有新增腐烂，就返回-1，表示不可能完成腐烂任务
            if(rotten==startRotten)
                return -1;
            minutes++;
            //rotten==total时候就不进行下一次循环了，此时队列里其实还有橘子，所以这种写法不是靠队列的size来判断是否退出循环
        }
        return minutes;
    }
}
//自己第二遍做，边界条件有些多，有点麻烦
class Solution994_02 {
    public int orangesRotting(int[][] grid) {
        int r=grid.length;
        int c=grid[0].length;
        int rotten=0;
        int oranges=0;
        int steps=0;
        Deque<Integer> deque=new LinkedList<>();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(grid[i][j]==1)
                    oranges++;
                else if(grid[i][j]==2){
                    oranges++;
                    rotten++;
                    //腐烂橘子入队
                    deque.add(i*c+j);
                }
            }
        }
        if(oranges==0)
            return 0;
        int num=deque.size();
        while (!deque.isEmpty()){
            int remove = deque.remove();
            int r1=remove/c;
            int c1=remove%c;
            //上
            if(r1-1>=0&&grid[r1-1][c1]==1){
                deque.add((r1-1)*c+c1);
                grid[r1-1][c1]=2;
                rotten++;
            }
            //右
            if(c1+1<=c-1&&grid[r1][c1+1]==1){
                deque.add(r1*c+c1+1);
                grid[r1][c1+1]=2;
                rotten++;
            }
            //下
            if(r1+1<=r-1&&grid[r1+1][c1]==1){
                deque.add((r1+1)*c+c1);
                grid[r1+1][c1]=2;
                rotten++;
            }
            //左
            if(c1-1>=0&&grid[r1][c1-1]==1){
                deque.add(r1*c+c1-1);
                grid[r1][c1-1]=2;
                rotten++;
            }

            //刚开始缺了这个关键逻辑，导致很多样例都错了，要考虑到很多橘子是同时在腐烂的，而不是循环一次腐烂一次
            num--;
            if(num==0){
                steps++;
                num=deque.size();
            }

        }
        if(rotten==oranges)
            return steps-1;
        else
            return -1;
    }
}
//修改自己第一遍做的
class Solution994_03 {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int rotten = 0;
        int total = 0;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    rotten++;
                    total++;
                    deque.add(i * n + j);
                }
                if (grid[i][j] == 1) {
                    total++;
                }
            }
        }
        int minutes = 0;
        if (total == 0)
            return 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            //感染一波
            for (int i = 0; i < size; i++) {
                int remove = deque.remove();
                int x = remove / n;
                int y = remove % n;
                if (x - 1 >= 0 && grid[x - 1][y] == 1) {
                    deque.add((x - 1) * n + y);
                    grid[x - 1][y] = 2;
                    rotten++;
                }
                //右
                if (y + 1 <= n - 1 && grid[x][y + 1] == 1) {
                    deque.add(x * n + y + 1);
                    grid[x][y + 1] = 2;
                    rotten++;
                }
                //下
                if (x + 1 <= m - 1 && grid[x + 1][y] == 1) {
                    deque.add((x + 1) * n + y);
                    grid[x + 1][y] = 2;
                    rotten++;
                }
                //左
                if (y - 1 >= 0 && grid[x][y - 1] == 1) {
                    deque.add(x * n + y - 1);
                    grid[x][y - 1] = 2;
                    rotten++;
                }

            }
            minutes++;
        }
        if (rotten == total)
            return minutes - 1;
        return -1;
    }
}

//官方解法和答辩似得，懒得看
class Solution994_1 {
    int[] dr = new int[]{-1, 0, 1, 0};
    int[] dc = new int[]{0, -1, 0, 1};

    public int orangesRotting(int[][] grid) {
        int R = grid.length, C = grid[0].length;
        Queue<Integer> queue = new ArrayDeque<Integer>();
        Map<Integer, Integer> depth = new HashMap<Integer, Integer>();
        for (int r = 0; r < R; ++r) {
            for (int c = 0; c < C; ++c) {
                if (grid[r][c] == 2) {
                    int code = r * C + c;
                    queue.add(code);
                    depth.put(code, 0);
                }
            }
        }
        int ans = 0;
        while (!queue.isEmpty()) {
            int code = queue.remove();
            int r = code / C, c = code % C;
            for (int k = 0; k < 4; ++k) {
                int nr = r + dr[k];
                int nc = c + dc[k];
                if (0 <= nr && nr < R && 0 <= nc && nc < C && grid[nr][nc] == 1) {
                    grid[nr][nc] = 2;
                    int ncode = nr * C + nc;
                    queue.add(ncode);
                    depth.put(ncode, depth.get(code) + 1);
                    ans = depth.get(ncode);
                }
            }
        }
        for (int[] row: grid) {
            for (int v: row) {
                if (v == 1) {
                    return -1;
                }
            }
        }
        return ans;
    }
}

