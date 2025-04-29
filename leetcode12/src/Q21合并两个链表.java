public class Q21合并两个链表 {
    public static void main(String[] args) {

    }
    //自己写的
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode p1=list1;
        ListNode p2=list2;
        ListNode prehead=new ListNode();
        ListNode pre=prehead;
        while (true){
            if(p1==null){
                pre.next=p2;
                break;
            }
            if(p2==null){
                pre.next=p1;
                break;
            }
            if (p1.val<=p2.val){
                pre.next=p1;
                p1=p1.next;
            }
            else {
                pre.next=p2;
                p2=p2.next;
            }
            pre=pre.next;
        }
        return prehead.next;
    }

}

//方法一递归写法，巧妙，没想出来
class Solution21_1 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}


//和我的几乎一样
class Solution21_2 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);
        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }
}

