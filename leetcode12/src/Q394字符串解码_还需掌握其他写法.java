import java.util.*;

public class Q394字符串解码_还需掌握其他写法 {
    public static void main(String[] args) {

        System.out.println(new Solution394_1().decodeString("2[abc]3[cd]ef"));
    }
//    给定一个经过编码的字符串，返回它解码后的字符串。
//
//    编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
//
//    你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
//
//    此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
//
//
//
//    示例 1：
//
//    输入：s = "3[a]2[bc]"
//    输出："aaabcbc"
//    示例 2：
//
//    输入：s = "3[a2[c]]"
//    输出："accaccacc"
//    示例 3：
//
//    输入：s = "2[abc]3[cd]ef"
//    输出："abcabccdcdcdef"
//    示例 4：
//
//    输入：s = "abc3[cd]xyz"
//    输出："abccdcdcdxyz"
    //自己的写法
//    public static String decodeString(String s) {
//        Stack<Character> stack = new Stack<>();
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            if(c!=']')
//                stack.push(c);
//            else {
//                List<Character> list = new ArrayList<>();
//                while (stack.peek()!='['){
//                    list.add(0,stack.pop());
//                }
//                stack.pop();
//                String timesString="";
//                while (stack.size()>0&&Character.isDigit(stack.peek())){
//                    timesString=stack.pop()+timesString;
//                }
//                int times = Integer.parseInt(timesString);
//                for (int j = 0; j < times; j++) {
//                    stack.addAll(list);
//                }
//            }
//        }
//        String res="";
//        while (stack.size()!=0){
//            res=stack.pop()+res;
//        }
//        return res;
//    }

    public static String decodeString(String s) {
        Deque<Integer> countStack = new ArrayDeque<>(); // 存储数字
        Deque<String> stringStack = new ArrayDeque<>(); // 存储字符串
        String currentString = ""; // 当前解码字符串
        int k = 0; // 当前的倍数


        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                k = k * 10 + (ch - '0'); // 处理多位数
            } else if (ch == '[') {
                // 遇到 '['，将当前的字符串和数字推入各自的栈
                countStack.push(k);
                stringStack.push(currentString);
                currentString = ""; // 重置当前字符串
                k = 0; // 重置倍数
            } else if (ch == ']') {
                // 遇到 ']'，解码
                StringBuilder temp = new StringBuilder(stringStack.pop());
                int repeatTimes = countStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    temp.append(currentString); // 重复当前字符串
                }
                currentString = temp.toString(); // 更新当前字符串
            } else {
                // 如果是字母，直接加到当前字符串
                currentString += ch;
            }
        }

        return currentString;
    }
}



//自己第二遍写的，和第一遍差别不大
class Solution394_02{
    public String decodeString(String s) {
        Deque<Character> stack=new LinkedList<>();
        for (char c : s.toCharArray()) {
            if(c!=']')
                stack.push(c);
            else {
                String multiString="";
                while (stack.peek()!='[')
                    multiString=stack.pop()+multiString;
                //去掉左括号
                stack.pop();
                String timesString="";
                while (!stack.isEmpty()&&Character.isDigit(stack.peek()))
                    timesString=stack.pop()+timesString;
                int times=Integer.parseInt(timesString);
                for (int i = 0; i < times; i++) {
                    for (char c1 : multiString.toCharArray()) {
                        stack.push(c1);
                    }
                }
            }
        }
        String res="";
        while (!stack.isEmpty()){
            res=stack.pop()+res;
        }
        return res;
    }

}
//效率不如题解

class Solution394_03 {
    int ptr;
    public String decodeString(String s) {
        LinkedList<String> stk = new LinkedList<String>();
        ptr = 0;
        while (ptr < s.length()) {
            System.out.println(ptr);
            char cur = s.charAt(ptr);
            if (Character.isDigit(cur)) {
                // 获取一个数字并进栈
                String digits = getDigits(s);
                stk.addLast(digits);
            } else if (cur == '[') {
                // 获取一个字母并进栈，一个坑位一个字母或左括号
                stk.addLast("[");
                ptr++;
            } else if(Character.isLetter(cur)){
                stk.addLast(getChars(s));
            }
            else{
                //跳过这个右括号的下标
                ++ptr;
                StringBuilder copy=new StringBuilder();
                while (!stk.peekLast().equals("[")){
                    String s1 = stk.removeLast();
                    copy.insert(0,s1);
                }
                StringBuilder res=new StringBuilder();
                stk.removeLast();
                int times = Integer.parseInt(stk.removeLast());
                for (int i = 0; i < times; i++) {
                    res.append(copy);
                }
                stk.addLast(res.toString());
            }
        }
        return getString(stk);
    }

