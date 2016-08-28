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
	 * 和为S的连续正数序列
	 * 题目描述
	 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
	 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
	 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
	 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
	 * 输出描述:
	 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
	 * 思路：small和big分别表示序列的最小值和最大值。如果当前序列小于s，增大big；如果大于s，减小small。
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
		
		while(small<middle){ //连续序列和至少要2个数，最小的数不会超过middle
			//找到一个序列
			if(curSum==sum){
				addToList(result,small,big);
			}
			//找到当前big的下的组合
			while(curSum>sum&&small<middle){
				curSum-=small; //逐渐去掉small
				small++;
				if(curSum==sum){
					addToList(result,small,big);
				}
			}
			//增加big
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
