import java.util.HashSet;
import java.util.Set;

//class ListNode {
//      int val;
//      ListNode next;
//      ListNode(int x) {
//          val = x;
//          next = null;
//      }
//}

//
public class Q160相交列表 {
    //效率低
//    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        ListNode A=headA;
//        ListNode B=headB;
//        while(A!=null){
//            B=headB;
//            while(B!=null){
//                if(B==A)
//                    return B;
//                B=B.next;
//            }
//            A=A.next;
//        }
//        return null;
//    }
//    //借助hash表
//    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
//        Set<ListNode> set=new HashSet<>();
//        while (headA!=null){
//            set.add(headA);
//            headA=headA.next;
//        }
//        while (headB!=null){
//            if(set.contains(headB))
//                return headB;
//            headB=headB.next;
//        }
//        return null;
//    }
//
//    //good双指针法
//    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
//        ListNode A=headA;
//        ListNode B=headB;
//        if(A==null||B==null)
//            return null;
//        while (A!=B){
//            if(A!=null)
//                A=A.next;
//            else
//                A=headB;
//            if(B!=null)
//                B=B.next;
//            else
//                B=headA;
//        }
//        return A;
//    }
    //或者先求出两者的长度差，最后先把长的遍历几个，然后再一起遍历

}
