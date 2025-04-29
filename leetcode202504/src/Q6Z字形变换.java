import java.util.ArrayList;
import java.util.List;

public class Q6Z字形变换 {
    public static void main(String[] args) {

    }
    //41.55
    public String convert(String s, int numRows) {
        if(numRows==1)
            return s;
        int row=0;
        //控制向上走还是向下走
        int incr=1;
        List<List<Character>> lists=new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            //准备numRows个list，用来村每一行的东西
            lists.add(new ArrayList<>());
        }
        for (int i = 0; i < s.length(); i++) {
            lists.get(row).add(s.charAt(i));
            if(row==0)
                incr=1;
            if(row==numRows-1)
                incr=-1;
            row+=incr;
        }
        StringBuilder stringBuilder=new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (Character c : lists.get(i)) {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }
}

//二维矩阵模拟10
class Solution6_1 {
    public String convert(String s, int numRows) {
        int n = s.length(), r = numRows;
        if (r == 1 || r >= n) {
            return s;
        }
        int t = r * 2 - 2;
        int c = (n + t - 1) / t * (r - 1);
        char[][] mat = new char[r][c];
        for (int i = 0, x = 0, y = 0; i < n; ++i) {
            mat[x][y] = s.charAt(i);
            if (i % t < r - 1) {
                ++x; // 向下移动
            } else {
                --x;
                ++y; // 向右上移动
            }
        }


        StringBuffer ans = new StringBuffer();
        for (char[] row : mat) {
            for (char ch : row) {
                if (ch != 0) {
                    ans.append(ch);
                }
            }
        }
        return ans.toString();
    }
}

//压缩矩阵空间40
class Solution6_2 {
    public String convert(String s, int numRows) {
        int n = s.length(), r = numRows;
        if (r == 1 || r >= n) {
            return s;
        }
        StringBuffer[] mat = new StringBuffer[r];
        for (int i = 0; i < r; ++i) {
            mat[i] = new StringBuffer();
        }
        for (int i = 0, x = 0, t = r * 2 - 2; i < n; ++i) {
            mat[x].append(s.charAt(i));
            if (i % t < r - 1) {
                ++x;
            } else {
                --x;
            }
        }
        StringBuffer ans = new StringBuffer();
        for (StringBuffer row : mat) {
            ans.append(row);
        }
        return ans.toString();
    }
}

//方法三直接构造，无java版代码
//class Solution {
//    public:
//    string convert(string s, int numRows) {
//        int n = s.length(), r = numRows;
//        if (r == 1 || r >= n) {
//            return s;
//        }
//        string ans;
//        int t = r * 2 - 2;
//        for (int i = 0; i < r; ++i) { // 枚举矩阵的行
//            for (int j = 0; j + i < n; j += t) { // 枚举每个周期的起始下标
//                ans += s[j + i]; // 当前周期的第一个字符
//                if (0 < i && i < r - 1 && j + t - i < n) {
//                    ans += s[j + t - i]; // 当前周期的第二个字符
//                }
//            }
//        }
//        return ans;
//    }
//};

