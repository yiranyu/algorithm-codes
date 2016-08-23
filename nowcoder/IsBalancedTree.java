package nowcoder;

public class IsBalancedTree {
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
		System.out.println(isBalanced(node));
	}
	/**
	 * ƽ�������
	 * ����һ�ö��������жϸö������Ƿ���ƽ�������(�������������������1)
	 *1. �ݹ����:ÿһ����㱻�ظ�������Ρ�ʱ��Ч�ʲ���
	 *2. ÿ�����ֻ����һ�Σ�����ÿ������ʱ���¼������ȣ�һ�߱���һ���ж�ÿ������ǲ���ƽ��
	 */
	public static boolean isBalancedTree1(TreeNode root) {
		if(root==null){
			return true;
		}
		int left=treeDepth(root.left);
		int right=treeDepth(root.right);
		int diff=left-right;
		if(diff>1||diff<-1){
			return false;
		}
		return isBalancedTree1(root.left)&&isBalancedTree1(root.right);
	}
	public static boolean isBalanced(TreeNode root) {
        int depth[]=new int[1];
        return isBalancedTree(root,depth);
    }
	//��һ������Ϊ1���������洢��ǰ�߶�
	public static boolean isBalancedTree(TreeNode root,int depth[]) {
		if(root==null){
			depth[0]=0;
			return true;
		}
		int left[]=new int[1],right[]=new int[1];
		if(isBalancedTree(root.left,left)&&isBalancedTree(root.right,right)){
			int diff=left[0]-right[0];
			if(diff<=1&&diff>=-1){
				depth[0]=1+(left[0]>right[0]?left[0]:right[0]);
				return true;
			}
		}
		
		return false;
	}
	//�����������ȣ��ݹ����
	public static int treeDepth(TreeNode root) {
		if(root==null){
			return 0;
		}
		int left=treeDepth(root.left);
		int right=treeDepth(root.right);
		return left>right?left+1:right+1;
	}
}
