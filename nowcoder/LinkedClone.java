package nowcoder;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 输入一个复杂链表
 * （每个结点中有结点值，以及两个指针，一个指向下一个结点，另一个特殊指针指向任意一个结点）
 * 返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的结点引用，否则判题程序会直接返回空）
 * @author lab2015
 *
 */
public class LinkedClone {
	public static void main(String[] args) {
		RandomListNode node1=new RandomListNode(1);
		RandomListNode node2=new RandomListNode(2);
		RandomListNode node3=new RandomListNode(3);
		//--------1->2->3
		//random--3  1
		node1.next=node2;
		node2.next=node3;
		node1.random=node3;
		node2.random=node1;
		
		RandomListNode newHead=clone2(node1);
		while(newHead!=null){
			System.out.print(newHead.label);
			if(newHead.random!=null){
				System.out.print(" random:"+newHead.random.label);
			}
			System.out.println();
			newHead=newHead.next;
		}
	}
	/**
	 * 不使用辅助空间，时间复杂度为O(n)
	 * @param pHead
	 * @return
	 */
	public static RandomListNode clone(RandomListNode pHead){
		if(pHead==null){
			return null;
		}
		//复制原链表的每个结点，复制的结点添加在原结点之后，形成一个之字链表
		//A->B->C,复制后：A->A'->B->B'->C->C'
		RandomListNode cur=pHead;
		while(cur!=null){
			RandomListNode newNode=new RandomListNode(cur.label);
			newNode.next=cur.next;
			cur.next=newNode;
			cur=newNode.next;
		}
		//遍历链表，更新random
		//A->A'->B->B'->C->C'，假设A的random为B，则B'的random就是B.next(B')
		cur=pHead;
		RandomListNode nextNode=null;
		while(cur!=null){
			nextNode=cur.next;
			if(cur.random!=null){
				nextNode.random=cur.random.next;
			}
			cur=nextNode.next;
		}
		//将原链表和新链表拆分
		RandomListNode newHead=pHead.next; //新链表的头结点
		cur=pHead;
		while(cur.next!=null){ //注意空指针判定
			nextNode=cur.next;
			cur.next=nextNode.next;
			cur=nextNode;
		}
        return newHead;
    }
	/**
	 * 使用哈希表把新建的结点保存下来，避免了查找，时间复杂度为O(N)
	 * @param pHead
	 * @return
	 */
	public static RandomListNode clone2(RandomListNode pHead){
		if(pHead==null){
			return null;
		}
		HashMap<RandomListNode,RandomListNode> nodes=new HashMap<RandomListNode,RandomListNode>();
		RandomListNode cur=pHead.next;
		RandomListNode newH=new RandomListNode(pHead.label);
		nodes.put(pHead, newH);
		//复制所有的节点
		while(cur!=null){
			RandomListNode node=new RandomListNode(cur.label);
			nodes.put(cur, node);
			newH.next=node;
			newH=node;
			cur=cur.next;
		}
		//设置random
		Iterator<Entry<RandomListNode,RandomListNode>> it=nodes.entrySet().iterator();
		while(it.hasNext()){
			Entry<RandomListNode, RandomListNode> node = it.next(); 
			//当前节点的value是新节点，key是原结点。新节点的random=原结点random在哈希表中的value
			node.getValue().random=nodes.get(node.getKey().random);
		}
		return nodes.get(pHead);
	}
}
class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null; //指向链表中的随意一个结点

    RandomListNode(int label) {
        this.label = label;
    }
}
