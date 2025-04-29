import java.util.Deque;
import java.util.LinkedList;

public class Q224基本计算器 {
}


//71，答案需要深入理解

class Solution224_1 {
    public int calculate(String s) {
        Deque<Integer> ops = new LinkedList<Integer>();
        ops.push(1);
        int sign = 1;

        int ret = 0;
        int n = s.length();
        int i = 0;
        //每个括号内的所有数都共用一个原始的符号1或-1.位于栈顶，并根据数字前面的加减符号数量进一步决定那个数的符号
        while (i < n) {
            //栈里面只存符号
            if (s.charAt(i) == ' ') {
                i++;
            } else if (s.charAt(i) == '+') {
                //根据数字前面的加减符号数量进一步决定那个数的符号
                sign = ops.peek();
                i++;
            } else if (s.charAt(i) == '-') {
                //根据数字前面的加减符号数量进一步决定那个数的符号
                sign = -ops.peek();
                i++;
            } else if (s.charAt(i) == '(') {

                //每个括号内的所有数都共用一个原始的符号1或-1
                //左括号前面都是+或者-，他的上一步刚跟新过sign
                //本质上-（3+4）和-4+6的-符号发挥的作用相似
                ops.push(sign);
                i++;
            } else if (s.charAt(i) == ')') {
                //移出原始符号
                ops.pop();
                i++;
            } else {
                //遍历到数字，进行加减运算，并将结果加入到最后的ret
                //所谓的加减运算就是+5，-8等；而不是3+5，4-9
                //每个数和他前面的符号相结合进行计算，而不是传统意义上的二院运算
                long num = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                ret += sign * num;
            }
        }
        return ret;
    }
}


