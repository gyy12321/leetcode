import java.util.ArrayList;
import java.util.List;

public class Q77组合_拓展 {

    //得到所有的子集
    List<List<Integer>> res;
    int num=0;
    public static void main(String[] args) {
        Q77组合_拓展 obj = new Q77组合_拓展();
        obj.dfs(1,5,new ArrayList<>());
        System.out.println(obj.num);
    }

    public void dfs(int cur,int n,List<Integer> list){
        if(cur==n+1){
            System.out.println(list);
            num++;
            return;
        }
        //考虑当前位置
        list.add(cur);
        dfs(cur+1,n,list);
        //不考虑当前位置
        list.remove(list.size()-1);
        dfs(cur+1,n,list);
    }
}

