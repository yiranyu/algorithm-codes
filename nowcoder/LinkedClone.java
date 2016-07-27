package nowcoder;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

/**
 * ����һ����������
 * ��ÿ��������н��ֵ���Լ�����ָ�룬һ��ָ����һ����㣬��һ������ָ��ָ������һ����㣩
 * ���ؽ��Ϊ���ƺ��������head��
 * ��ע�⣬���������벻Ҫ���ز����еĽ�����ã�������������ֱ�ӷ��ؿգ�
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
	 * ��ʹ�ø����ռ䣬ʱ�临�Ӷ�ΪO(n)
	 * @param pHead
	 * @return
	 */
	public static RandomListNode clone(RandomListNode pHead){
		if(pHead==null){
			return null;
		}
		//����ԭ�����ÿ����㣬���ƵĽ�������ԭ���֮���γ�һ��֮������
		//A->B->C,���ƺ�A->A'->B->B'->C->C'
		RandomListNode cur=pHead;
		while(cur!=null){
			RandomListNode newNode=new RandomListNode(cur.label);
			newNode.next=cur.next;
			cur.next=newNode;
			cur=newNode.next;
		}
		//������������random
		//A->A'->B->B'->C->C'������A��randomΪB����B'��random����B.next(B')
		cur=pHead;
		RandomListNode nextNode=null;
		while(cur!=null){
			nextNode=cur.next;
			if(cur.random!=null){
				nextNode.random=cur.random.next;
			}
			cur=nextNode.next;
		}
		//��ԭ�������������
		RandomListNode newHead=pHead.next; //�������ͷ���
		cur=pHead;
		while(cur.next!=null){ //ע���ָ���ж�
			nextNode=cur.next;
			cur.next=nextNode.next;
			cur=nextNode;
		}
        return newHead;
    }
	/**
	 * ʹ�ù�ϣ����½��Ľ�㱣�������������˲��ң�ʱ�临�Ӷ�ΪO(N)
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
		//�������еĽڵ�
		while(cur!=null){
			RandomListNode node=new RandomListNode(cur.label);
			nodes.put(cur, node);
			newH.next=node;
			newH=node;
			cur=cur.next;
		}
		//����random
		Iterator<Entry<RandomListNode,RandomListNode>> it=nodes.entrySet().iterator();
		while(it.hasNext()){
			Entry<RandomListNode, RandomListNode> node = it.next(); 
			//��ǰ�ڵ��value���½ڵ㣬key��ԭ��㡣�½ڵ��random=ԭ���random�ڹ�ϣ���е�value
			node.getValue().random=nodes.get(node.getKey().random);
		}
		return nodes.get(pHead);
	}
}
class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null; //ָ�������е�����һ�����

    RandomListNode(int label) {
        this.label = label;
    }
}
