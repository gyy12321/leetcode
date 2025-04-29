import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main3 {

    //主要的类iasnfklanl、
    static final class DSUAFngvtu {
        int[] parent, size, edgeSize;
        int n, setCount;

        DSUAFngvtu(int n) {
            this.n = n;
            parent   = new int[n];
            size     = new int[n];
            edgeSize = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i]   = 1;
            }
            setCount = n;
        }

        int find(int x) {
            int root = x;
            while (parent[root] != root) root = parent[root];
            while (x != root) {
                int tmp = parent[x];
                parent[x] = root;
                x = tmp;
            }
            return root;
        }

        boolean union(int x, int y) {
            x = find(x);
            y = find(y);
            if (x == y) {               // 同集合只记录多出的一条边
                edgeSize[y]++;
                return false;
            }
            parent[x] = y;
            size[y]     += size[x];
            edgeSize[y] += edgeSize[x] + 1;
            setCount--;
            return true;
        }
    }

    static List<Integer>[] G;     // 邻接表 1‑indexed
    static long[][] dp;           // dp[v][0|1|2]
    static int bb;

    static void dfs(int x, int fa) {
        dp[x][0] = 1;
        dp[x][1] = Long.MAX_VALUE / 4;   // “无穷大”初值
        dp[x][2] = 0;

        long sum = 0;
        int childCnt = 0;

        for (int y : G[x]) {
            if (y == fa) continue;
            childCnt++;
            dfs(y, x);

            dp[x][0] += Math.min(dp[y][0], Math.min(dp[y][1], dp[y][2]));
            sum      += Math.min(dp[y][0], dp[y][1]);
            dp[x][2] += dp[y][1];
        }

        if (childCnt == 0 && x != 1) return;

        for (int y : G[x]) {
            if (y == fa) continue;
            dp[x][1] = Math.min(dp[x][1],
                                dp[y][0] + sum - Math.min(dp[y][0], dp[y][1]));
        }
    }

    public static void main(String[] args) throws IOException {
        //ASdasflll
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bb = Integer.parseInt(br.readLine().trim());

        //asf;kakl;smfl;asm;flmasl;mfl;asml;f
        G  = new ArrayList[bb + 1];
        dp = new long[bb + 1][3];
        for (int i = 1; i <= bb; i++) G[i] = new ArrayList<>();

        //asflkmnmaskfjopasjfopasjopfmasf
        for (int i = 0; i < bb - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            //主要代码部分
            G[a].add(b);
            G[b].add(a);
        }

        //pojwei0
        //asdfaspiofj
        dfs(1, 0);
        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }

}