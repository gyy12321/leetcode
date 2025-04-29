import java.util.Scanner;

public class Main5 {
    static int[] a;
    static int n,q;
    public static int find(int x){
        int l=1,r=n;
        while (l<=r){
            int mid=(l+r)/2;
            if(a[mid]>x)
                r=mid-1;
            else if(a[mid]<x)
                l=mid+1;
            else
                return mid;
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //输入nnnnnnnnnnnn
        n=sc.nextInt();
        a=new int[n+1];
        //==================================================
        for(int i=1;i<=n;++i){
            a[i]=sc.nextInt();
        }
        //==================================================
        //输入ppppppppppp
        q=sc.nextInt();
        StringBuilder sb = new StringBuilder(q);
        for(int i=1;i<=q;++i){
            int b=sc.nextInt();
            if(find(b)!=-1)
                sb.append('Y');
            else
                sb.append('N');
        }
        sc.close();
        //输出输出输出输出输出输出输出输出输出输出输出输出输出输出输出
        System.out.println(sb.toString());

    }
}
