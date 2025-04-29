public class Q79单词搜索{
    public static void main(String[] args) {
        char[][] chars=new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word="SEE";
//        char[][] chars=new char[][]{{'a'}};
//        String word="a";

        System.out.println(new Q79单词搜索().exist(chars,word));
    }
    int m;
    int n;
    public boolean exist1(char[][] board, String word) {
        int length = word.length();
        m=board.length;
        n=board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

            }
        }
        return false;
    }



    public boolean exist(char[][] board, String word) {
//        char begin = word.charAt(0);
//        char end = word.charAt(word.length() - 1);
//        int num1=0;
//        int num2=0;
//        for (int i = 0; i < word.length(); i++) {
//            if(word.charAt(i)==begin)
//                num1++;
//            if(word.charAt(i)==end)
//                num2++;
//        }
//        char c;
//        String word1;
//        int num;
//        if(num2>num1){
//            c=end;
//            word1 = new StringBuilder(word).reverse().toString();
//            num=num2;
//        }
//        else {
//            c=begin;
//            word1=word;
//            num=num1;
//        }
//        int cNums=0;
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board[0].length; j++) {
//                if(board[i][j]==c)
//                    cNums++;
//            }
//        }
//        if(num>cNums)
//            return false;
        boolean[][] visited=new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(dfs(0,word,board,visited,i,j))
                    return true;
            }
        }
        return false;
    }
    public boolean dfs(int step,String word,char[][] board,boolean[][] visited,int x,int y){
        //关键判断
        if(visited[x][y]||board[x][y]!=word.charAt(step))
           return false;
        //最后一个字母匹配成功，返回true
        if(step==word.length()-1)
            return true;
        visited[x][y]=true;
        boolean flag;
        //四个方向走
        if(x-1>=0){
            flag=dfs(step+1,word,board,visited,x-1,y);
            if(flag)
                return true;
        }
        if(x+1<=board.length-1){
            flag=dfs(step+1,word,board,visited,x+1,y);
            if(flag)
                return true;
        }
        if(y-1>=0){
            flag=dfs(step+1,word,board,visited,x,y-1);
            if(flag)
                return true;
        }
        if(y+1<=board[0].length-1){
            flag=dfs(step+1,word,board,visited,x,y+1);
            if(flag)
                return true;
        }
        //四个方向都失败，说明这一格不能走，回退到上一步，返回false
        visited[x][y]=false;
        return false;
    }


//答案和我的基本一致
//    public boolean exist(char[][] board, String word) {
//        int h = board.length, w = board[0].length;
//        boolean[][] visited = new boolean[h][w];
//        for (int i = 0; i < h; i++) {
//            for (int j = 0; j < w; j++) {
//                boolean flag = check(board, visited, i, j, word, 0);
//                if (flag) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
//
//    public boolean check(char[][] board, boolean[][] visited, int i, int j, String s, int k) {
//        if (board[i][j] != s.charAt(k)) {
//            return false;
//        } else if (k == s.length() - 1) {
//            return true;
//        }
//        visited[i][j] = true;
//        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
//        for (int[] dir : directions) {
//            int newi = i + dir[0], newj = j + dir[1];
//            if (newi >= 0 && newi < board.length && newj >= 0 && newj < board[0].length) {
//                if (!visited[newi][newj]) {
//                    boolean flag = check(board, visited, newi, newj, s, k + 1);
//                    if (flag) {
//
//                        return true;
//                    }
//                }
//            }
//        }
//        visited[i][j] = false;
//        return false;
//    }


}
