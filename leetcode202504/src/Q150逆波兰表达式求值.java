import java.util.Deque;
import java.util.LinkedList;

public class Q150逆波兰表达式求值 {
    public static void main(String[] args) {

    }

    //90多
    public int evalRPN(String[] tokens) {
        Deque<Integer> deque=new LinkedList<>();
        for (String token : tokens) {
            switch (token){
                case "+":{
                    int num2=deque.poll();
                    int num1=deque.poll();
                    deque.push(num1+num2);
                    //break千万不能少，否则会进入到default李去
                    break;
                }
                case "-":{
                    int num2=deque.poll();
                    int num1=deque.poll();
                    deque.push(num1-num2);
                    break;
                }
                case "*":{
                    int num2=deque.poll();
                    int num1=deque.poll();
                    deque.push(num1*num2);
                    break;
                }
                case "/":{
                    int num2=deque.poll();
                    int num1=deque.poll();
                    deque.push(num1/num2);
                    break;
                }
                default:deque.push(Integer.parseInt(token));
            }
        }
        return deque.poll();
    }
}
//71
class Solution150_1 {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<Integer>();
        int n = tokens.length;
        for (int i = 0; i < n; i++) {
            String token = tokens[i];
            if (isNumber(token)) {
                stack.push(Integer.parseInt(token));
            } else {
                int num2 = stack.pop();
                int num1 = stack.pop();
                switch (token) {
                    case "+":
                        stack.push(num1 + num2);
                        break;
                    case "-":
                        stack.push(num1 - num2);
                        break;
                    case "*":
                        stack.push(num1 * num2);
                        break;
                    case "/":
                        stack.push(num1 / num2);
                        break;
                    default:
                }
            }
        }
        return stack.pop();
    }

    public boolean isNumber(String token) {
        return !("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token));
    }
}
