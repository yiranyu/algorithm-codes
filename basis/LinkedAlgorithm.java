package basis;

/**
 * ����Ĳ����㷨
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
		
		//���ҵ�����k��Ԫ��
		Node temp=findElement(list.head, 2);
		System.out.print("Find the second element:");
		if(temp!=null){
			System.out.println(temp.data);
		}else{
			System.out.println("The value of index is error ");
		}
		//��ת����
		System.out.print("Reverse List:");
		list.reverseList(list.head);
		list.printList();
		//��β��ͷ���������
		System.out.print("Print list reversely:");
		printListReversely(list.head);
		System.out.println();
		//�ҵ��м�ڵ�
		temp=findMiddle(list.head);
		System.out.print("Find middle:");
		if(temp!=null){
			System.out.println(temp.data);
		}else{
			System.out.println("This is a null list");
		}
		//�ж��Ƿ��л�
		Linked loop=new Linked();
		loop.addNode(1);
		loop.addNode(2);
		loop.addNode(3);
		temp=findElement(loop.head, 1);
		//temp.next=findElement(loop.head,4);
		temp.next=loop.head;
		System.out.println("Is loop:"+isLoop(loop.head));
		System.out.println("Find loop port:"+findLoopPort(loop.head).data);
		
		//��֪��ͷ���������ɾ��ָ����㣬����ɾ��β�ڵ�
		System.out.print("Delete before:");
		list.printList();
		System.out.println("Delete:"+deleteNode(findElement(list.head, 2)));
		System.out.print("Delete after:");
		list.printList();
		
		//�ж����������Ƿ��ཻ
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
	 * ɾ���������ظ��Ľ��ֵ�����������˫��ѭ����������ѭ����������������ѭ������ѭ����ǰ�Ľ�㿪ʼ������
	 * �����뵱ǰ���ֵ��ͬ�Ľ����ɾ����
	 * @param head
	 */
	public static void deleteDuplecate(Node head){
		Node curNode=head;
		while(curNode!=null){
			Node nextNode=curNode;
			while(nextNode.next!=null){
				if(curNode.data==nextNode.next.data){
					nextNode.next=nextNode.next.next;//ɾ���ظ��Ľ��
				}else{
					nextNode=nextNode.next;
				}
			}
			curNode=curNode.next;
		}
	}
	/**(2)
	 * ���ҵ�����k��Ԫ�أ���������ָ�룬������һ��ָ������ǰ�ƶ�k-1����Ȼ������ָ��ͬʱ��ǰ�ƶ���֪�����е�ָ��ֵΪnull
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
		//��index��
		while(first!=null&&temp!=index){
			first=first.next;
			temp++;
		}
		//index���������ȵ����
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
	 * ��ת���������
	 * 1.�������еĽ���ָ�뷴ת�������ı�����ķ���
	 * 2.������������㱣�浽ջ�У������������ٵ���ջ�е�Ԫ��
	 * 3.�ݹ飺�ݹ�ı����Ͼ���һ��ջ�ṹ��ÿ���ʵ�һ����㣬�ȵݹ����������Ľ�㡣
	 * ������ʵ�ֵ�3�н������
	 * @param head
	 */
	public static void printListReversely(Node head){
		if(head!=null){
			printListReversely(head.next);
			System.out.print(" "+head.data);
		}
	}
	/**��5��
	 * ���ҵ�������м��㣺
	 * 1.���������ĳ��ȣ�Ȼ�����һ�볤�ȾͿ����ҵ��м��㡣
	 * 2.�����˫����������β���У�������ʱ���ҵ��м�Ԫ�ء�
	 * 3.����ָ��ͬʱ������ÿ��һ��ָ������������һ��ָ����һ������ָ���ȵ�����β��������ָ��ǡ�õ��������в�
	 * @param head
	 * @return
	 */
	public static Node findMiddle(Node head){
		if(head==null){
			return null;
		}
		Node first=head;
		Node second=head;
		while(first!=null&&first.next!=null&&first.next.next!=null){//�õ����е㿿���
		//while(first!=null&&first.next!=null){//�õ����е㿿�ұ�
			first=first.next.next;
			second=second.next;
		}
		return second;
	}
	/**(6)
	 * �ж�һ�������Ƿ��л�����������ָ�룬��ָ��ÿ��ǰ����������ָ��ÿ��ǰ���첽��ÿ������ָ�붼Ҫ���бȽϣ�
	 * ֱ����ָ�������ָ��Ϊֹ����֤����������Ǵ����ĵ�����������֤����������ǲ�������ѭ������
	 * 
	 * ����һ���ܹ��ڻ������������Ҵ�ʱ��ָ�뻹û���ƻ�һȦ��Ҳ����˵һ��������ָ�������һȦ֮ǰ������Ҳ����˵��
	 * ��ָ��ÿ����ǰ��һ������ָ����ǰ׷�����������ÿһ���������ָ�뵽slow�ľ���������1��������������ȥ�ͻ�ʹ��
	 * ����֮��ľ�������Сֱ������������Ϊ��ͬһ�����п�ָ�����ָ��֮��ľ��벻����ڻ��ĳ��ȣ���˵�����������ʱ��
	 * ��ָ��һ����û������һ�ܣ��������������Ժ�������������ڿ�ʼ��ʱ���ָ�����ָ�붼�ڻ�����ڴ�����
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
	 * �ж�һ�������Ƿ��л��������з��ػ������
	 * ͨ����ѧ�ƶϵ�֪�����������head��ʼ����ڵ�ľ���=����ָ��Ϳ�ָ��������㵽��ڵ�ľ�����ȡ�
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
	 * ���������һ����㣬ɾ������ڵ㣨��֪��ͷ��㣩��
	 * (1)�����������β�ڵ㣬���޷�ɾ������Ϊɾ�����޷�ʹ��ǰ���ڵ��nextָ��Ϊnull��
	 * (2)��������β�ڵ㣬����Խ��������������̽���ֵ��Ȼ��ɾ����̽�㡣
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
	/**��9��
	 * �ж����������Ƿ��ཻ
	 * ������������ཻ���������������ཻ������һ��������ͬ��β��㡣�ֱ��������������¼���ǵ�β��㣬������ǵ�
	 * β�����ͬ����ô�����������ཻ����֮���ཻ��
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
	 * �ҵ��ཻ�����ཻ�ĵ�һ�����:
	 * �����ж��Ƿ��ཻ������ཻ��������������ĳ��ȣ��ó����������ƶ�����Ĳ�����Ȼ����������ͬʱ�ƶ�
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
		//�ҳ��ϳ����������ƶ�������һ����
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
		//ͬʱ�ƶ����״����ʱΪ��һ���ཻ��
		while(temp1!=temp2){
			temp1=temp1.next;
			temp2=temp2.next;
		}
		return temp1;
	}
	
}
