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
	 * ��������ĵ�һ���������
	 * �������������ҳ����ǵĵ�һ��������㡣
	 * ���������й�����㣬��ô���������������������β����
	 * 1.���������ڵ�һ��������˳�����ÿ����㣬ÿ������һ�����ʱ���ڵڶ���������˳�����ÿ����㡣ʱ�临�Ӷ�O(mn)��
	 * 2.���ø���ջ�����������ջ�У�ջ��Ϊ����β��㣻�Ƚ�����ջ���Ľ���Ƿ���ͬ�������ͬ�����ջ�������Ƚ���һ��ջ����
	 * ֱ���ҵ����һ����ͬ�Ľ�㡣ʱ�临�Ӷ�O(m+n),�ռ临�Ӷ�O(m+n)��
	 * 3.���ó��Ȳ���ȱ�����������õ����ȣ��õ��ϳ��������k����㣻Ȼ���ȱ����ϳ�������k���������������һ���ߣ����ҵ���һ����ͬ�Ľ��
	 * ʱ�������ǵĹ�����㡣ʱ�临�Ӷ�O(m+n)��
	 */
	//�����ַ�������
	public static ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		if(pHead1==null||pHead2==null){
			return null;
		}
		int len1=0,len2=0,k;
		ListNode p1=pHead1,p2=pHead2;
		//����������ĳ��Ȳ�
		while(p1!=null){
			len1++;
			p1=p1.next;
		}
		while(p2!=null){
			len2++;
			p2=p2.next;
		}
		//p1Ϊ������p2Ϊ�϶�����kΪ�䳤�Ȳ�
		if(len1>len2){
			k=len1-len2;
			p1=pHead1;
			p2=pHead2;
		}else{
			k=len2-len1;
			p1=pHead2;
			p2=pHead1;
		}
		//����������k��
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