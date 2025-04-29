import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Scanner;

public class Main5 {
    static final int MAXV=500;
    static ArrayList<Integer>[] adj=new ArrayList[MAXV+1];
    static int[] degree=new int[MAXV+1];
    static ArrayList<Integer> path=new ArrayList<>();
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int m=in.nextInt();
        for(int i=0;i<=MAXV;++i){
            adj[i]=new ArrayList<>();
            degree[i]=0;
        }

        int maxNode=0;
        for(int i=0;i<m;++i){
            int u=in.nextInt();
            int v=in.nextInt();
            adj[u].add(v);
            adj[v].add(u);
            degree[u]++;
            degree[v]++;
            maxNode= Math.max(maxNode,Math.max(u,v));
        }
        in.close();
        int oddCount=0;
        for(int i=1;i<=maxNode;++i){
            if((degree[i]&1)==1){
                oddCount++;
            }
        }
        int start=1;
        if(oddCount==0){
            for(int i=1;i<=maxNode;++i){
                if(degree[i]>0){
                    start=i;
                    break;
                }
            }
        }else if(oddCount==2){
            for(int i=1;i<=maxNode;++i){
                if((degree[i]&1)==1){
                    start=i;
                    break;
                }
            }
        }
        eulerDfs(start);
        Collections.reverse(path);
        for(int v:path){
            System.out.println(v);
        }

    }
    private static void eulerDfs(int u){
        while (!adj[u].isEmpty()){
            int v=adj[u].get(0);
            adj[u].remove(0);
            adj[v].remove((Integer) u);
            eulerDfs(v);
        }
        path.add(u);
    }
}
