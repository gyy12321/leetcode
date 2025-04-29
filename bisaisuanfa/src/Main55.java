import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main55 {
    static final int N=1030;
    static int[][] g=new int[N][N];
    static int[] din=new int[N];
    static int[] ans=new int[N];
    static int cnt=0;
    static int n;
    static void dfs(int u){
        for(int i=1;i<N;++i){
            if(g[u][i]>0){
                g[u][i]--;
                g[i][u]--;
                dfs(i);
            }
        }
        ans[++cnt]=u;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        for(int i=0;i<N;++i){
            for(int j=0;j<N;++j){
                g[i][j]=0;
            }
            din[i]=0;
        }
        cnt=0;
        for(int i=1;i<=n;++i){
            int a=sc.nextInt();
            int b= sc.nextInt();
            g[a][b]++;
            g[b][a]=g[a][b];
            din[a]++;
            din[b]++;
        }
        sc.close();
        int s=1;
        while (s<N&&din[s]==0){
            s++;
        }
        for(int i=1;i<N;++i){
            if((din[i]&1)==1){
                s=i;
                break;
            }
        }
        dfs(s);
        for(int i=cnt;i>0;i--){
            System.out.println(ans[i]);
        }
    }
}
