package nowcoder;
/**
 * 输入一个链表，反转该链表，返回反转后的链表head
 * @author Administrator
 *
 */
public class ReverseList {
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
		
		ListNode temp=node1;
		while(temp!=null){
			System.out.print(temp.val+" ");
			temp=temp.next;
		}
		System.out.println();
		temp=reverseList(node1);
		while(temp!=null){
			System.out.print(temp.val+" ");
			temp=temp.next;
		}
		while(node1!=null){
			System.out.print(node1.val+" ");
			node1=node1.next;
		}
	}
	public static ListNode reverseList(ListNode head) {
		if(head==null){
			return null;
		}
		
		ListNode cur=head;
		ListNode next=cur.next;
		ListNode nextNext;
		
		cur.next=null;
		while(next!=null){
			nextNext=next.next;
			next.next=cur;
			cur=next;
			next=nextNext;
		}
		
		return cur;
    }
}




