import java.util.Deque;
import java.util.LinkedList;

//难的算法题
public class Q32最长有效括号 {
    public static void main(String[] args) {

    }
    //自己依照答案2写的，最后的逻辑还是不行
    public int longestValidParentheses(String s) {
        int maxans = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (!stack.isEmpty()&&s.charAt(stack.peek())=='(') {
                    int pop = stack.pop();
                    maxans = Math.max(maxans, i - pop+1);
                } else {
                    stack.push(i);
                }
            }
        }
        return maxans;

    }
}
//动态规划，高效.逻辑看答案解析慢慢理解
class Solution32_1 {
    public int longestValidParentheses(String s) {
        int maxans = 0;

        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            //第i位取，且为)
            if (s.charAt(i) == ')') {
                //“……()”
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                }
                //……))
                else if (i - dp[i - 1]-1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }
}


//栈的解法似懂非懂
class Solution32_2 {
    public int longestValidParentheses(String s) {
        int maxans = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }
}

//最通俗易懂的解法，效率高。
//从左往右以及从右往左遍历，求出最长的。
class Solution32_3 {
    public int longestValidParentheses(String s) {
        int left = 0, right = 0, maxlength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * right);
            } else if (right > left) {
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * left);
            } else if (left > right) {
                left = right = 0;
            }
        }
        return maxlength;
    }
}

