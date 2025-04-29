public class Q61旋转链表 {
    public static void main(String[] args) {

    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head==null)
            return head;
        ListNode node=head;
        int num=1;
        while (node.next!=null){
            node=node.next;
            num++;
        }
        k=k%num;
        if(k==0)
            return head;
        ListNode temp=head;
        //寻找新链表的末尾
        for(int i=1;i<=num-k-1;i++){
            temp=temp.next;
        }
        //新链表的头
        ListNode begin=temp.next;
        temp.next=null;

        //两段链表接起来
        node.next=head;
        return begin;

    }
}

//基本思想一样，细节略有不同
class Solution61_1 {
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }
        int n = 1;
        ListNode iter = head;
        while (iter.next != null) {
            iter = iter.next;
            n++;
        }
        int add = n - k % n;
        if (add == n) {
            return head;
        }
        iter.next = head;
        while (add-- > 0) {
            iter = iter.next;
        }
        ListNode ret = iter.next;
        iter.next = null;
        return ret;
    }
}

