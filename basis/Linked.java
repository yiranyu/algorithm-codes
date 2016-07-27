package basis;

public class Linked {
	Node head=null;
	/**�������в�������
	 * @param d
	 */
	public void addNode(int d){
		Node newNode=new Node(d);
		if(head==null){
			head=newNode;
			return;
		}
		Node temp=head;
		while(temp.next!=null){
			temp=temp.next;
		}
		temp.next=newNode;
	}
	/**
	 * ɾ����index���ڵ�
	 * @param index
	 * @return
	 */
	public Boolean deleteNode(int index){
		if(index<1||index>length()){
			return false;
		}
		if(index==1){
			head=head.next;
			return true;
		}
		int i=1;
		Node preNode=head;
		Node curNode=preNode.next;
		while(curNode!=null){
			if(i==index){
				preNode.next=curNode.next;
				return true;
			}
			preNode=curNode;
			curNode=curNode.next;
			i++;
		}
		return true;
	}
	/**
	 * ������ĳ���
	 * @return length
	 */
	public int length() {
		int length=0;
		Node temp=head;
		while(temp!=null){
			length++;
			temp=temp.next;
		}
		return length;
	}
	/**
	 * �������������ð������
	 * @return head
	 */
	public Node orderList(){
		Node nextNode=null;
		int temp=0;
		Node curNode=head;
		while(curNode.next!=null){
			nextNode=curNode.next;
			while(nextNode!=null){
				if(curNode.data>nextNode.data){
					temp=nextNode.data;
					nextNode.data=curNode.data;
					curNode.data=temp;
				}
				nextNode=nextNode.next;
			}
			curNode=curNode.next;
		}
		return head;
	}
	/**
	 * ��ӡ����
	 */
	public void printList(){
		Node temp=head;
		while(temp!=null){
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
		System.out.println();
	}
	public static void main(String[] args) {
		Linked list=new Linked();
		list.addNode(4);
		list.addNode(3);
		list.addNode(8);
		list.addNode(1);
		list.printList();
		list.orderList();
		list.printList();
	}
	/**(3)
	 * ��ת����:��Ҫ����ָ���ָ���ڵ���ָ��ָ��ʱҪ��һ����ʱָ�뱣����һ���ڵ㡣
	 * @param head
	 */
	public void reverseList(Node head){
		Node prepNode=null;
		Node pNode=head;
		Node pNext=null;
		
		while(pNode!=null){
			pNext=pNode.next;
			if(pNext==null){
				this.head=pNode;
			}
			pNode.next=prepNode;
			prepNode=pNode;
			pNode=pNext;
			
		}
	}
	
}
class Node{
	Node next=null;
	int data;
	public Node(int data){
		this.data=data;
	}
}