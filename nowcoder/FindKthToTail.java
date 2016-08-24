package nowcoder;

public class FindKthToTail {
	public static void main(String[] args) {
		ListNode node1=new ListNode(1);
		ListNode node2=new ListNode(2);
		ListNode node3=new ListNode(3);
		ListNode node4=new ListNode(4);
		ListNode node5=new ListNode(5);
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		node4.next=node5;
		
		System.out.println(findKthToTail(node1,2).val);
	}
	/**
	 *  问题：输入一个链表，输出该链表中倒数第k个结点。
		要点：链表。
		思路：分配两个指针，一个指针先遍历到第k个节点，然后第二个指针开始遍历；当第一个指针到尾时，第二个指针刚好到倒数第k个结点。
	 *
	 */
    public static ListNode findKthToTail(ListNode head,int k) {
    	if(head==null){
    		return null;
    	}
    	ListNode first=head,second=head;
    	while(k>0&&first!=null){
    		k--;
    		first=first.next;
    	}
    	if(k>0){
    		return null;
    	}
    	while(first!=null){
    		first=first.next;
    		second=second.next;
    	}
    	return second;
    }
    
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
