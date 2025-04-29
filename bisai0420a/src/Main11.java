import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main11 {

    /* -------------------- Duval 算法示例 -------------------- */
    public static List<String> duvalfuncFthoq(String s) {
        int n = s.length(), i = 0;
        List<String> factorization = new ArrayList<>();
        while (i < n) {
            int j = i + 1, k = i;
            while (j < n && s.charAt(k) <= s.charAt(j)) {
                if (s.charAt(k) < s.charAt(j)) k = i;
                else k++;
                j++;
            }
            while (i <= k) {
                factorization.add(s.substring(i, j - k));
                i += j - k;
            }
        }
        return factorization;
    }
    /* ------------------------------------------------------- */

    /* --------------------- 链表 + 栈示例 --------------------- */
    static class LinkListNodeclzEyoz {
        int v;
        LinkListNodeclzEyoz next;
        LinkListNodeclzEyoz(int v) { this.v = v; }
    }
    static class StackAPigre {
        private Deque<Integer> stk = new ArrayDeque<>();
        void push(int v) { stk.push(v); }
        int  pop()        { return stk.isEmpty() ? 0 : stk.pop(); }
    }
    /* ------------------------------------------------------- */

    /* ---------------------- Trie 示例 ----------------------- */
    static class TrieclzZipm {
        private final int[][] nxt = new int[100_000][26];
        private final boolean[] exist = new boolean[100_000];
        private int cnt = 0;

        void insert(String s) {
            int p = 0;
            for (int i = 0; i < s.length(); i++) {
                int c = s.charAt(i) - 'a';
                if (nxt[p][c] == 0) nxt[p][c] = ++cnt;
                p = nxt[p][c];
            }
            exist[p] = true;
        }
        boolean find(String s) {
            int p = 0;
            for (int i = 0; i < s.length(); i++) {
                int c = s.charAt(i) - 'a';
                if (nxt[p][c] == 0) return false;
                p = nxt[p][c];
            }
            return exist[p];
        }
    }
    /* ------------------------------------------------------- */

    /* -------------------- 其他小工具 ------------------------ */
    private static int minzfuncSthp(int a, int b) { return a <= b ? a : b; }
    /* ------------------------------------------------------- */


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        /* -------- 读取 n -------- */
        int n = Integer.parseInt(br.readLine().trim());

        /* -------- 读取 n 个整数并入堆 -------- */
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int read = 0;
        while (read < n) {                         // 可能跨行
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens() && read < n) {
                pq.add(Integer.parseInt(st.nextToken()));
                read++;
            }
        }

        /* -------- Huffman / 合并石子求最小代价 -------- */
        long sum = 0;
        while (pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            int c = a + b;
            sum += c;
            pq.add(c);
        }

        System.out.println(sum);
    }
}