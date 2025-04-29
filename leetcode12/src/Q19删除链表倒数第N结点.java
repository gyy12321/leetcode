import java.util.Deque;
import java.util.LinkedList;

public class Q19删除链表倒数第N结点 {
    public static void main(String[] args) {

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre=head;
        ListNode p=pre;
        //一个指针先走n步
        for (int i = 0; i < n; i++) {
            p=p.next;
        }
        if(p==null)
            return head.next;
        //两个指针一起走，直到p走到头，此时两者相差n距离
        while (p.next!=null){
            pre=pre.next;
            p=p.next;
        }
        //做处理
        pre.next=pre.next.next;
        return head;
    }
}

//计算链表长度，最基础方法
class Solution19_1 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        int length = getLength(head);
        ListNode cur = dummy;
        for (int i = 1; i < length - n + 1; ++i) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        ListNode ans = dummy.next;
        return ans;
    }

    public int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            ++length;
            head = head.next;
        }
        return length;
    }
}

//利用栈
class Solution19_2 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        Deque<ListNode> stack = new LinkedList<ListNode>();
        ListNode cur = dummy;
        //全部节点入栈
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        //最后n个出栈
        for (int i = 0; i < n; ++i) {
            stack.pop();
        }
        //做处理
        ListNode prev = stack.peek();
        prev.next = prev.next.next;
        //跳过第一个辅助的假节点
        ListNode ans = dummy.next;
        return ans;
    }
}

//双指针，思想和我的比较像
class Solution19_3 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode first = head;
        ListNode second = dummy;
        for (int i = 0; i < n; ++i) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        ListNode ans = dummy.next;
        return ans;
    }
}





