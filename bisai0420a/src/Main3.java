import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

/**
 * 由 Python 版改写而来：
 *  - DSUAFngvtu：并查集（当前主流程未使用，但完整保留）
 *  - StringHashAWvpp：滚动字符串哈希（同样未在主流程使用，完整保留）
 *  - 树形 DP（dfs）部分：与原脚本一致
 * 最终输出：min(dp[1][0], dp[1][1])
 */
public class Main3 {

    /* ----------------- 并查集 ----------------- */
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

        /** @return true 若成功合并，false 表示本就在同一集合，仅递增边计数 */
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

    /* -------------- 字符串滚动哈希 -------------- */
    static final class StringHashAWvpp {
        private final long[] h, p;
        private static final long BASE = 131;
        private static final long MOD  = 10_000_000_000_000L;   // 10^13

        StringHashAWvpp(String s) {
            int n = s.length();
            h = new long[n + 1];
            p = new long[n + 1];
            p[0] = 1;
            for (int i = 1; i <= n; i++) {
                p[i] = (p[i - 1] * BASE) % MOD;
                h[i] = (h[i - 1] * BASE + s.charAt(i - 1)) % MOD;
            }
        }
        long getHashAJfmga(int l, int r) {             // [l, r)
            return (h[r] - h[l] * p[r - l] % MOD + MOD) % MOD;
        }
    }

    /* ----------------- 其他工具 ----------------- */
    static long gcdapplyZqzpf(long a, long b) {
        return b == 0 ? a : gcdapplyZqzpf(b, a % b);
    }

    /* ----------------- 树形 DP ----------------- */
    static List<Integer>[] G;     // 邻接表 1‑indexed
    static long[][] dp;           // dp[v][0|1|2]
    static int n;

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

        // 如果非根且为叶子节点，则直接返回（与原脚本保持一致）
        if (childCnt == 0 && x != 1) return;

        for (int y : G[x]) {
            if (y == fa) continue;
            dp[x][1] = Math.min(dp[x][1],
                                dp[y][0] + sum - Math.min(dp[y][0], dp[y][1]));
        }
    }

    /* ----------------- 主流程 ----------------- */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine().trim());

        G  = new ArrayList[n + 1];
        dp = new long[n + 1][3];
        for (int i = 1; i <= n; i++) G[i] = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            G[a].add(b);
            G[b].add(a);
        }

        dfs(1, 0);
        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }
}