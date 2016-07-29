package nowcoder;

/**
 * ���������������
 * HZż������Щרҵ������������Щ�Ǽ����רҵ��ͬѧ����������鿪����,
 * ���ַ�����:�ڹ��ϵ�һάģʽʶ����,������Ҫ��������������������,������ȫΪ������ʱ��,����ܺý����
 * ����,��������а�������,�Ƿ�Ӧ�ð���ĳ������,�������Աߵ��������ֲ����أ�
 * ����:{6,-3,-2,7,-15,1,2,2},����������������Ϊ8(�ӵ�0����ʼ,����3��Ϊֹ)����᲻�ᱻ������ס��
 * 
 * @author lab2015
 * 
 */
public class FindGreatestSumOfSubArray {
	public static void main(String[] args) {
		int array[] = { 1, -2, 3, 10, -4, 7, 2, -5 };
		System.out.println(gindGreatestSumOfSubArray2(array));
	}

	/**
	 * ��1��ֱ���㷨��ö����������������鲢������ǵĺͣ���СΪn�����鹲��n(n+1)/2�������飬ʱ�临�Ӷ�ΪŶ��n^2��
	 * ��2����������Ĺ��ɣ���ͷ��β�ۼ������е�ÿ�����֣�������ĳһ��Ԫ��ʱ�������ǰ���ۼӺ�С���㣬Ҳ����˵֮ǰ���ۼӺͱȵ�ǰԪ�ص�ֵС��
	 * ��ô���Ǿ�û�б�Ҫ����ǰ����������ˡ�
	 * ���㷨ʵ�ֽⷨ��2��
	 * @param array
	 * @return
	 */
	public static int gindGreatestSumOfSubArray(int[] array) {
		if (array == null || array.length <= 0) {
			return 0; // ������0�������������Ч���뻹���ۼӺ�Ϊ0��
		}
		int sum = 0, greatestSum = 0x80000000; // �ۼӺͣ�����ۼӺ�
		int len = array.length;
	
		for (int i = 0; i < len; i++) {
			if (sum <= 0) { // ��ǰ��С����ʱ����ǰ���������
				sum = array[i];
			} else { // �ۼ�
				sum += array[i];
			}
			// ��������ۼӺ�
			if (sum > greatestSum) {
				greatestSum = sum;
			}
		}
		return greatestSum;
	}
	
	/**
	 * ��̬�滮����f(i)��ʾ�Ե�i�����ֽ�β�������������
	 *  f(i)=array[i] i=0����f(i-1)<=0 
	 *       f(i-1)+array[i]
	 * i������0����f(i-1)>0 ����һ���㷨һ����˼·��
	 * 
	 * @param array
	 * @return
	 */
	public static int gindGreatestSumOfSubArray2(int[] array) {
		if (array == null || array.length <= 0) {
			return 0; // ������0�������������Ч���뻹���ۼӺ�Ϊ0��
		}
		int fi = 0, maxFi = 0x80000000; // �ۼӺͣ�����ۼӺ�
		int len = array.length;
		int i = 0;
		while (i < len) {
			if (fi <= 0) { // ��ǰ��С����ʱ����ǰ���������
				fi = array[i];
			} else { // �ۼ�
				fi += array[i];
			}
			// ��������ۼӺ�
			if (fi > maxFi) {
				maxFi = fi;
			}
			i++;
		}
		return maxFi;
	}
}
