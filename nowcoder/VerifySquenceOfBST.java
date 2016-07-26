package nowcoder;
/**
 * 二叉搜索树的后序遍历序列
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 * @author lab2015
 *
 */
public class VerifySquenceOfBST {
	public static void main(String[] args) {
		int a[]={5};
		System.out.println(verifySquenceOfBST(a));
	}
	/**
	 * 后序遍历的特点：后序遍历得到的序列中，最后一个数字是树的根结点的值，数组中前面的数字可以分为两个部分：
	 * 第一部分是左子树结点的，它们的值都比根结点的值小；第二部分是右子树结点的值，它们都比根结点的值大。
	 * @param sequence
	 * @return
	 */
	public static boolean verifySquenceOfBST(int [] sequence) {
		return verify(sequence,0,sequence.length-1);
	}
	public static boolean verify(int [] sequence,int begin,int end) {
		if(sequence==null ||begin>end){
			return false;
		}
		int root=sequence[end];
		
		//在二叉搜索树左子树的结点小于根结点
		int i=begin;
		for(;i<end;i++){
			if(sequence[i]>root){
				break;
			}
		}
		//在二叉搜索树右子树的结点大于根结点
		int j=i;
		for(;j<end;j++){
			if(sequence[j]<root){//如果找到一个比根结点小的，则结束
				return false;
			}
		}
		boolean left=true;
		boolean right=true;
		//判断左子树是不是二叉搜索树
		if(i>begin+1){
			left=verify(sequence,begin,i-1);
		}
		//判断右子树是不是二叉搜索树
		if(i<end-1){
			right=verify(sequence,i,end-1);
		}
		return left&&right;
	}
}
