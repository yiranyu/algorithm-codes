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
	 *  ���⣺����һ����������������е�����k����㡣
		Ҫ�㣺����
		˼·����������ָ�룬һ��ָ���ȱ�������k���ڵ㣬Ȼ��ڶ���ָ�뿪ʼ����������һ��ָ�뵽βʱ���ڶ���ָ��պõ�������k����㡣
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
