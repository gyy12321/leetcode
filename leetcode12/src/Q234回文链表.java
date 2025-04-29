import java.util.*;

//方法二和方法三之后有机会再看吧，懒得看了
public class Q234回文链表 {
    public static void main(String[] args) {

    }
    public boolean isPalindrome(ListNode head) {
        //int[] nodes=new int[100003];
        ListNode node=head;
        List<ListNode> list=new ArrayList<>();
        while (node!=null){
            list.add(node);
            node=node.next;
        }
        int size = list.size();
        for(int i=0;i<=size/2-1;++i){
            if(list.get(i).val!=list.get(size-1-i).val)
                return false;
        }
        return true;
    }

    //稍微快一些
    public boolean isPalindrome1(ListNode head) {
        int[] nodes=new int[100003];
        int length=0;
        while (head!=null){
            nodes[length++]=head.val;
            head=head.next;
        }
        for(int i=0;i<=length/2-1;++i){
            if(nodes[i]!=nodes[length-1-i])
                return false;
        }
        return true;
    }


    //方法二递归写法，方法三快慢指针之后再看。这两个效率都不是特别高
}
