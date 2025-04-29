import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q57插入区间 {
    public static void main(String[] args) {

    }
//    输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
//    输出：[[1,5],[6,9]]
//    示例 2：
//
//    输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
//    输出：[[1,2],[3,10],[12,16]]
//    解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length==0)
            return new int[][]{{newInterval[0],newInterval[1]}};
        int beginIndex=-1;
        int endIndex=-1;
        //寻找重叠开始的位置以及结束的位置
        for (int i = 0; i < intervals.length; i++) {
            if(chongdie(intervals[i],newInterval)){
                if(beginIndex==-1){
                    beginIndex=i;
                    endIndex=i;
                }
                else
                    endIndex=i;
            }
            else {
                if(endIndex!=-1)
                    break;
            }
        }
        int[][] res;
        //没有任何重合
        if(beginIndex==-1){
            res=new int[intervals.length+1][2];
            int index=0;
            boolean flag=false;
            for (int i = 0; i < res.length; i++) {
                if(flag||(index<intervals.length&&intervals[index][0]<newInterval[0])){
                    res[i]=intervals[index++];
                }
                else{
                    res[i]=newInterval;
                    flag=true;
                }

            }
        }
        //有重叠
        else {
            res=new int[intervals.length-endIndex+beginIndex][2];
            //没重叠部分先放进来
            for(int i=0;i<beginIndex;++i){
                res[i]=intervals[i];
            }

            //重叠部分合成一个并放入
            int start=Math.min(intervals[beginIndex][0],newInterval[0]);
            int end=Math.max(intervals[endIndex][1],newInterval[1]);
            int index=beginIndex;
            res[index++]=new int[]{start,end};

            //剩余不重叠部分放入
            while (index<res.length){
                res[index++]=intervals[++endIndex];
            }
        }
        return res;

    }


    public boolean chongdie(int[] x,int[] y){
        if(x[1]<y[0]||y[1]<x[0])
            return false;
        else
            return true;
    }
}

class Solution57_1 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int left = newInterval[0];
        int right = newInterval[1];
        boolean placed = false;
        List<int[]> ansList = new ArrayList<int[]>();
        for (int[] interval : intervals) {
            //【插入，插入】，【1,2】
            if (interval[0] > right) {
                // 在插入区间的右侧且无交集
                //没有插入那个新区间，则可以插入
                if (!placed) {
                    ansList.add(new int[]{left, right});
                    placed = true;
                }
                ansList.add(interval);

                //[1,2],[插入，插入]
            } else if (interval[1] < left) {
                // 在插入区间的左侧且无交集
                ansList.add(interval);
            } else {
                // 与插入区间有交集，计算它们的并集
                //插入区间和原有的区间做并集，产生一个新的用于插入的更大的区间
                left = Math.min(left, interval[0]);
                right = Math.max(right, interval[1]);
            }
        }
        //在最后插入这个新的区间
        if (!placed) {
            ansList.add(new int[]{left, right});
        }
        //创建返回答案的数组
        int[][] ans = new int[ansList.size()][2];
        //放入答案
        for (int i = 0; i < ansList.size(); ++i) {
            ans[i] = ansList.get(i);
        }
        return ans;
    }
}

