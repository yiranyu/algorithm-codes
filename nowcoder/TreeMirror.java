package nowcoder;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * 二叉树的镜像定义：源二叉树 
    	    8
    	   /  \
    	  6   10
    	 / \  / \
    	5  7 9 11
    	镜像二叉树
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
	 * 先序遍历树的每个节点，如果遍历到的结点有子节点，就交换它们的两个子结点。当交换完所有非叶子结点的左右子结点后，就得到了数的镜像。
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
	   
	    //左右子树不为null则交换
	    TreeNode temp=root.left;
	    root.left=root.right;
	    root.right=temp;
	    //左遍历
	    if(root.left!=null){
	    	mirror(root.left);
	    }
	    //右遍历
	    if(root.right!=null){
	    	mirror(root.right);
	    }
	}
	//非递归实现
	public static void mirror2(TreeNode root) {
		if(root==null){
	    	return;
	    }
	   //使用一个队列来存储要遍历的子树
	    Queue<TreeNode> q=new LinkedList<TreeNode>();
	    TreeNode cur,temp;
	    q.add(root);
	    
	    //左右子树不为null则交换
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
