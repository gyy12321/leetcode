import java.util.HashMap;
import java.util.Map;

public class Q13罗马数字转整数 {
    public static void main(String[] args) {

    }

//    I             1
//    V             5
//    X             10
//    L             50
//    C             100
//    D             500
//    M             1000
    //50
    public int romanToInt(String s) {
        Map<Character,Integer> map=Map.of('I',1,'V',5,'X',
                10,'L',50,'C',100,'D',500,'M',1000);
        int sum=0;
        int pre=10000;
        for (int i = 0; i < s.length(); i++) {
            int x = map.get(s.charAt(i));
            sum+=x;
            if(x>pre)
                sum-=2*pre;
            pre=x;
        }
        return sum;

    }
    //30
    public int romanToInt1(String s) {
        Map<Character,Integer> map=Map.of('I',1,'V',5,'X',
                10,'L',50,'C',100,'D',500,'M',1000);
        int sum=0;
        for (int i = 0; i < s.length(); i++) {
            int cur = map.get(s.charAt(i));
            if(i<s.length()-1&&cur<map.get(s.charAt(i+1)))
                sum-=cur;
            else
                sum+=cur;
        }
        return sum;
    }
    //70
    public int romanToInt2(String s) {
        Map<Character,Integer> map=Map.of('I',1,'V',5,'X',
                10,'L',50,'C',100,'D',500,'M',1000);
        int sum=0;
        int next=-1;
        for (int i = s.length()-1; i >= 0; i--) {
            int x = map.get(s.charAt(i));
            if(x>=next)
                sum+=x;
            else
                sum-=x;
            next=x;
        }
        return sum;
    }

    public int romanToInt3(String s) {
        int sum=0;
        int next=-1;
        for (int i = s.length()-1; i >= 0; i--) {
            int x = getValue(s.charAt(i));
            if(x>=next)
                sum+=x;
            else
                sum-=x;
            next=x;
        }
        return sum;
    }
    private int getValue(char ch){
        switch(ch){
            case 'I' : return 1;
            case 'V' : return 5;
            case 'X' : return 10;
            case 'L' : return 50;
            case 'C' : return 100;
            case 'D' : return 500;
            case 'M' : return 1000;
            default : return 0;
        }
    }
}
