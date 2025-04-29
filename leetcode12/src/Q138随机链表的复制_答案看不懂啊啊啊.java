import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}


public class Q138随机链表的复制_答案看不懂啊啊啊 {
    public static void main(String[] args) {
        System.out.println(new ArrayList<>().indexOf(null));
    }
    //一波操作击败5.5%
    public Node copyRandomList(Node head) {
        List<Node> list1=new ArrayList<>();
        List<Node> list2=new ArrayList<>();
        Node dumpHead=new Node(0);
        Node pre=dumpHead;
        Node node1=head;
        while (node1!=null){
            list1.add(node1);
            Node p=new Node(node1.val);
            list2.add(p);
            pre.next=p;
            pre=p;
            node1=node1.next;
        }
        for (int x = 0; x < list1.size(); x++) {
            int i = list1.indexOf(list1.get(x).random);
            if(i==-1){
                list2.get(x).random=null;
            }
            else {
                list2.get(x).random=list2.get(i);
            }
        }
        return dumpHead.next;
    }
}

//回溯加hash基本可以看懂递归的思想
class Solution138_1 {
    Map<Node, Node> cachedNode = new HashMap<Node, Node>();

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        if (!cachedNode.containsKey(head)) {
            Node headNew = new Node(head.val);
            cachedNode.put(head, headNew);
            headNew.next = copyRandomList(head.next);
            headNew.random = copyRandomList(head.random);
        }
        return cachedNode.get(head);
    }
}

//迭代＋节点拆分看不懂
class Solution138_2 {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        for (Node node = head; node != null; node = node.next.next) {
            Node nodeNew = new Node(node.val);
            nodeNew.next = node.next;
            node.next = nodeNew;
        }
        for (Node node = head; node != null; node = node.next.next) {
            Node nodeNew = node.next;
            nodeNew.random = (node.random != null) ? node.random.next : null;
        }
        Node headNew = head.next;
        for (Node node = head; node != null; node = node.next) {
            Node nodeNew = node.next;
            node.next = node.next.next;
            nodeNew.next = (nodeNew.next != null) ? nodeNew.next.next : null;
        }
        return headNew;
    }
}






