import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//第二遍做的结果
public class Q17电话号码的字母组合_practice {

    Map<Character,String> map=new HashMap<>();



    public static void main(String[] args) {
        System.out.println(new Q17电话号码的字母组合_practice().letterCombinations("2489"));
    }

    public List<String> letterCombinations(String digits) {
        if(digits==null||digits.length()==0){
            return new ArrayList<String>();
        }
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        List<String> res=new ArrayList<>();
        StringBuilder stringBuilder=new StringBuilder();
        dfs(0,digits,res,stringBuilder);
        return res;
    }

    //dfs可以改为backtrack
    public void dfs(int n,String digits,List<String> res,StringBuilder stringBuilder){
        if(n==digits.length())
            res.add(stringBuilder.toString());
        else {
            String chars = map.get(digits.charAt(n));
            for (int i = 0; i < chars.length(); i++) {
                stringBuilder.append(chars.charAt(i));
                dfs(n+1,digits,res,stringBuilder);
                stringBuilder.deleteCharAt(stringBuilder.length()-1);
            }
        }
    }
}
