package basis;

/**
 * 链表的操作算法
 * @author lab2015
 *
 */
public class LinkedAlgorithm {
	public static void main(String[] args) {
		Linked list=new Linked();
		list.addNode(6);
		list.addNode(3);
		list.addNode(8);
		list.addNode(6);
		list.addNode(7);
		list.addNode(5);
		list.addNode(10);
		System.out.print("Original:");
		list.printList();
		
		deleteDuplecate(list.head);
		System.out.print("Delete duplecate:");
		list.printList();
		
		//查找倒数第k个元素
		Node temp=findElement(list.head, 2);
		System.out.print("Find the second element:");
		if(temp!=null){
			System.out.println(temp.data);
		}else{
			System.out.println("The value of index is error ");
		}
		//反转链表
		System.out.print("Reverse List:");
		list.reverseList(list.head);
		list.printList();
		//从尾到头输出单链表
		System.out.print("Print list reversely:");
		printListReversely(list.head);
		System.out.println();
		//找到中间节点
		temp=findMiddle(list.head);
		System.out.print("Find middle:");
		if(temp!=null){
			System.out.println(temp.data);
		}else{
			System.out.println("This is a null list");
		}
		//判断是否有环
		Linked loop=new Linked();
		loop.addNode(1);
		loop.addNode(2);
		loop.addNode(3);
		temp=findElement(loop.head, 1);
		//temp.next=findElement(loop.head,4);
		temp.next=loop.head;
		System.out.println("Is loop:"+isLoop(loop.head));
		System.out.println("Find loop port:"+findLoopPort(loop.head).data);
		
		//不知道头结点的情况下删除指定结点，不能删除尾节点
		System.out.print("Delete before:");
		list.printList();
		System.out.println("Delete:"+deleteNode(findElement(list.head, 2)));
		System.out.print("Delete after:");
		list.printList();
		
		//判断两个链表是否相交
		Linked list2=new Linked();
		list2.addNode(9);
		System.out.println("Is intersect:"+isIntersect(list.head, list2.head));
		findElement(list2.head, 1).next=findElement(list.head,3);
		System.out.println("Is intersect:"+isIntersect(list.head, list2.head));
		list.printList();
		list2.printList();
		System.out.println("Intersect node:"+getFirstMeet(list.head, list2.head).data);
	}
	
