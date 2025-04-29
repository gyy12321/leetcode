public class Q151反转字符串中的单词 {
    public static void main(String[] args) {
        System.out.println(new Q151反转字符串中的单词().reverseWords("  hello world  "));
    }
    public String reverseWords(String s) {
        String[] splits = s.trim().split("\\s+");
        StringBuilder stringBuilder=new StringBuilder(splits[0]);
        for (int i = 1; i < splits.length; i++) {
            stringBuilder.insert(0,splits[i]+" ");
        }
        return stringBuilder.toString();
    }
}
//答案暂时懒得看
