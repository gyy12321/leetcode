import java.util.Arrays;
import java.util.Comparator;

public class Q452用最少数量的箭引爆气球 {
    public static void main(String[] args) {
        int[][] intervals = {
                {3,  9},
                {7, 12},
                {3,  8},
                {6,  8},
                {9, 10},
                {2,  9},
                {0,  9},
                {3,  9},
                {0,  6},
                {2,  8}
        };

        System.out.println(findMinArrowShots(intervals));
        //System.out.println(findMinArrowShots(new int[][]{{3,5},{2,4}}));
    }
    public static int findMinArrowShots(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]<o2[0])
                    return -1;
                return 1;
            }
        });
        int length = points.length;
        int res=1;
        int l=0;
        int r=1;

        //不需要定义start
        //int start=points[0][0];
        int end=points[0][1];
        while (r<length){
            //和前面的没有交集
            //更新l，产生新的一个了，res++，更新end位置
            if(points[r][0]>end){
                l=r;
                res++;
                end=points[l][1];
            }
            //有交集
            else {
                //哪个end靠前就选哪个
                end=Math.min(end,points[r][1]);
            }
            r++;
        }
        return res;
    }

    //似乎可以不用l
    public static int findMinArrowShots1(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]<o2[0])
                    return -1;
                return 1;
            }
        });
        int length = points.length;
        int res=1;
        int r=1;
        //不需要定义start
        //int start=points[0][0];
        int end=points[0][1];
        while (r<length){
            //和前面的没有交集
            //更新l，产生新的一个了，res++，更新end位置
            if(points[r][0]>end){
                res++;
                end=points[r][1];
            }
            //有交集
            else {
                //哪个end靠前就选哪个
                end=Math.min(end,points[r][1]);
            }
            r++;
        }
        return res;
    }

}

//官方答案，按右边界位置排序，和我的按左边界位置排序不同
class Solution452_1 {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] point1, int[] point2) {
                if (point1[1] > point2[1]) {
                    return 1;
                } else if (point1[1] < point2[1]) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        int pos = points[0][1];
        int ans = 1;
        for (int[] balloon: points) {
            if (balloon[0] > pos) {
                pos = balloon[1];
                ++ans;
            }
        }
        return ans;
    }
}
