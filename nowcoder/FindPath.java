package nowcoder;

import java.util.ArrayList;
import java.util.Stack;

/**
 * �������к�Ϊĳһֵ��·��
����һ�Ŷ�������һ����������ӡ���������н��ֵ�ĺ�Ϊ��������������·����
·������Ϊ�����ĸ���㿪ʼ����һֱ��Ҷ����������Ľ���γ�һ��·����
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
	 * �������������·����������Ҷ������ʾһ��·��������������ʱ�жϵ�ǰ·���Ƿ�����Ҫ���������ӡ��
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
        path.add(root.val); //����ǰ�Ľ����ӵ�·����
       
        //�����Ҷ��㣬����·���ϵĺ͵��������ֵ����ӡ����·��
        if(root.left==null&&root.right==null){
        	System.out.println(target+" "+root.val);
            if(target==root.val){
                paths.add(path);//��ӵ�·������
                //��ӡ
                for(int i=0;i<path.size();i++){
                	System.out.print(path.get(i)+" ");
                }
                System.out.println("-------------------");
            }
            return;//��Ҷ��㣬��ǰ·����������
        }
        
        //����һ��·��
        ArrayList<Integer> path2=new ArrayList<>();
        path2.addAll(path);
        
        //�������Ҷ��㣬����������ӽ��
        if(root.left!=null){
        	find(paths,path,root.left,target-root.val);
        }
        if(root.right!=null){
        	find(paths,path2,root.right,target-root.val);
        }
    }
}
