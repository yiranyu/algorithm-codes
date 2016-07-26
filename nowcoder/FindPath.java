package nowcoder;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 二叉树中和为某一值的路径
输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * @author lab2015
 *
 */
public class FindPath {
	public static void main(String[] args) {
		TreeNode node=new TreeNode(1);
		TreeNode node1=new TreeNode(2);
		TreeNode node2=new TreeNode(3);
		TreeNode node3=new TreeNode(4);
		TreeNode node4=new TreeNode(5);
		node.left=node1;
		node.right=node2;
		node1.left=node3;
		node1.right=node4;
		findPath(node,7);
	}
	/**
	 * 先序遍历，保存路径，当遇到叶结点则表示一条路径遍历结束，此时判断当前路径是否满足要求，满足则打印。
	 * @param root
	 * @param target
	 * @return
	 */
	public static ArrayList<ArrayList<Integer>> findPath(TreeNode root,int target) {
		ArrayList<ArrayList<Integer>> paths=new ArrayList<ArrayList<Integer>>();
		if(root==null){
			return paths;
		}
		
		ArrayList<Integer> path=new ArrayList<Integer>();
		find(paths,path,root,target);
		
		return paths;
	}
	public static void find(ArrayList<ArrayList<Integer>> paths,ArrayList<Integer> path,TreeNode root,int target){
        path.add(root.val); //将当前的结点添加到路径中
       
        //如果是叶结点，并且路径上的和等于输入的值，打印这条路径
        if(root.left==null&&root.right==null){
        	System.out.println(target+" "+root.val);
            if(target==root.val){
                paths.add(path);//添加到路径集中
                //打印
                for(int i=0;i<path.size();i++){
                	System.out.print(path.get(i)+" ");
                }
                System.out.println("-------------------");
            }
            return;//到叶结点，当前路径遍历结束
        }
        
        //复制一份路径
        ArrayList<Integer> path2=new ArrayList<>();
        path2.addAll(path);
        
        //如果不是叶结点，则遍历它的子结点
        if(root.left!=null){
        	find(paths,path,root.left,target-root.val);
        }
        if(root.right!=null){
        	find(paths,path2,root.right,target-root.val);
        }
    }
}
