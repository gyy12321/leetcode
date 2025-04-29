import java.util.ArrayList;
import java.util.List;

public class Q86分隔链表 {
    public static void main(String[] args) {

    }

    //效率也是100.但明显自己想复杂了
    public ListNode partition(ListNode head, int x) {
        List<ListNode> listLess=new ArrayList<>();
        List<ListNode> listEqualBigger=new ArrayList<>();

        ListNode node=head;
        while (node!=null){
            if(node.val<x){
                listLess.add(node);
                while (node.next!=null&&node.next.val<x){
                    node=node.next;
                }
                ListNode temp=node;
                node=node.next;
                temp.next=null;
            }
            else {
                listEqualBigger.add(node);
                while (node.next!=null&&node.next.val>=x){
                    node=node.next;
                }
                ListNode temp=node;
                node=node.next;
                temp.next=null;
            }
        }
        if(listLess.size()==0)
            return head;


        ListNode res=new ListNode(-1);
        ListNode help=res;
        for (ListNode node1 : listLess) {
            help.next=node1;
            while (help.next!=null)
                help=help.next;
        }
        for (ListNode node2 : listEqualBigger) {
            help.next=node2;
            while (help.next!=null)
                help=help.next;
        }
        return res.next;

    }
    //good
    public ListNode partition1(ListNode head, int x) {
        //val小的序列
        ListNode begin1=new ListNode(-1);
        ListNode node1=begin1;
        //val大的序列
        ListNode begin2=new ListNode(-1);
        ListNode node2=begin2;
        //head不断后移，遍历每一个节点
        while (head != null) {
            int val = head.val;
            //head接入到begin1这个序列
            if(val<x){
                node1.next=head;
                node1=node1.next;
            }
            //接入begin2
            else {
                node2.next=head;
                node2=node2.next;
            }
            head=head.next;
        }
        //连接val小的序列和val大的序列
        node1.next=begin2.next;
        //大序列最后一个节点指向null
        node2.next=null;
        //返回答案
        return begin1.next;

    }
}

//我的第二种做法学习了答案思路，其实很简单，和答案一模一样
class Solution86_1 {
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode smallHead = small;
        ListNode large = new ListNode(0);
        ListNode largeHead = large;
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        large.next = null;
        small.next = largeHead.next;
        return smallHead.next;
    }
}

