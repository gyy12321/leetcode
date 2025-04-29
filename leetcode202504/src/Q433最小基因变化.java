import java.util.*;

public class Q433最小基因变化 {
    public static void main(String[] args) {

    }
    //击败100%
    public int minMutation(String startGene, String endGene, String[] bank) {
        if(startGene.equals(endGene))
            return 0;
        int length = bank.length;
        boolean[] visited=new boolean[length];
        //去掉好像也能通过测试
        for (int i = 0; i < length; i++) {
            if(startGene.equals(bank[i]))
                visited[i]=true;
        }

        Deque<String> deque=new LinkedList<>();
        deque.offer(startGene);
        int steps=0;
        //经典的广度优先遍历
        while (!deque.isEmpty()){
            int remain=deque.size();
            //本轮剩余的都取出了，这一轮才能结束，step才能加1
            for (int i = 0; i < remain; i++) {
                String poll = deque.poll();
                if(poll.equals(endGene))
                    return steps;
                for (int j = 0; j < length; j++) {
                    if(!visited[j]&&canTransfer(poll,bank[j])){
                        visited[j]=true;
                        deque.offer(bank[j]);
                    }
                }
            }
            steps++;
        }
        return -1;
    }
    //能否由s1一步转化为s2
    public boolean canTransfer(String s1,String s2){
        int differ=0;
        for (int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i)!=s2.charAt(i))
                differ++;
            if(differ>1)
                return false;
        }
        return true;
    }
}

//题解根两坨答辩似得，不看
class Solution433_1 {
    public int minMutation(String start, String end, String[] bank) {
        Set<String> cnt = new HashSet<String>();
        Set<String> visited = new HashSet<String>();
        char[] keys = {'A', 'C', 'G', 'T'};
        for (String w : bank) {
            cnt.add(w);
        }
        if (start.equals(end)) {
            return 0;
        }
        if (!cnt.contains(end)) {
            return -1;
        }
        Queue<String> queue = new ArrayDeque<String>();
        queue.offer(start);
        visited.add(start);
        int step = 1;
        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                String curr = queue.poll();
                for (int j = 0; j < 8; j++) {
                    for (int k = 0; k < 4; k++) {
                        if (keys[k] != curr.charAt(j)) {
                            StringBuffer sb = new StringBuffer(curr);
                            sb.setCharAt(j, keys[k]);
                            String next = sb.toString();
                            if (!visited.contains(next) && cnt.contains(next)) {
                                if (next.equals(end)) {
                                    return step;
                                }
                                queue.offer(next);
                                visited.add(next);
                            }
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }
}

class Solution433_2 {
    public int minMutation(String start, String end, String[] bank) {
        int m = start.length();
        int n = bank.length;
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        int endIndex = -1;
        for (int i = 0; i < n; i++) {
            if (end.equals(bank[i])) {
                endIndex = i;
            }
            for (int j = i + 1; j < n; j++) {
                int mutations = 0;
                for (int k = 0; k < m; k++) {
                    if (bank[i].charAt(k) != bank[j].charAt(k)) {
                        mutations++;
                    }
                    if (mutations > 1) {
                        break;
                    }
                }
                if (mutations == 1) {
                    adj[i].add(j);
                    adj[j].add(i);
                }
            }
        }
        if (endIndex == -1) {
            return -1;
        }

        Queue<Integer> queue = new ArrayDeque<Integer>();
        boolean[] visited = new boolean[n];
        int step = 1;
        for (int i = 0; i < n; i++) {
            int mutations = 0;
            for (int k = 0; k < m; k++) {
                if (start.charAt(k) != bank[i].charAt(k)) {
                    mutations++;
                }
                if (mutations > 1) {
                    break;
                }
            }
            if (mutations == 1) {
                queue.offer(i);
                visited[i] = true;
            }
        }
        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                int curr = queue.poll();
                if (curr == endIndex) {
                    return step;
                }
                for (int next : adj[curr]) {
                    if (visited[next]) {
                        continue;
                    }
                    visited[next] = true;
                    queue.offer(next);
                }
            }
            step++;
        }
        return -1;
    }
}


