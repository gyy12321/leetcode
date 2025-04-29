import java.util.Scanner;

public class Main333 {
    static int[] gg;
    static int kk, nn;
    public static int find(int x){
        int l=1,r= kk;
        while (l<=r){
            int mid=(l+r)/2;
            if(gg[mid]>x)
                r=mid-1;
            else if(gg[mid]<x)
                l=mid+1;
            else
                return mid;
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //输入nnnnnnnnnnnn
        kk =sc.nextInt();
        gg =new int[kk +1];
        //==================================================
        for(int i = 1; i<= kk; ++i){
            gg[i]=sc.nextInt();
        }
        //==================================================
        //输入ppppppppppp
        nn =sc.nextInt();
        StringBuilder stringBuilder = new StringBuilder(nn);
        for(int i = 1; i<= nn; ++i){
            int b=sc.nextInt();
            if(find(b)!=-1)
                stringBuilder.append('Y');
            else
                stringBuilder.append('N');
        }
        sc.close();
        //输出输出输出输出输出输出输出输出输出输出输出输出输出输出输出
        System.out.println(stringBuilder.toString());

    }

}
