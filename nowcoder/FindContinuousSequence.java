package nowcoder;

import java.util.ArrayList;

public class FindContinuousSequence {
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> result=findContinuousSequence(100);
		for(int i=0;i<result.size();i++){
			ArrayList<Integer> seq=result.get(i);
			for(int j=0;j<seq.size();j++){
				System.out.print(seq.get(j)+" ");
			}
			System.out.println();
		}
	}
	/**
	 * ��ΪS��������������
	 * ��Ŀ����
	 * С����ϲ����ѧ,��һ����������ѧ��ҵʱ,Ҫ������9~16�ĺ�,�����Ͼ�д������ȷ����100��
	 * ���������������ڴ�,�����뾿���ж������������������еĺ�Ϊ100(���ٰ���������)��
	 * û���,���͵õ���һ������������Ϊ100������:18,19,20,21,22��
	 * ���ڰ����⽻����,���ܲ���Ҳ�ܿ���ҳ����к�ΪS��������������? Good Luck!
	 * �������:
	 * ������к�ΪS�������������С������ڰ��մ�С�����˳�����м䰴�տ�ʼ���ִ�С�����˳��
	 * ˼·��small��big�ֱ��ʾ���е���Сֵ�����ֵ�������ǰ����С��s������big���������s����Сsmall��
	 */
	public static ArrayList<ArrayList<Integer>> findContinuousSequence(int sum) {
		ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
		if(sum<3){
			return result;
		}
		int small=1;
		int big=2;
		int middle=(1+sum)/2;
		int curSum=small+big;
		
		while(small<middle){ //�������к�����Ҫ2��������С�������ᳬ��middle
			//�ҵ�һ������
			if(curSum==sum){
				addToList(result,small,big);
			}
			//�ҵ���ǰbig���µ����
			while(curSum>sum&&small<middle){
				curSum-=small; //��ȥ��small
				small++;
				if(curSum==sum){
					addToList(result,small,big);
				}
			}
			//����big
			big++;
			curSum+=big;
		}
		return result;
	}
	public static void addToList(ArrayList<ArrayList<Integer>> result, int small, int big){
		ArrayList<Integer> seq=new ArrayList<Integer>();
		for(int i=small;i<=big;i++){
			seq.add(i);
		}
		result.add(seq);
	}
}
