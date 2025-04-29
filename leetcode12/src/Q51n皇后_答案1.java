import java.util.*;

class Solution {
    public static void main(String[] args) {
        //统计1-10个皇后的解的个数
        System.out.println(new Solution().solveNQueens(15).size());

    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<List<String>>();
        //queens[i]表示第i行的皇后的列位置,初始值-1,表示第i行没有皇后
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        //三个集合是精髓
        Set<Integer> columns = new HashSet<Integer>();
        Set<Integer> diagonals1 = new HashSet<Integer>();
        Set<Integer> diagonals2 = new HashSet<Integer>();
        //n表示皇后个数
        backtrack(solutions, queens, n, 0, columns, diagonals1, diagonals2);
        return solutions;
    }

    public void backtrack(List<List<String>> solutions, int[] queens, int n, int row, Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2) {
        if (row == n) {
            //递归到第n行，说明找到了一种解，加入到结果集
            List<String> board = generateBoard(queens, n);
            //solution表示所有的解
            solutions.add(board);
        } else {
            //i表示第row行的皇后放在第i列
            for (int i = 0; i < n; i++) {
                //三个continue表示不是合法的解，需要跳过
                if (columns.contains(i)) {
                    continue;
                }
                //行号与列号之差
                int diagonal1 = row - i;
                if (diagonals1.contains(diagonal1)) {
                    continue;
                }
                //行号与列号之和
                int diagonal2 = row + i;
                if (diagonals2.contains(diagonal2)) {
                    continue;
                }
                //第i列可以放
                queens[row] = i;
                //改变三个集合
                columns.add(i);
                diagonals1.add(diagonal1);
                diagonals2.add(diagonal2);



                //递归下一行
                backtrack(solutions, queens, n, row + 1, columns, diagonals1, diagonals2);
                //不放在第i列，恢复三个集合的状态
                queens[row] = -1;
                columns.remove(i);
                diagonals1.remove(diagonal1);
                diagonals2.remove(diagonal2);



            }
        }
    }

    public List<String> generateBoard(int[] queens, int n) {
        List<String> board = new ArrayList<String>();
        //生成满足要求的棋盘，作为结果返回
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            //将第i行的皇后放在第queens[i]列
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }


        return board;
    }
}

//基于位运算，还不会
class Solution51_2 {
    public List<List<String>> solveNQueens(int n) {
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        List<List<String>> solutions = new ArrayList<List<String>>();
        solve(solutions, queens, n, 0, 0, 0, 0);
        return solutions;
    }

    public void solve(List<List<String>> solutions, int[] queens, int n, int row, int columns, int diagonals1, int diagonals2) {
        if (row == n) {
            List<String> board = generateBoard(queens, n);
            solutions.add(board);
        } else {
            int availablePositions = ((1 << n) - 1) & (~(columns | diagonals1 | diagonals2));
            while (availablePositions != 0) {
                int position = availablePositions & (-availablePositions);
                availablePositions = availablePositions & (availablePositions - 1);
                int column = Integer.bitCount(position - 1);
                queens[row] = column;
                solve(solutions, queens, n, row + 1, columns | position, (diagonals1 | position) << 1, (diagonals2 | position) >> 1);
                queens[row] = -1;
            }
        }
    }

    public List<String> generateBoard(int[] queens, int n) {
        List<String> board = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }
}
