package nowcoder;

public class TreeDepth {
	public static void main(String[] args) {
		TreeNode node=new TreeNode(1);
		TreeNode node1=new TreeNode(2);
		TreeNode node2=new TreeNode(3);
		TreeNode node3=new TreeNode(4);
		TreeNode node4=new TreeNode(5);
		node.left=node1;
		node.right=node2;
		node1.left=node3;
		node3.right=node4;
		System.out.println(treeDepth(node));
	}
	//求二叉树的深度：递归求解
	public static int treeDepth(TreeNode root) {
		if(root==null){
			return 0;
		}
		int left=treeDepth(root.left);
		int right=treeDepth(root.right);
		return left>right?left+1:right+1;
	}
}
/*
public class TreeNode {
	int val = 0;
	TreeNode left = null;
	TreeNode right = null;
	public TreeNode(int val) {
        this.val = val;
    }
};*/
