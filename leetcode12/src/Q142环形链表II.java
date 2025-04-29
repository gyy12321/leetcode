import java.util.HashSet;
import java.util.Set;

public class Q142环形链表II {
    public static void main(String[] args) {

    }
    //方法一hash
//    public boolean hasCycle(ListNode head) {
//        Set<ListNode> set=new HashSet<>();
//        while (head!=null){
//            if(set.contains(head))
//                return true;
//            set.add(head);
//            head=head.next;
//        }
//        return false;
//    }

    //方法二，快慢指针，快和馒两个一定要从同一个起点出发
    public ListNode detectCycle(ListNode head) {
        if(head==null)
            return null;
        ListNode node1=head;
        ListNode node2=head;
        while (node2!=null){
            node1=node1.next;
            if(node2.next==null)
                return null;
            else {
                node2=node2.next.next;
            }
            if(node2==node1){
                ListNode node3=head;
                while(node3!=node1){
                    node1=node1.next;
                    node3=node3.next;
                }
                return node1;
            }
        }
        return null;

    }
}
