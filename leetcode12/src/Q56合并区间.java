import java.util.*;

//值得再做
public class Q56合并区间 {
    public static void main(String[] args) {
        int[][] merge1 = merge(new int[][]{{1, 4}, {2, 3},{2,2},{3,5},{6,7},{5,4},{3,4}});

        for (int i = 0; i < merge1.length; i++) {
            for (int j = 0; j < merge1[0].length; j++) {
                System.out.print(merge1[i][j] + " ");
            }
            System.out.println();
        }
    }
    //自己的
    public static int[][] merge1(int[][] intervals) {
        //先排序
//        String[] tmp=new String[intervals.length];
//        for (int i = 0; i < intervals.length; i++) {
//            tmp[i]=intervals[i][0]+","+intervals[i][1];
//        }
//        Arrays.sort(tmp);
//        int[][] intervalsNew=new int[intervals.length][2];
//        for (int i = 0; i < intervals.length; i++) {
//            String[] split = tmp[i].split(",");
//            intervalsNew[i][0]=Integer.parseInt(split[0]);
//            intervalsNew[i][1]=Integer.parseInt(split[1]);
//        }
        Arrays.sort(intervals, Comparator.comparingInt(value -> value[1]));
        Arrays.sort(intervals, Comparator.comparingInt(value -> value[0]));
        int[][] res=new int[intervals.length][2];
        //排完序后
        int index=0;
        res[0][0]=intervals[0][0];
        res[0][1]=intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0]<=res[index][1]){
                res[index][1]=Math.max(intervals[i][1],res[index][1]);
            }
            else {
                index++;
                res[index][0]=intervals[i][0];
                res[index][1]=intervals[i][1];
            }
        }
        int[][] res1 =new int[index+1][2];
        for (int i = 0; i < res1.length; i++) {
            res1[i][0]=res[i][0];
            res1[i][1]=res[i][1];
        }
        return res1;
    }

    //标准答案
    public static int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        List<int[]> list=new ArrayList<>();
        //list中先加入第一个序列
        list.add(new int[]{intervals[0][0],intervals[0][1]});
        //依次加入其他序列，做合并操作
        for (int i = 1; i < intervals.length; i++) {
            int L=intervals[i][0];
            int R=intervals[i][1];
            int top=list.size()- 1;
            int[] tmp = list.get(top);
            //第二个序列的左侧大于第一个序列的右侧，需要新加一个序列
            if(L>tmp[1]){
                list.add(new int[]{L,R});
            }
            //更新最上面的那个序列的第二个元素
            else {
                //两种写法都可以
//                list.set(top,new int[]{tmp[0], Math.max(tmp[1],R)});
                list.get(top)[1] = Math.max(tmp[1], R);

            }

        }
        return list.toArray(new int[0][]);
    }
}

//新奇的排序方式
class Solution_1 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });
        List<int[]> merged = new ArrayList<int[]>();
        for (int i = 0; i < intervals.length; ++i) {
            int L = intervals[i][0], R = intervals[i][1];
            //标准答案把第一个序列的操作也统合进来了
            //加序列
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
                merged.add(new int[]{L, R});
            } else {
                //修改序列
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
