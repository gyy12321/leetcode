import java.util.LinkedList;
import java.util.Queue;

public class Q200岛屿数量_并查集方法先不做 {
//    //广度优先效率较低
//    public int numIslands(char[][] grid) {
//        int island=0;
//        int m=grid.length;//行
//        int n=grid[0].length;//列
//        Deque<Integer> queue=new LinkedList<>();
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if(grid[i][j]=='1'){
//                    /   queue.addLast(i*n+j);
//                    grid[i][j]=0;
//                    while (!queue.isEmpty()){
//                        int temp = queue.removeFirst();
//                        int x=temp/n;
//                        int y=temp%n;
//                        //上
//                        if(x-1>=0&&grid[x-1][y]=='1'){
//                            queue.addLast((x-1)*n+y);
//                            grid[x-1][y]='0';
//                        }
//                        //右
//                        if(y+1<=n-1&&grid[x][y+1]=='1'){
//                            queue.addLast(x*n+y+1);
//                            grid[x][y+1]='0';
//                        }
//                        //下
//                        if(x+1<=m-1&&grid[x+1][y]=='1'){
//                            queue.addLast((x+1)*n+y);
//                            grid[x+1][y]='0';
//                        }
//                        //左
//                        if(y-1>=0&&grid[x][y-1]=='1'){
//                            queue.addLast(x*n+y-1);
//                            grid[x][y-1]='0';
//                        }
//
//                    }
//                    island++;
//                }
//            }
//        }
//        return island;
//    }


    //并查集方法先不做
}

//深度优先效率较高
class Solution200_1{

    public void dfs(char[][] grid,int x,int y){
        //边界判断,0表示是水或者访问过变成水了
        if(x<0||y<0||x>=grid.length||y>=grid[0].length||grid[x][y]=='0')
            return;
        //访问过了置0
        grid[x][y]='0';
        //四个方向走
        dfs(grid,x,y+1);
        dfs(grid,x+1,y);
        dfs(grid,x,y-1);
        dfs(grid,x-1,y);
    }
    public int numIslands(char[][] grid) {
        if(grid==null||grid.length==0)
            return 0;
        int island=0;
        int m=grid.length;//行
        int n=grid[0].length;//列
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //当前位置是陆地且没访问过，则将与它相连的整个岛屿都访问一遍，且访问过后将1置0变成水域
                if(grid[i][j]=='1'){
                    //岛屿数加1
                    island++;
                    dfs(grid,i,j);
                }
            }
        }
        return island;
    }
}

//广度优先效率稍微低一些
class Solution200_2 {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;

        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    // 岛屿数加1
                    ++num_islands;
                    grid[r][c] = '0';
                    Queue<Integer> neighbors = new LinkedList<>();
                    //不存入行和列而是存入算出来的位置序号
                    neighbors.add(r * nc + c);
                    while (!neighbors.isEmpty()) {
                        int id = neighbors.remove();
                        //获取当前位置
                        int row = id / nc;
                        int col = id % nc;
                        //上下左右
                        if (row - 1 >= 0 && grid[row-1][col] == '1') {
                            neighbors.add((row-1) * nc + col);
                            grid[row-1][col] = '0';
                        }
                        if (row + 1 < nr && grid[row+1][col] == '1') {
                            neighbors.add((row+1) * nc + col);
                            grid[row+1][col] = '0';
                        }
                        if (col - 1 >= 0 && grid[row][col-1] == '1') {
                            neighbors.add(row * nc + col-1);
                            grid[row][col-1] = '0';
                        }
                        if (col + 1 < nc && grid[row][col+1] == '1') {
                            neighbors.add(row * nc + col+1);
                            grid[row][col+1] = '0';
                        }
                    }
                }
            }
        }

        return num_islands;
    }
}
//并查集解法，先不学吧
class Solution200_3 {
    class UnionFind {
        int count;
        int[] parent;
        int[] rank;

        public UnionFind(char[][] grid) {
            count = 0;
            int m = grid.length;
            int n = grid[0].length;
            parent = new int[m * n];
            rank = new int[m * n];
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (grid[i][j] == '1') {
                        parent[i * n + j] = i * n + j;
                        ++count;
                    }
                    rank[i * n + j] = 0;
                }
            }
        }

        public int find(int i) {
            if (parent[i] != i) parent[i] = find(parent[i]);
            return parent[i];
        }

        public void union(int x, int y) {
            int rootx = find(x);
            int rooty = find(y);
            if (rootx != rooty) {
                if (rank[rootx] > rank[rooty]) {
                    parent[rooty] = rootx;
                } else if (rank[rootx] < rank[rooty]) {
                    parent[rootx] = rooty;
                } else {
                    parent[rooty] = rootx;
                    rank[rootx] += 1;
                }
                --count;
            }
        }

        public int getCount() {
            return count;
        }
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;
        UnionFind uf = new UnionFind(grid);
        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    grid[r][c] = '0';
                    if (r - 1 >= 0 && grid[r-1][c] == '1') {
                        uf.union(r * nc + c, (r-1) * nc + c);
                    }
                    if (r + 1 < nr && grid[r+1][c] == '1') {
                        uf.union(r * nc + c, (r+1) * nc + c);
                    }
                    if (c - 1 >= 0 && grid[r][c-1] == '1') {
                        uf.union(r * nc + c, r * nc + c - 1);
                    }
                    if (c + 1 < nc && grid[r][c+1] == '1') {
                        uf.union(r * nc + c, r * nc + c + 1);
                    }
                }
            }
        }

        return uf.getCount();
    }
}
