import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q17电话号码的字母组合 {

    //map实现更好
    List<String> res=new ArrayList<>();
    StringBuffer stringBuffer=new StringBuffer();
//    String[] strings=new String[2];
    Map<Character,String> map;
    public static void main(String[] args) {
        System.out.println(new Q17电话号码的字母组合().letterCombinations("2489"));
    }


    public List<String> letterCombinations(String digits) {
        if(digits.length()==0){
            return res;
        }
        map=new HashMap<>(){{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");}
        };
//        strings[2]="abc";
//        strings[3]="def";
//        strings[4]="ghi";
//        strings[5]="jkl";
//        strings[6]="mno";
//        strings[7]="pqrs";
//        strings[8]="tuv";
//        strings[9]="wxyz";
        dfs(0,digits);
        return res;
    }

    public void dfs(int n,String digits){
        if(n==digits.length()){
            res.add(stringBuffer.toString());
            return;
        }
//        String temp=strings[digits.charAt(n)-'0'];
        String temp=map.get(digits.charAt(n));
        for (int i = 0; i < temp.length(); i++) {
           stringBuffer.append(temp.charAt(i));
           dfs(n+1,digits);
           stringBuffer.deleteCharAt(stringBuffer.length()-1);
        }
    }
}
