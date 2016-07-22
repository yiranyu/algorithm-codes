package nowcoder;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ���������Ķ�����������任ΪԴ�������ľ���
 * �������ľ����壺Դ������ 
    	    8
    	   /  \
    	  6   10
    	 / \  / \
    	5  7 9 11
    	���������
    	    8
    	   /  \
    	  10   6
    	 / \  / \
    	11 9 7  5
 * @author lab2015
 *
 */
public class TreeMirror {
	public static void main(String[] args) {
		TreeNode tree1=new TreeNode(1);
		TreeNode tree2=new TreeNode(2);
		TreeNode tree3=new TreeNode(3);
		TreeNode tree4=new TreeNode(4);
		TreeNode tree5=new TreeNode(5);
		tree1.left=tree2;
		tree1.right=tree3;
		tree2.left=tree4;
		tree2.right=tree5;
		
		mirror(tree2);
		System.out.println();
		mirror2(tree2);
	}
	/**
	 * �����������ÿ���ڵ㣬����������Ľ�����ӽڵ㣬�ͽ������ǵ������ӽ�㡣�����������з�Ҷ�ӽ��������ӽ��󣬾͵õ������ľ���
	 * @param root
	 */
	public static void mirror(TreeNode root) {
	    if(root==null){
	    	return;
	    }
	    System.out.print(root.val+" ");
	    if(root.left==null&&root.right==null){
	    	return;
	    }
	   
	    //����������Ϊnull�򽻻�
	    TreeNode temp=root.left;
	    root.left=root.right;
	    root.right=temp;
	    //�����
	    if(root.left!=null){
	    	mirror(root.left);
	    }
	    //�ұ���
	    if(root.right!=null){
	    	mirror(root.right);
	    }
	}
	//�ǵݹ�ʵ��
	public static void mirror2(TreeNode root) {
		if(root==null){
	    	return;
	    }
	   //ʹ��һ���������洢Ҫ����������
	    Queue<TreeNode> q=new LinkedList<TreeNode>();
	    TreeNode cur,temp;
	    q.add(root);
	    
	    //����������Ϊnull�򽻻�
	    while(!q.isEmpty()){
	    	cur=q.remove();
		    System.out.print(cur.val+" ");
	    	if(cur.left!=null&&cur.right!=null){
	    		temp=cur.left;
	    		cur.left=cur.right;
	    		cur.right=temp;
			    
			    q.add(cur.left);
			    q.add(cur.right);
	    	}
	    }//end while
	}
}
