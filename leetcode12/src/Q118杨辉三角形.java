import java.util.ArrayList;
import java.util.List;

public class Q118杨辉三角形 {
    public static void main(String[] args) {
        int[] as=new int[10];
        int length = as.length;
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> list ;
        if(numRows>=1){
            list= new ArrayList<>();
            list.add(1);
            result.add(list);
        }
        if(numRows>=2){
            list = new ArrayList<>();
            list.add(1);
            list.add(1);
            result.add(list);
        }
        if(numRows>2){
            for (int i = 3; i <= numRows; i++) {
                list=new ArrayList<>();
                list.add(1);
                List<Integer> temp = result.get(result.size() - 1);
                for (int j = 0; j <= i-3; j++) {
                    list.add(temp.get(j)+temp.get(j+1));
                }
                list.add(1);
                result.add(list);
            }
        }
        return result;

    }

    //官方更简洁的写法
    public List<List<Integer>> generate1(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> list ;
        for (int i = 0; i < numRows; i++) {
            list=new ArrayList<>();
            //添加第i行的数据
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i)
                    list.add(1);
                else
                    //上一行的j-1和j位置的值相加作为当前位置的值
                    list.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
            }
            result.add(list);
        }
        return result;
    }
}
