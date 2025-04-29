import java.util.HashSet;
import java.util.Set;

public class Q141环形链表 {
    public static void main(String[] args) {

    }
    //hash
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set=new HashSet<>();
        while (head!=null){
            if(set.contains(head))
                return true;
            set.add(head);
            head=head.next;
        }
        return false;
    }

    //快慢指针，效率比较高
    public boolean hasCycle1(ListNode head) {
        if(head==null)
            return false;
        ListNode node1=head;
        ListNode node2=head.next;
        while (node1!=node2){
            if(node2==null||node2.next==null)
                return false;
            node1=node1.next;
            node2=node2.next.next;
        }
        return true;
    }
}
