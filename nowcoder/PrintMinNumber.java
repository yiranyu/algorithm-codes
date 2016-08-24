package nowcoder;

import java.util.Arrays;
import java.util.Comparator;

public class PrintMinNumber {
	public static void main(String[] args) {
		int array[]={123,3,4,12};
		System.out.println(printMinNumber(array));
	}
	/**
	 * �������ų���С����
	 * ����һ�����������飬����������������ƴ�������ų�һ������
	 * ��ӡ��ƴ�ӳ���������������С��һ����
	 * ������������{3��32��321}�����ӡ���������������ųɵ���С����Ϊ321323��
	 * ���飺�µıȽϹ��򣬴������⣨��int���ܵ��������
	 * ˼·��������ת�����ַ����ٱȽ�ƴ�ӡ�
	 * ����������£�
	 * ��ab > ba �� a > b��
	 * ��ab < ba �� a < b��
	 * ��ab = ba �� a = b��
	 */
	 public static String printMinNumber(int [] numbers) {
		 if(numbers==null||numbers.length<1){
			 return "";
		 }
		 int len=numbers.length;
		 String nums[]=new String[len];
		 
		 for(int i=0;i<len;i++){
			 nums[i]=String.valueOf(numbers[i]);
		 }
		 //������Ƚ��ַ�������
		 Arrays.sort(nums, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return (s1+s1).compareTo(s2+s1); //�ȽϺ�����ע�������ַ������ٱȽ�
			}
		});
		 String result=nums[0];
		 for(int i=1;i<len;i++){
			 result+=nums[i];
		 }
		 return result;
	 }
}
