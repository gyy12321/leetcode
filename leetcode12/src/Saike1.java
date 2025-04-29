import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Saike1 {
    static int[] nums;
    static List<Integer> list;
    public static void main(String[] args) {
        int n,m;
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        list=new ArrayList<>();
        nums=new int[n];
        for (int i = 0; i < n; i++) {
            nums[i]=sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            int op=sc.nextInt();
            if(op==1){
                int l= sc.nextInt();
                int r= sc.nextInt();
                int k= sc.nextInt();
                op1(l,r,k);
            }
            else if (op==2){
                int l= sc.nextInt();
                int r= sc.nextInt();
                op2(l,r);
            }
        }
        list.forEach(System.out::println);
    }

    public static void op1(int l,int r,int k){
        int x=0;
        for(int i=l-1;i<=r-1;i++){
            nums[i]=x+k;
            x++;
        }
    }
    public static void op2(int l,int r){
        int sum=0;
        for(int i=l-1;i<=r-1;i++){
            sum+=nums[i];
        }
        list.add(sum);
    }
}
