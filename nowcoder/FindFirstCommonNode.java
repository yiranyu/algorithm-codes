package nowcoder;

public class FindFirstCommonNode {
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
		ListNode t=findFirstCommonNode(node5,node4);
		if(t!=null){
			System.out.println(t.val);
		}else{
			System.out.println("null");
		}
		
	}
	/**
	 * 两个链表的第一个公共结点
	 * 输入两个链表，找出它们的第一个公共结点。
	 * 两个链表有公共结点，那么公共结点出现在两个链表的尾部。
	 * 1.蛮力法：在第一个链表上顺序遍历每个结点，每遍历到一个结点时，在第二个链表上顺序遍历每个结点。时间复杂度O(mn)。
	 * 2.利用辅助栈：将链表存入栈中，栈顶为链表尾结点；比较两个栈顶的结点是否相同，如果相同，则把栈顶弹出比较下一个栈顶，
	 * 直到找到最后一个相同的结点。时间复杂度O(m+n),空间复杂度O(m+n)。
	 * 3.利用长度差：首先遍历两个链表得到长度，得到较长的链表多k个结点；然后先遍历较长的链表k步，随后两个链表一起走，当找到第一个相同的结点
	 * 时就是它们的公共结点。时间复杂度O(m+n)。
	 */
	//第三种方法代码
	public static ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		if(pHead1==null||pHead2==null){
			return null;
		}
		int len1=0,len2=0,k;
		ListNode p1=pHead1,p2=pHead2;
		//求两个链表的长度差
		while(p1!=null){
			len1++;
			p1=p1.next;
		}
		while(p2!=null){
			len2++;
			p2=p2.next;
		}
		//p1为长链表，p2为较短链表，k为其长度差
		if(len1>len2){
			k=len1-len2;
			p1=pHead1;
			p2=pHead2;
		}else{
			k=len2-len1;
			p1=pHead2;
			p2=pHead1;
		}
		//长链表先走k步
		while(k>0){
			p1=p1.next;
			k--;
		}
		while(p1!=null&&p2!=null){
			if(p1==p2){
				return p1;
			}
			p1=p1.next;
			p2=p2.next;
		}
		return null;
	}
}
/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/