import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class Q117填充每个节点的下一个右侧节点指针II {
    public static void main(String[] args) {


    }
    //40多效率
    public Node connect(Node root) {
        if(root==null)
            return null;
        Deque<Node> deque=new ArrayDeque<>();
        deque.offer(root);
        deque.offer(null);
        while (!deque.isEmpty()){
            Node cur = deque.poll();
            if(cur==null)
                continue;
            cur.next=deque.peek();
            boolean nextLine=deque.peek()==null;
            if(cur.left!=null)
                deque.offer(cur.left);
            if(cur.right!=null)
                deque.offer(cur.right);
            if(nextLine)
                deque.offer(null);
        }
        return root;
    }
}
//last用起来，就不需要每一次求peek，效率80多

class Solution_117 {

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new ArrayDeque<Node>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            Node last = null;
            for (int i = 1; i <= n; ++i) {
                Node f = queue.poll();
                if (f.left != null) {
                    queue.offer(f.left);
                }
                if (f.right != null) {
                    queue.offer(f.right);
                }
                if (i != 1) {
                    last.next = f;
                }
                last = f;
            }
        }
        return root;
    }
}

//100还没看
class Solution117_2 {
    Node last = null, nextStart = null;

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Node start = root;
        while (start != null) {
            last = null;
            nextStart = null;
            for (Node p = start; p != null; p = p.next) {
                if (p.left != null) {
                    handle(p.left);
                }
                if (p.right != null) {
                    handle(p.right);
                }
            }
            start = nextStart;
        }
        return root;
    }

    public void handle(Node p) {
        if (last != null) {
            last.next = p;
        }
        if (nextStart == null) {
            nextStart = p;
        }
        last = p;
    }
}




//class Solution117_01 {
//
//    public Node connect(Node root) {
//        if (root == null) {
//            return null;
//        }
//        Queue<Node> queue = new ArrayDeque<Node>();
//        queue.offer(root);
//        while (!queue.isEmpty()) {
//            int n = queue.size();
//            for (int i = 1; i <= n; ++i) {
//                Node f = queue.poll();
//                if (f.left != null) {
//                    queue.offer(f.left);
//                }
//                if (f.right != null) {
//                    queue.offer(f.right);
//                }
//                if (i == n) {
//                    f.next=null;
//                }
//                else {
//                    f.next=queue.peek();
//                }
//            }
//        }
//        return root;
//    }
//}


//40多
class Solution117_02 {

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new ArrayDeque<Node>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 1; i <= n-1; ++i) {
                Node f = queue.poll();
                if (f.left != null) {
                    queue.offer(f.left);
                }
                if (f.right != null) {
                    queue.offer(f.right);
                }
                if (i == n) {
                    f.next=null;
                }
                else {
                    f.next=queue.peek();
                }
            }
        }
        return root;
    }
}



class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};