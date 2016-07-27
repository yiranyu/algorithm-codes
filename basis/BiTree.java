package basis;

import java.util.LinkedList;
import java.util.List;

/**
 * 树的基本操作
 *
 */
public class BiTree {
	
	public static void main(String[] args) {
		int[] array={1,2,3,4,5,6,7,8};
		BiTNode root=createTree(array);
		
		printTree(root);
	}
	/**根据给定的一个顺序存储结构的树，构造一个链式存储树。数组值为0的表示不存在的空结点。
	 * @param array
	 * @return
	 */
	public static BiTNode createTree(int[] array){
		if(array==null){
			return null;
		}
		List<BiTNode> nodeList = new LinkedList<BiTNode>(); 
		// 将一个数组的值依次转换为Node节点  
		for (int i = 0; i < array.length; i++) { 
			if(array[i]!=0){
				nodeList.add(new BiTNode(array[i]));
			}else{
				nodeList.add(null);
			}
			  
        }  
		//对前lastParentIndex-1个父节点按照父节点与孩子节点的数字关系建立二叉树  
		for(int i=0;i<array.length/2-1;i++){
			if(nodeList.get(i)!=null){
				nodeList.get(i).lchild=nodeList.get(2*i+1);//左孩子
				nodeList.get(i).rchild=nodeList.get(2*i+2);//右孩子
			}
		}
		
		// 最后一个父节点:因为最后一个父节点可能没有右孩子，所以单独拿出来处理  
        int lastParentIndex = array.length / 2 - 1;  
        if(nodeList.get(lastParentIndex)!=null){
	        // 左孩子  
	        nodeList.get(lastParentIndex).lchild = nodeList.get(lastParentIndex * 2 + 1);  
	        // 右孩子,如果数组的长度为奇数才建立右孩子  
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
 * 类：二叉树节点类
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

