package nowcoder;
/**
 * �����������ĺ����������
 * ����һ���������飬�жϸ������ǲ���ĳ�����������ĺ�������Ľ����
 * ����������Yes,�������No���������������������������ֶ�������ͬ��
 * @author lab2015
 *
 */
public class VerifySquenceOfBST {
	public static void main(String[] args) {
		int a[]={5};
		System.out.println(verifySquenceOfBST(a));
	}
	/**
	 * ����������ص㣺��������õ��������У����һ�����������ĸ�����ֵ��������ǰ������ֿ��Է�Ϊ�������֣�
	 * ��һ���������������ģ����ǵ�ֵ���ȸ�����ֵС���ڶ�����������������ֵ�����Ƕ��ȸ�����ֵ��
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
		
		//�ڶ����������������Ľ��С�ڸ����
		int i=begin;
		for(;i<end;i++){
			if(sequence[i]>root){
				break;
			}
		}
		//�ڶ����������������Ľ����ڸ����
		int j=i;
		for(;j<end;j++){
			if(sequence[j]<root){//����ҵ�һ���ȸ����С�ģ������
				return false;
			}
		}
		boolean left=true;
		boolean right=true;
		//�ж��������ǲ��Ƕ���������
		if(i>begin+1){
			left=verify(sequence,begin,i-1);
		}
		//�ж��������ǲ��Ƕ���������
		if(i<end-1){
			right=verify(sequence,i,end-1);
		}
		return left&&right;
	}
}
