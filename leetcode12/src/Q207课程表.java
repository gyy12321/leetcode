import java.util.*;

public class Q207课程表 {
    //自己第一次写的，第二次看有点难懂
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //逆拓扑排序
        boolean[] canTake=new boolean[numCourses];
        int canTakeNum=0;
        int[] chudu=new int[numCourses];
        Map<Integer, Set<Integer>> map=new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            int x=prerequisites[i][0];
            int y = prerequisites[i][1];
            Set<Integer> set = map.getOrDefault(x, new HashSet<>());
            set.add(y);
            map.put(x,set);
            chudu[y]++;
        }
        while (canTakeNum<numCourses){
            int temp=canTakeNum;
            for (int i = 0; i < numCourses; i++) {
                if(!canTake[i]&&chudu[i]==0){
                    canTakeNum++;
                    canTake[i]=true;
//                    for (int j = 0; j < prerequisites.length; j++) {
//                        if(prerequisites[j][0]==i)
//                            chudu[prerequisites[j][1]]--;
//                    }
                    Set<Integer> set = map.get(i);
                    if(set!=null){
                        for (Integer integer : set) {
                            chudu[integer]--;
                        }
                    }

                }
            }
            if(temp==canTakeNum)
                return false;
        }
        return true;
    }

}

//dfs解法效率高，答案写的，看不懂
class Solution207_1 {
    List<List<Integer>> edges;
    int[] visited;
    boolean valid = true;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; ++i) {
            edges.add(new ArrayList<Integer>());
        }
        visited = new int[numCourses];
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
        }
        for (int i = 0; i < numCourses && valid; ++i) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }
        return valid;
    }

    public void dfs(int u) {
        visited[u] = 1;
        for (int v: edges.get(u)) {
            if (visited[v] == 0) {
                dfs(v);
                if (!valid) {
                    return;
                }
            } else if (visited[v] == 1) {
                valid = false;
                return;
            }
        }
        visited[u] = 2;
    }
}

//答案的广度优先，顺向思维,采用正向的拓扑排序的思维
class Solution207_2 {
    List<List<Integer>> edges;
    int[] indeg;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; ++i) {
            edges.add(new ArrayList<Integer>());
        }
        indeg = new int[numCourses];
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
            ++indeg[info[0]];
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; ++i) {
            if (indeg[i] == 0) {
                queue.offer(i);
            }
        }

        int visited = 0;
        while (!queue.isEmpty()) {
            ++visited;
            int u = queue.poll();
            for (int v: edges.get(u)) {
                --indeg[v];
                if (indeg[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        return visited == numCourses;
    }
}

//bfs方法，自己尝试写一写,相对比较好理解
class Solution207_01 {
    List<List<Integer>> edges;
    int visited=0;
    int[] indeg;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        indeg=new int[numCourses];
        edges=new ArrayList<>();
        Deque<Integer> deque=new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<Integer>());
        }

        //更高级写法
        for (int[] info : prerequisites) {
            //info[1]->info[0]的边
            //edges.get(i)表示info[i]节点的出边构成的list
            edges.get(info[1]).add(info[0]);
            //info[0]的入度加一
            ++indeg[info[0]];
        }

/*
        for (int i = 0; i < prerequisites.length; i++) {
            int from=prerequisites[i][1];
            int to =prerequisites[i][0];
            edges.get(from).add(to);
            ++indeg[to];
        }
*/
        for (int i = 0; i < numCourses; i++) {
            //入度为0的入队列
            if(indeg[i]==0)
                deque.offer(i);
        }
        while (!deque.isEmpty()){
            visited++;
            int poll = deque.poll();
            //x为poll节点出发的边指向的节点
            for (Integer x : edges.get(poll)) {
                //入度减一
                --indeg[x];
                //入度为0的入队列
                if(indeg[x]==0)
                    deque.offer(x);
            }
        }
        return visited==numCourses;
    }

}

//尝试用集合
class Solution207_02 {
    Map<Integer, Set<Integer>> map=new HashMap<>();
    int visited=0;
    int[] indeg;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        indeg=new int[numCourses];
        Deque<Integer> deque=new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            map.put(i,new HashSet<>());
        }
        //更高级写法
        for (int[] info : prerequisites) {
            //info[1]->info[0]的边
            //edges.get(i)表示info[i]节点的出边构成的list
            Set<Integer> set = map.get(info[1]);
            set.add(info[0]);
            map.put(info[1],set);
            ++indeg[info[0]];
        }
        for (int i = 0; i < numCourses; i++) {
            //入度为0的入队列
            if(indeg[i]==0)
                deque.offer(i);
        }
        while (!deque.isEmpty()){
            visited++;
            int poll = deque.poll();
            //x为poll节点出发的边指向的节点
            //入度为0的点可能出度也为0，所以这儿可能有空指针问题，但前面已经初始化空set了，所以解决了
            for (Integer x : map.get(poll)) {
                //入度减一
                --indeg[x];
                //入度为0的入队列
                if(indeg[x]==0)
                    deque.offer(x);
            }
        }
        return visited==numCourses;
    }

}

