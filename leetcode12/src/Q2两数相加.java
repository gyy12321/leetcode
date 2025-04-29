public class Q2两数相加 {
    public static void main(String[] args) {

    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode preHead=new ListNode();
        ListNode pre=preHead;
        int jinwei=0;
        while (!(l1==null&&l2==null)){
            //两者位数不同，其中一个已经处理完，且当前进位也是0，直接把另一个街道后面
            //官方答案没有这一步，比如123+3423535时候，官方需要走完循环，我可以提早退出。但我的需要每次判断一下，属于各有优势
            if(l1==null&&jinwei==0){
                pre.next=l2;
                break;
            }
            if(l2==null&&jinwei==0){
                pre.next=l1;
                break;
            }

            //加入l1已经处理完，则补0
            int a=l1!=null?l1.val:0;
            int b=l2!=null?l2.val:0;
            int temp=a+b+jinwei;
            pre.next=new ListNode(temp%10);
            jinwei=temp/10;
            //把答案的链表接起来
            pre=pre.next;
            //处理下一位
            if(l1!=null)
                l1=l1.next;
            if(l2!=null)
                l2=l2.next;
        }
        //最后一个进位也处理一下，比如555+555的最高位就是进位，这一点容易遗忘
        if(jinwei==1)
            pre.next=new ListNode(1);

        return preHead.next;
    }


}

//标准答案写法，跟我的比较像
class Solution2_1 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }
}

//网友优雅的递归写法，也是击败100%
class Solution2_sp {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return add(l1, l2, 0);
    }

    /**
     返回两个链表相加的头部
     */
    public ListNode add(ListNode l1, ListNode l2, int bit) {
        if (l1 == null && l2 == null && bit == 0) {
            return null;
        }
        int val = bit;
        if (l1 != null) {
            val += l1.val;
            l1 = l1.next;
        }
        if (l2 != null) {
            val += l2.val;
            l2 = l2.next;
        }
        ListNode node = new ListNode(val % 10);
        node.next = add(l1, l2, val / 10);
        return node;
    }
}
