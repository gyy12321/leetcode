import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int sum=0;
        for(int i=1;i<=n;++i){
            if(i%2==1)
                sum+=i;
            else
                sum-=i;
        }
        System.out.println(sum);
    }
}
