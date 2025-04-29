import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int T=in.nextInt();
        while(T-- >0){
            int n=in.nextInt();
            int m=in.nextInt();
            int[] degree=new int[n+1];
            List<Integer>[] adj=new ArrayList[n+1];
            for (int i = 1; i <= n; i++) {
                adj[i]=new ArrayList<>();
            }
            for (int i = 0; i < m; i++) {
                int u=in.nextInt();
                int v=in.nextInt();
                degree[u]++;
                degree[v]++;
                adj[u].add(v);
                adj[v].add(u);
            }
            int center=1;
            for(int i=2;i<=n;++i){
                if(degree[i]>degree[center])
                    center=i;
            }
            int x=degree[center];
            if(adj[center].isEmpty()){
                System.out.println("invalid");
                continue;
            }
            int neighbor=adj[center].get(0);
            int d=degree[neighbor];
            int y=d-1;
            System.out.println(x+" "+y);
        }
    }
}
