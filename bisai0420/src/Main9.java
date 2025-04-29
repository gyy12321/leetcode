import java.util.Arrays;
import java.util.Scanner;

public class Main9 {

    //定义点类
    private static class Point{
        int x,y,idx;
        Point(int x,int y,int idx){
            this.x=x;
            this.y=y;
            this.idx=idx;
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Point[] pts=new Point[n];
        for (int i = 0; i < n; i++) {
            int x=sc.nextInt();
            int y=sc.nextInt();
            pts[i]=new Point(x,y,i+1);
        }
        sc.close();
        Arrays.sort(pts,(a,b)->{
            if(a.x!=b.x)
                return Integer.compare(a.x,b.x);
            return Integer.compare(a.y,b.y);
        });

        for (int i = 0; i < n; i++) {
            System.out.println(pts[i].x+" "+pts[i].y);
        }
        for (int i = 0; i < n; i++) {
            if(i!=n-1)
                System.out.print(pts[i].idx+" ");
            else
                System.out.println(pts[i].idx);
        }
    }

}
