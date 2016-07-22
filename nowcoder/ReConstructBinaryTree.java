package nowcoder;
/**
 * ����ĳ��������ǰ���������������Ľ�������ؽ����ö����������������ǰ���������������Ľ���ж������ظ������֡�
 * ��������ǰ���������{1,2,4,7,3,5,6,8}�������������{4,7,2,1,5,3,8,6}�����ؽ������������ء�
 * @author lab2015
 *
 */
public class ReConstructBinaryTree {
	public static void main(String[] args) {
		int[] pre={1,2,4,7,3,5,6,8};
		int[] in={4,7,2,1,5,3,8,6};
		TreeNode node=reConstructBinaryTree(pre,in);
		printTree(node);
	}
	 public static TreeNode constructBinaryTree(int [] pre,int [] in,int preStart, int preEnd,int inStart,int inEnd) {
		 
		 TreeNode node=new TreeNode(pre[preStart]);
		 int head=0;
		 if(preStart==preEnd&&inStart==inEnd){	 
			 return node;
		 }
		 //������������ҵ�ͷ�������λ��
		 for(int i=inStart;i<=inEnd;i++){
			 if(in[i]==pre[preStart]){
				 head=i;
				 break;
			 }
		 }
		 int leftLen=head-inStart;
		 //�ع�������
		 if(leftLen>0){
			 node.left=constructBinaryTree(pre,in,preStart+1,preStart+leftLen,inStart,head-1);
		 }
		 int rightLen=inEnd-head;
		 //�ع�������
		 if(rightLen>0){
			 node.right=constructBinaryTree(pre,in,preStart+leftLen+1,preEnd,head+1,inEnd);
		 }
		 
		 return node;
	 }
	 public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
		 if(pre==null||in==null){
			 return null;
		 }
		 TreeNode node=constructBinaryTree(pre,in,0,pre.length-1,0,in.length-1);
		 return node;
	 }
	 public static void printTree(TreeNode node){
		 if(node!=null){
			 //pre
//			 System.out.print(node.val+" ");
//			 printTree(node.left);
//			 printTree(node.right);
			 
			 //in
//			 printTree(node.left);
//			 System.out.print(node.val+" ");
//			 printTree(node.right);
			 
			 //after
			 printTree(node.left);
			 printTree(node.right);
			 System.out.print(node.val+" ");
		 }
	 }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}