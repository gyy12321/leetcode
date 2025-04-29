
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main8 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String s=in.next();
        Set<Character> set=new HashSet<>();
        for (char c : s.toCharArray()) {
            set.add(c);
        }
        System.out.println(set.size());
    }
}
