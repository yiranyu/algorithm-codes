package nowcoder;
/**
 * ���������������������������������ϳɺ��������Ȼ������Ҫ�ϳɺ���������㵥����������
 * @author Administrator
 *
 */
public class MergeList {
	public static void main(String[] args) {
		ListNode node1=new ListNode(1);
		ListNode node2=new ListNode(2);
		ListNode node3=new ListNode(3);
		ListNode node4=new ListNode(4);
		ListNode node5=new ListNode(5);
		ListNode node6=new ListNode(6);
		node1.next=node2;
		node2.next=node4;
		node3.next=node5;
		node5.next=node6;
		
		ListNode temp=merge(node1,node3);
		
		while(temp!=null){
			System.out.print(temp.val+" ");
			temp=temp.next;
		}
	}
	 public static ListNode merge(ListNode list1,ListNode list2) {
		 if(list1==null){
			 return list2;
		 }
		 if(list2==null){
			 return list1;
		 }
		 
		 ListNode m,cur;
		 //�ҵ��ϲ���head���
		 if(list1.val>list2.val){
			 m=list2;
			 list2=list2.next;
		 }else{
			 m=list1;
			 list1=list1.next;
		 }
		 cur=m;//����head���
		 
		 //����
		 while(list1!=null&&list2!=null){
			 if(list1.val>list2.val){
				 cur.next=list2;
				 list2=list2.next;
			 }else{
				 cur.next=list1;
				 list1=list1.next;
			 }
			 cur=cur.next;
		 }
		 
		 //ʣ����ֱ�ӷ���
		 if(list1!=null){
			 cur.next=list1;
		 }
		 if(list2!=null){
			 cur.next=list2;
		 }
		 return m;
	 }
}
