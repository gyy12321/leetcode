import java.util.*;

public class Q210课程表2 {
    public static void main(String[] args) {
        System.out.println();
        List<Integer> list=new ArrayList<>();
        System.out.println(list.get(0));
    }
//    public int[] findOrder(int numCourses, int[][] prerequisites) {
//        int[] res=new int[numCourses];
//        int[] ins=new int[numCourses];
//        boolean[] visited=new boolean[numCourses];
//        for (int[] prerequisite : prerequisites) {
//            ins[prerequisite[0]]++;
//        }
//        for (int i = 0; i < numCourses; i++) {
//            int j;
//            for (j = 0; j < numCourses; j++) {
//                if(!visited[j]&&ins[j]==0){
//                    visited[j]=true;
//                    for (int[] prerequisite : prerequisites) {
//                        if(prerequisite[1]==j)
//                            ins[prerequisite[0]]--;
//                    }
//                    res[i]=j;
//                    break;
//                }
//            }
//            if(j==numCourses)
//                return new int[numCourses];
//        }
//        return res;
//    }
    public int[] findOrder1(int numCourses, int[][] prerequisites) {
        int[] res=new int[numCourses];
        int[] indeg=new int[numCourses];
        List<Integer>[] lists=new List[numCourses];

//        for (int i = 0; i < numCourses; i++) {
//            lists[i]=new ArrayList<>();
//        }

        for (List<Integer> list : lists) {
            list=new ArrayList<>();
        }
        for (int[] prerequisite : prerequisites) {
            int i=prerequisite[0];
            int j=prerequisite[1];
            indeg[i]++;
            lists[j].add(i);
        }
        Deque<Integer> deque=new LinkedList<>();
        //入度为0的放入队列里面
        int index=0;

        for(int i=0;i<numCourses;++i){
            if(indeg[i]==0){
                deque.offer(i);
                res[index++]=i;
            }
        }
        while (!deque.isEmpty()){
            Integer poll = deque.poll();
            for (Integer x : lists[poll]) {
                if(--indeg[x]==0){
                    deque.offer(x);
                    res[index++]=x;
                }
            }
        }
        if(index!=numCourses)
            return new int[0];
        return res;

    }
}
//深度优先搜素效率更高，先不看
class Solution210_1 {
    // 存储有向图
    List<List<Integer>> edges;
    // 标记每个节点的状态：0=未搜索，1=搜索中，2=已完成
    int[] visited;
    // 用数组来模拟栈，下标 n-1 为栈底，0 为栈顶
    int[] result;
    // 判断有向图中是否有环
    boolean valid = true;
    // 栈下标
    int index;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; ++i) {
            edges.add(new ArrayList<Integer>());
        }
        visited = new int[numCourses];
        result = new int[numCourses];
        index = numCourses - 1;
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
        }
        // 每次挑选一个「未搜索」的节点，开始进行深度优先搜索
        for (int i = 0; i < numCourses && valid; ++i) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }
        if (!valid) {
            return new int[0];
        }
        // 如果没有环，那么就有拓扑排序
        return result;
    }

    public void dfs(int u) {
        // 将节点标记为「搜索中」
        visited[u] = 1;
        // 搜索其相邻节点
        // 只要发现有环，立刻停止搜索
        for (int v: edges.get(u)) {
            // 如果「未搜索」那么搜索相邻节点
            if (visited[v] == 0) {
                dfs(v);
                if (!valid) {
                    return;
                }
            }
            // 如果「搜索中」说明找到了环
            else if (visited[v] == 1) {
                valid = false;
                return;
            }
        }
        // 将节点标记为「已完成」
        visited[u] = 2;
        // 将节点入栈
        result[index--] = u;
    }
}

//借助队列广度优先搜索
class Solution210_2 {
    // 存储有向图
    List<List<Integer>> edges;
    // 存储每个节点的入度
    int[] indeg;
    // 存储答案
    int[] result;
    // 答案下标
    int index;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<List<Integer>>();
        //初始化非常关键，不然会空指针异常
        for (int i = 0; i < numCourses; ++i) {
            edges.add(new ArrayList<Integer>());
        }
        indeg = new int[numCourses];
        result = new int[numCourses];
        index = 0;
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
            ++indeg[info[0]];
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        // 将所有入度为 0 的节点放入队列中
        for (int i = 0; i < numCourses; ++i) {
            if (indeg[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            // 从队首取出一个节点
            int u = queue.poll();
            // 放入答案中
            //生成答案在这一步夜行
            result[index++] = u;

            for (int v: edges.get(u)) {
                --indeg[v];
                // 如果相邻节点 v 的入度为 0，就可以选 v 对应的课程了
                if (indeg[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        if (index != numCourses) {
            return new int[0];
        }
        return result;
    }
}

