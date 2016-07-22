package nowcoder;

import java.util.ArrayList;
import java.util.Iterator;
/**
 * 从尾到头打印链表
 */
public class PrintList {
	public static ArrayList<Integer> list=new ArrayList<Integer>();
	public static void main(String[] args) {
		 ListNode node1=new ListNode(1);
		 ListNode node2=new ListNode(2);
		 ListNode node3=new ListNode(3);
		 
		 node1.next=node2;
		 node2.next=node3;
		 
		 ArrayList<Integer> a=printListFromTailToHead2(node1);
		 Iterator<Integer> iter= a.iterator();
		 while(iter.hasNext()){
			 System.out.print(iter.next()+" ");
		 }
	}
	 public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		 ArrayList<Integer> result=new ArrayList<Integer>();
		 if(listNode==null){
			 return result;
		 }
		 
		 ListNode cur=listNode;
		 ListNode next=listNode.next;
		 ListNode temp;
		 while(cur!=null&&next!=null){
			 temp=next.next;
			 next.next=cur;
			 cur=next;
			 next=temp;
		 }
		 listNode.next=null;
		 while(cur.next!=null){
			 result.add(cur.val);
			 cur=cur.next;
		 }
		 result.add(cur.val);
		 return result;
	 }
	 /**递归
	 * @param listNode
	 * @return
	 */
	public static ArrayList<Integer> printListFromTailToHead2(ListNode listNode) { 
		 if(listNode!=null){
			 printListFromTailToHead2(listNode.next);
			 list.add(listNode.val);
		 }
		 return list;
	 }
}
class ListNode {
   int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
   }
}
