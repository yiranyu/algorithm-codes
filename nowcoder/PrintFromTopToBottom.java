package nowcoder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/**
 * 从上往下打印出二叉树的每个结点，同层结点从左至右打印。
 * @author lab2015
 *
 */
public class PrintFromTopToBottom {
	public static void main(String[] args) {
		TreeNode node=new TreeNode(0);
		TreeNode node1=new TreeNode(1);
		TreeNode node2=new TreeNode(2);
		TreeNode node3=new TreeNode(3);
		TreeNode node4=new TreeNode(4);
		node.left=node1;
		node.right=node2;
		node2.left=node3;
		node2.right=node4;
		printFromTopToBottom(node2);
	}
	/**
	 * 树的层次遍历
	 * @param root
	 * @return
	 */
	 public static ArrayList<Integer> printFromTopToBottom(TreeNode root) {
		 ArrayList<Integer> array= new ArrayList<Integer>();
		 if(root==null){
			 return array;
		 }
		 
		 Queue<TreeNode> queue=new LinkedList<TreeNode>();//辅助队列
		 queue.add(root);
		 TreeNode cur=null;
		 
		 //当队列不为空时一直循环
		 while(!queue.isEmpty()){
			 cur=queue.poll(); //出队
			 array.add(cur.val); //打印
			 System.out.println(cur.val);
			 //如果当前结点有左右孩子，则将其入队
			 if(cur.left!=null){
				 queue.add(cur.left);
			 }
			 if(cur.right!=null){
				 queue.add(cur.right);
			 }
		 }
		 return array;
	 }
}
/**
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/