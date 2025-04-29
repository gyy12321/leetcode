import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main1 {
    public static final int[][] D ={
            {-2,-1},{-2,1},{-1,-2},{-1,2},{1,-2},{1,2},{2,-1},{2,1}
    };
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int a=sc.nextInt();
        int b=sc.nextInt();
        int[][] dist=new int[n+1][m+1];
        for(int i=1;i<=n;++i){
            for (int j = 1; j <= m; j++) {
                dist[i][j]=-1;
            }
        }

        Deque<int[]> deque=new LinkedList<>();
        dist[a][b]=0;
        deque.offer(new int[]{a,b});
        while (!deque.isEmpty()){
            int[] cur=deque.poll();
            int x=cur[0];
            int y=cur[1];
            int step=dist[x][y];
            for(int[] d: D){
                int nx=x+d[0];
                int ny=y+d[1];
                if(nx>=1&&nx<=n&&ny>=1&&ny<=m&&dist[nx][ny]==-1){
                    dist[nx][ny]=step+1;
                    deque.offer(new int[]{nx,ny});
                }
            }
        }
        //循环输出
        for (int i = 1; i <= n; i++) {
            for(int j=1;j<=m;j++){
                System.out.printf("%-5d",dist[i][j]);
            }
            System.out.println();
        }


    }
}
