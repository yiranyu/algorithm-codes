package nowcoder;
/**
 * 输入两颗二叉树A，B，判断B是不是A的子结构。
 * @author lab2015
 *
 */
public class HasSubtree {
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
		
		TreeNode tree21=new TreeNode(2);
		TreeNode tree41=new TreeNode(4);
		tree21.left=tree41;
		
		
		System.out.println(hasSubtree(tree1,tree21));
				
	}
	public static boolean hasSubtree(TreeNode root1,TreeNode root2) {
        boolean result=false;
	    //遍历树：在root1中查找与root2根节点的值相同的结点
	    if(root1!=null&&root2!=null){
	    	//找到相同的结点，判断树的结构是否相同
	    	if(root1.val==root2.val){
	    		result=isSubtree(root1,root2);
	    	}
	    	if(!result){
	    		result=hasSubtree(root1.left,root2);//在左子树中查找
	    	}
	    	if(!result){
	    		result=hasSubtree(root1.right,root2);//在右子树中查找
	    	}
	    }
		return result;
	}
	
	public static boolean isSubtree(TreeNode root1, TreeNode root2) {
		if(root2==null){
	    	return true;
	    }
	    if(root1==null){
	    	return false;
	    }
	    if(root1.val!=root2.val){
	    	return false;
	    }
		return isSubtree(root1.left,root2.left)&&isSubtree(root1.right,root2.right);
	}
}
