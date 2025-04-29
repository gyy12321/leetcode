public class Q82删除排序链表中的重复元素II {
    public static void main(String[] args) {

    }
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyNode=new ListNode(-1);
        //pre用来连接所有符合要求的节点
        ListNode pre=dummyNode;
        ListNode cur=head;
        while (cur!=null){
            ListNode r=cur;
            //找到和cur的val相同的最远的元素位置r
            while (r.next!=null&&r.next.val==cur.val){
                r=r.next;
            }
            //只有一个元素
            if(r==cur){
                pre.next=cur;
                //原本这一句也忘了
                //更新pre位置，从而顺利连接下一个有效元素
                pre=cur;
            }
            //跳过当前以及之后的重复元素，到达新的不同元素，因为r就是用于遍历相同元素的
            cur=r.next;
        }
        //少了这一句出错
        pre.next=null;
        return dummyNode.next;
    }
}

//答案解法有所不同
class Solution82_1 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }

/*        具体地，我们从指针 cur 指向链表的哑节点，随后开始对链表进行遍历。
        如果当前 cur.next 与 cur.next.next 对应的元素相同，那么我们就需要将 cur.next
    以及所有后面拥有相同元素值的链表节点全部删除。我们记下这个元素值 x，随后不断将 cur.next 从链表中移除，
        直到 cur.next 为空节点或者其元素值不等于 x 为止。此时，我们将链表中所有元素值为 x 的节点全部删除。*/


        ListNode dummy = new ListNode(0, head);

        ListNode cur = dummy;
        //用一个指针穿线，跨过所有相同的元素
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }

        return dummy.next;
    }
}

