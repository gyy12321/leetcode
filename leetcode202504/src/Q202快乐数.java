import javax.swing.*;
import java.util.HashSet;
import java.util.Set;

public class Q202快乐数 {
    public static void main(String[] args) {



    }
    public boolean isHappy(int n) {
        Set<Integer> set=new HashSet<>();
        while (true){
            int next=0;
            while (n!=0){
                //99
                int x=n%10;
                next+=x*x;
                n/=10;
            }
            if(next==1)
                return true;
            if(set.contains(next))
                return false;
            set.add(next);
            n=next;
        }

    }
}
