import java.util.*;

public class Q20有效的括号 {
    public static void main(String[] args) {

    }
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        Map<Character,Character> map=new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c=='['||c=='('||c=='{')
                stack.push(c);
            else {
                if(stack.empty())
                    return false;
                if(map.get(c)==stack.peek())
                    stack.pop();
                else
                    return false;
            }
        }
        if(!stack.empty())
            return false;
        else
            return true;
    }
}
//官方解法
class Solution20_1 {
    public boolean isValid(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }
        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}



class Solution20_2{
    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        Map<Character, Character> map = Map.of(')', '(', ']', '[', '}', '{');
        for (char c : s.toCharArray()) {
            //是左括号，入栈
            if (map.containsValue(c)) {
                stack.push(c);
            } else {
                //是右括号，判断栈是否为空，并且栈顶元素是否匹配
                if (stack.isEmpty() || stack.pop() != map.get(c))
                    return false;
            }
        }
        return stack.isEmpty();
    }
}
