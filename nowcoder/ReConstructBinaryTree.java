package nowcoder;
/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
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
		 //在中序遍历中找到头结点所在位置
		 for(int i=inStart;i<=inEnd;i++){
			 if(in[i]==pre[preStart]){
				 head=i;
				 break;
			 }
		 }
		 int leftLen=head-inStart;
		 //重构左子树
		 if(leftLen>0){
			 node.left=constructBinaryTree(pre,in,preStart+1,preStart+leftLen,inStart,head-1);
		 }
		 int rightLen=inEnd-head;
		 //重构右子树
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