public class Q24两两交换链表中的节点 {
    public static void main(String[] args) {

    }

    public ListNode swapPairs(ListNode head) {
        if(head==null)
            return null;
        if(head.next==null)
            return head;
//        ListNode pre=head;
//        ListNode p=head.next;
//        ListNode next=head.next.next;
//        p.next=pre;
//        pre.next=swapPairs(next);
//        return p;
        ListNode p=head.next;
        head.next=swapPairs(p.next);
        p.next=head;
        return p;
    }



    //尝试迭代写法
    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre=head;
        ListNode p=head.next;
        ListNode dump=new ListNode(0);
        ListNode headNew=dump;
        while (true){
            dump.next=p;
            pre.next=p.next;
            p.next=pre;
            dump=pre;
            pre=pre.next;
            if(pre==null)
                return headNew.next;
            p=pre.next;
            if(p==null)
                return headNew.next;
        }
    }


    //方法一，答案和我的这种几乎没有区别
    public ListNode swapPairs1(ListNode head) {
        //递归结束的条件
        if (head == null || head.next == null) {
            return head;
        }
        //拼接
        ListNode newHead = head.next;
        head.next = swapPairs(newHead.next);
        newHead.next = head;
        return newHead;
    }

    //方法二，答案的迭代写法更优雅
    //dummy节点和结合图像理解是关键
    public ListNode swapPairs3(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode temp = dummyHead;
        while (temp.next != null && temp.next.next != null) {
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;
            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            temp = node1;
        }
        return dummyHead.next;
    }



}