	/**(1)
	 * 删除链表中重复的结点值：对链表进行双重循环遍历，外循环正常遍历链表，内循环从外循环当前的结点开始遍历，
	 * 遇到与当前结点值相同的结点则删除。
	 * @param head
	 */
	public static void deleteDuplecate(Node head){
		Node curNode=head;
		while(curNode!=null){
			Node nextNode=curNode;
			while(nextNode.next!=null){
				if(curNode.data==nextNode.next.data){
					nextNode.next=nextNode.next.next;//删除重复的结点
				}else{
					nextNode=nextNode.next;
				}
			}
			curNode=curNode.next;
		}
	}
	/**(2)
	 * 查找倒数第k个元素：设置两个指针，首先让一个指针先往前移动k-1步，然后两个指针同时往前移动，知道先行的指针值为null
	 * @param index
	 * @return
	 */
	public static Node findElement(Node head,int index){
		if(index<1){
			return null;
		}
		Node first=head;
		Node second=head;
		int temp=0;
		//走index步
		while(first!=null&&temp!=index){
			first=first.next;
			temp++;
		}
		//index大于链表长度的情况
		if(first==null&&temp!=index){
			return null;
		}
		while(first!=null){
			first=first.next;
			second=second.next;
		}
		return second;
	}
	/**(4)
	 * 反转输出单链表
	 * 1.将链表中的结点的指针反转过来，改变链表的方法
	 * 2.遍历链表，将结点保存到栈中，遍历结束后再弹出栈中的元素
	 * 3.递归：递归的本质上就是一个栈结构，每访问到一个结点，先递归输出它后面的结点。
	 * 本方法实现第3中解决方案
	 * @param head
	 */
	public static void printListReversely(Node head){
		if(head!=null){
			printListReversely(head.next);
			System.out.print(" "+head.data);
		}
	}
	/**（5）
	 * 查找单链表的中间结点：
	 * 1.先求解链表的长度，然后遍历一半长度就可以找到中间结点。
	 * 2.如果是双链表，可以首尾并行，当相遇时就找到中间元素。
	 * 3.两个指针同时遍历，每次一个指针走两步，另一个指针走一步，快指针先到链表尾部，而慢指针恰好到达链表中部
	 * @param head
	 * @return
	 */
	public static Node findMiddle(Node head){
		if(head==null){
			return null;
		}
		Node first=head;
		Node second=head;
		while(first!=null&&first.next!=null&&first.next.next!=null){//拿到的中点靠左边
		//while(first!=null&&first.next!=null){//拿到的中点靠右边
			first=first.next.next;
			second=second.next;
		}
		return second;
	}
	/**(6)
	 * 判断一个链表是否有环：定义两个指针，快指针每次前进两步，慢指针每次前进异步，每次两个指针都要进行比较，
	 * 直到快指针等于慢指针为止，就证明这个链表是带环的单向链表，否则，证明这个链表是不带环的循环链表。
	 * 
	 * 二者一定能够在环上相遇，并且此时慢指针还没有绕环一圈，也就是说一定是在慢指针走完第一圈之前相遇。也就是说，
	 * 慢指针每次向前走一步，快指针向前追了两步，因此每一步操作后快指针到slow的距离缩短了1步，这样继续下去就会使得
	 * 两者之间的距离逐渐缩小直到相遇。又因为在同一个环中快指针和慢指针之间的距离不会大于环的长度，因此到二者相遇的时候
	 * 慢指针一定还没有走完一周（或者正好走完以后，这种情况出现在开始的时候快指针和慢指针都在环的入口处）。
	 * @param head
	 * @return
	 */
	public static boolean isLoop(Node head){
		if(head==null){
			return false;
		}
		Node fast=head;
		Node slow=head;
		while(fast!=null&&fast.next!=null){
			fast=fast.next.next;
			slow=slow.next;
			if(fast==slow){
				return true;
			}
		}
		return !(fast==null||fast.next==null);
	}
	/**(7)
	 * 判断一个链表是否有环，如有有返回环的入口
	 * 通过数学推断得知，从链表起点head开始到入口点的距离=从慢指针和快指针的相遇点到入口点的距离相等。
	 * @param head
	 * @return
	 */
	public static Node findLoopPort(Node head){
		if(head==null){
			return null;
		}
		Node fast=head;
		Node slow=head;
		while(fast!=null&&fast.next!=null){
			slow=slow.next;
			fast=fast.next.next;
			if(slow==fast){
				break;
			}
		}
		if(fast==null&&fast.next==null){
			return null;
		}
		slow=head;
		while(slow!=fast){
			slow=slow.next;
			fast=fast.next;
		}
		return slow;
	}
	/**(8)
	 * 给点链表的一个结点，删除这个节点（不知道头结点）：
	 * (1)如果这个结点是尾节点，则无法删除，因为删除后无法使其前驱节点的next指向为null。
	 * (2)果果不是尾节点，则可以交换这个结点与其后继结点的值，然后删除后继结点。
	 * @param node
	 * @return
	 */
	public static boolean deleteNode(Node node){
		if(node==null||node.next==null){
			return false;
		}
		int temp=node.data;
		node.data=node.next.data;
		node.next.data=temp;
		node.next=node.next.next;
		return true;
	}
	/**（9）
	 * 判断两个链表是否相交
	 * 如果两个链表相交，无论是在哪里相交，它们一定有着相同的尾结点。分别遍历两个链表，记录它们的尾结点，如果它们的
	 * 尾结点相同，那么这两个链表相交，反之不相交。
	 * @param head1
	 * @param head2
	 * @return
	 */
	public static boolean isIntersect(Node head1,Node head2){
		if(head1==null||head2==null){
			return false;
		}
		Node p=head1;
		Node q=head2;
		while(p.next!=null){
			p=p.next;
		}
		while(q.next!=null){
			q=q.next;
		}
		return p==q;
	}
	/**(10)
	 * 找到相交链表相交的第一个结点:
	 * 首先判断是否相交，如果相交，计算两个链表的长度，让长的链表先移动多出的步数，然后两个链表同时移动
	 * @param head1
	 * @param head2
	 * @return
	 */
	public static Node getFirstMeet(Node head1,Node head2){
		if(head1==null||head2==null){
			return null;
		}
		Node p=head1;
		Node q=head2;
		int len1=1,len2=1;
		
		while(p.next!=null){
			p=p.next;
			len1++;
		}
		while(q.next!=null){
			q=q.next;
			len2++;
		}
		if(p!=q){
			return null;
		}
		
		Node temp1=head1;
		Node temp2=head2;
		//找出较长的链表，先移动长的那一部分
		if(len1>len2){
			int d=len1-len2;
			while(d!=0){
				temp1=temp1.next;
				d--;
			}
		}else{
			int d=len2-len1;
			while(d!=0){
				temp2=temp2.next;
				d--;
			}
		}
		//同时移动，首次相等时为第一个相交点
		while(temp1!=temp2){
			temp1=temp1.next;
			temp2=temp2.next;
		}
		return temp1;
	}
	
}
