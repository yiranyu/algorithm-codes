package basis;

import java.util.LinkedList;
import java.util.List;

/**
 * ���Ļ�������
 *
 */
public class BiTree {
	
	public static void main(String[] args) {
		int[] array={1,2,3,4,5,6,7,8};
		BiTNode root=createTree(array);
		
		printTree(root);
	}
	/**���ݸ�����һ��˳��洢�ṹ����������һ����ʽ�洢��������ֵΪ0�ı�ʾ�����ڵĿս�㡣
	 * @param array
	 * @return
	 */
	public static BiTNode createTree(int[] array){
		if(array==null){
			return null;
		}
		List<BiTNode> nodeList = new LinkedList<BiTNode>(); 
		// ��һ�������ֵ����ת��ΪNode�ڵ�  
		for (int i = 0; i < array.length; i++) { 
			if(array[i]!=0){
				nodeList.add(new BiTNode(array[i]));
			}else{
				nodeList.add(null);
			}
			  
        }  
		//��ǰlastParentIndex-1�����ڵ㰴�ո��ڵ��뺢�ӽڵ�����ֹ�ϵ����������  
		for(int i=0;i<array.length/2-1;i++){
			if(nodeList.get(i)!=null){
				nodeList.get(i).lchild=nodeList.get(2*i+1);//����
				nodeList.get(i).rchild=nodeList.get(2*i+2);//�Һ���
			}
		}
		
		// ���һ�����ڵ�:��Ϊ���һ�����ڵ����û���Һ��ӣ����Ե����ó�������  
        int lastParentIndex = array.length / 2 - 1;  
        if(nodeList.get(lastParentIndex)!=null){
	        // ����  
	        nodeList.get(lastParentIndex).lchild = nodeList.get(lastParentIndex * 2 + 1);  
	        // �Һ���,�������ĳ���Ϊ�����Ž����Һ���  
	        if (array.length % 2 == 1) {  
	            nodeList.get(lastParentIndex).rchild = nodeList.get(lastParentIndex * 2 + 2);  
	        }  
        }
		return nodeList.get(0);
	}
	
	public static void printTree(BiTNode root){
		if(root==null){
			return;
		}
		System.out.println(root.data);
		printTree(root.lchild);
		printTree(root.rchild);

	}
	
}
/**
 * �ࣺ�������ڵ���
 *
 */
class BiTNode{
	int data;
	BiTNode lchild;
	BiTNode rchild;
	
	public BiTNode(int data){
		this.data=data;
		lchild=null;
		rchild=null;
	}
}

