class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Q206翻转链表 {
    //官方更简洁，和我的类似
    public ListNode reverseLis1(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null)
            return head;
        ListNode p=head;
        ListNode c=p.next;
        ListNode n=c.next;
        p.next=null;
        while (true){
            c.next=p;
            p=c;
            c=n;
            if(n==null)
                break;
            n=n.next;
        }
        return p;
    }

    //递归写法非常巧妙,难以想到，之后可以再看几遍
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

}