import java.util.*;

public class Q133克隆图 {
//    //效率30-80波动
//    public Node cloneGraph(Node node) {
//        if(node==null)
//            return null;
//        Map<Integer,Node> map=new HashMap<>();
//        Set<Integer> visited=new HashSet<>();
//
//        Node nodeNew=new Node(1);
//        map.put(1,nodeNew);
//
//        dfs(visited,map,node);
//        return nodeNew;
//    }
//    public void dfs(Set<Integer> visited,Map<Integer,Node> map,Node node){
//        int val = node.val;
//        if(visited.contains(val))
//            return;
//
//        visited.add(val);
//        //新节点
//        Node nodeNew=map.getOrDefault(val,new Node(val));
//        map.put(val,nodeNew);
//
//        //邻居全部都加进来
//        for (Node neighbor : node.neighbors) {
//            int val1 = neighbor.val;
//            Node nodeNew1=map.getOrDefault(val1,new Node(val1));
//            //这一句之前少了，错了
//            map.put(val1,nodeNew1);
//            nodeNew.neighbors.add(nodeNew1);
//        }
//        //访问所有邻居
//        for (Node neighbor : node.neighbors) {
//            dfs(visited,map,neighbor);
//        }
//    }

    //boolean数组取代set，击败99%
    //好像还是第二版好
    public Node cloneGraph(Node node) {
        if(node==null)
            return null;
        Map<Integer,Node> map=new HashMap<>();
        boolean[] visited=new boolean[105];

        Node nodeNew=new Node(1);
        map.put(1,nodeNew);

        dfs(visited,map,node);
        return nodeNew;
    }
    public void dfs(boolean[] visited,Map<Integer,Node> map,Node node) {
        int val = node.val;
        if (visited[val])
            return;

        visited[val] = true;
        //新节点
        Node nodeNew = map.getOrDefault(val, new Node(val));
        map.put(val, nodeNew);

        //邻居全部都加进来
        for (Node neighbor : node.neighbors) {
            int val1 = neighbor.val;
            Node nodeNew1 = map.getOrDefault(val1, new Node(val1));
            //这一句之前少了，错了
            map.put(val1, nodeNew1);

            nodeNew.neighbors.add(nodeNew1);
        }
        //访问所有邻居
        for (Node neighbor : node.neighbors) {
            dfs(visited, map, neighbor);
        }
    }

















    //效率30-80波动
//    public Node cloneGraph(Node node) {
//        if(node==null)
//            return null;
//        Node[] nodes=new Node[105];
//        boolean[] visited=new boolean[105];
//
//        Node nodeNew=new Node(1);
//        nodes[1]=nodeNew;
//
//        dfs(visited,nodes,node);
//        return nodeNew;
//    }
//    public void dfs(boolean[] visited,Node[] nodes,Node node){
//        int val = node.val;
//        if(visited[val])
//            return;
//
//        visited[val]=true;
//        //新节点
//        Node nodeNew;
//        if(nodes[val]==null){
//            nodeNew=new Node(val);
//            nodes[val]=nodeNew;
//        }
//        else {
//            nodeNew=nodes[val];
//        }
//
//        //邻居全部都加进来
//        for (Node neighbor : node.neighbors) {
//            int val1 = neighbor.val;
//
//            Node nodeNew1;
//            if(nodes[val1]==null){
//                nodeNew1=new Node(val1);
//                nodes[val1]=nodeNew1;
//            }
//            else {
//                nodeNew1=nodes[val1];
//            }
//
//            nodeNew.neighbors.add(nodeNew1);
//        }
//        //访问所有邻居
//        for (Node neighbor : node.neighbors) {
//            dfs(visited,nodes,neighbor);
//        }
//    }
}

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}