    public String getDigits(String s) {
        StringBuilder ret = new StringBuilder();
        while (Character.isDigit(s.charAt(ptr))) {
            ret.append(s.charAt(ptr++));
        }
        return ret.toString();
    }

    public String getChars(String s){
        StringBuilder stringBuilder=new StringBuilder();
        while(ptr<s.length()&&Character.isLetter(s.charAt(ptr))){
            stringBuilder.append(s.charAt(ptr++));
        }
        return stringBuilder.toString();
    }

    public String getString(LinkedList<String> v) {
        StringBuilder ret = new StringBuilder();
        for (String s : v) {
            ret.append(s);
        }
        return ret.toString();
    }
}




//一番操作后还是题解的方法效率高
class Solution394_1 {
    int ptr;

    public String decodeString(String s) {
        LinkedList<String> stk = new LinkedList<String>();
        ptr = 0;

        while (ptr < s.length()) {
            char cur = s.charAt(ptr);
            if (Character.isDigit(cur)) {
                // 获取一个数字并进栈
                String digits = getDigits(s);
                stk.addLast(digits);
            } else if (Character.isLetter(cur) || cur == '[') {
                // 获取一个字母并进栈
                stk.addLast(String.valueOf(s.charAt(ptr++)));
            } else {
                ++ptr;
                LinkedList<String> sub = new LinkedList<String>();
                while (!"[".equals(stk.peekLast())) {
                    sub.addLast(stk.removeLast());
                }
                Collections.reverse(sub);
                // 左括号出栈
                stk.removeLast();
                // 此时栈顶为当前 sub 对应的字符串应该出现的次数
                int repTime = Integer.parseInt(stk.removeLast());
                StringBuffer t = new StringBuffer();
                String o = getString(sub);
                // 构造字符串
                while (repTime-- > 0) {
                    t.append(o);
                }
                // 将构造好的字符串入栈
                stk.addLast(t.toString());
            }
        }

        return getString(stk);
    }

    public String getDigits(String s) {
        StringBuffer ret = new StringBuffer();
        while (Character.isDigit(s.charAt(ptr))) {
            ret.append(s.charAt(ptr++));
        }
        return ret.toString();
    }

    public String getString(LinkedList<String> v) {
        StringBuffer ret = new StringBuffer();
        for (String s : v) {
            ret.append(s);
        }
        return ret.toString();
    }
}

//递归，效率90多，懒得看了
class Solution394_2 {
    String src;
    int ptr;

    public String decodeString(String s) {
        src = s;
        ptr = 0;
        return getString();
    }

    public String getString() {
        if (ptr == src.length() || src.charAt(ptr) == ']') {
            // String -> EPS
            return "";
        }

        char cur = src.charAt(ptr);
        int repTime = 1;
        String ret = "";

        if (Character.isDigit(cur)) {
            // String -> Digits [ String ] String
            // 解析 Digits
            repTime = getDigits();
            // 过滤左括号
            ++ptr;
            // 解析 String
            String str = getString();
            // 过滤右括号
            ++ptr;
            // 构造字符串
            while (repTime-- > 0) {
                ret += str;
            }
        } else if (Character.isLetter(cur)) {
            // String -> Char String
            // 解析 Char
            ret = String.valueOf(src.charAt(ptr++));
        }

        return ret + getString();
    }

    public int getDigits() {
        int ret = 0;
        while (ptr < src.length() && Character.isDigit(src.charAt(ptr))) {
            ret = ret * 10 + src.charAt(ptr++) - '0';
        }
        return ret;
    }
}
