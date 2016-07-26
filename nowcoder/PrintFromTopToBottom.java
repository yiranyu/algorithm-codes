package nowcoder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/**
 * �������´�ӡ����������ÿ����㣬ͬ����������Ҵ�ӡ��
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
	 * ���Ĳ�α���
	 * @param root
	 * @return
	 */
	 public static ArrayList<Integer> printFromTopToBottom(TreeNode root) {
		 ArrayList<Integer> array= new ArrayList<Integer>();
		 if(root==null){
			 return array;
		 }
		 
		 Queue<TreeNode> queue=new LinkedList<TreeNode>();//��������
		 queue.add(root);
		 TreeNode cur=null;
		 
		 //�����в�Ϊ��ʱһֱѭ��
		 while(!queue.isEmpty()){
			 cur=queue.poll(); //����
			 array.add(cur.val); //��ӡ
			 System.out.println(cur.val);
			 //�����ǰ��������Һ��ӣ��������
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