package nowcoder;

/**
 * ������1���ֵĴ�������1��n������1���ֵĴ�����
 * ����һ������n�����1��n��n��������ʮ���Ʊ�ʾ��1���ֵĴ�������������12����1��12��Щ�����а���1�������� 1,10,11,12,1һ��������5�Ρ�
 * 
 * @author lab2015
 * 
 */
public class NumberOf1Between1AndN {

	public static void main(String[] args) {
		System.out.println(numberOf1Between1AndN(1234));
		System.out.println(numberOf1Between1AndN2(1234));
	}

	/**
	 * ��1��ֱ���㷨�������� ʱ�临�Ӷ�ΪO(n*logn)
	 * 
	 * @param n
	 * @return
	 */
	public static int numberOf1Between1AndN(int n) {
		if (n <= 0) {
			return 0;
		}
		int count = 0, cur;
		for (int i = 0; i <= n; i++) {
			cur = i;
			// ÿ������1�ĸ�����������
			while (cur > 0) {
				if (cur % 10 == 1) {
					count++;
				}
				cur = cur / 10;
			}
		}
		return count;
	}

	/**
	 * ��2�����ֹ��ɣ��ֱ���ÿһ��λ�ϵ�1���ֵĴ�������λ��ʮλ����λ��������
	 * 
	 * @param n
	 * @return
	 */
	public static int numberOf1Between1AndN2(int n) {
		if (n <= 0) {
			return 0;
		}
		//����n=1234
		int count=0;
		int bitsLen=String.valueOf(n).length(); //n�ܹ���λ����4
		if(bitsLen==1){
			return 1;
		}
		int powerOfN=(int) Math.pow(10, bitsLen-1); //����bitsLen-1��10�Ļ��������μ��㣬Ҳ����1000
		int hight=(int) (n/powerOfN); //���λ����Ϊ1
		int remain=n-hight*powerOfN; //ȥ����λʣ�µ���
		
		if(hight==1){ //���λΪ1�������λ�ϵ�1�ĸ���Ϊ234+1
			count=remain+1;
		}else{ //����n=2234,�����λ�ϵ�1�ĸ���Ϊ1000
			count=powerOfN;
		}
		
		//����235~1234�е�1�ĸ��������˵�һλ֮�⡣235~1234�й���1000������
		//ѡ������һλ��1��������λ�ϵ�����0~9ʮ����������ѡ��������ϵõ�1*3*10^2=200
		count+=hight*(bitsLen-1)*powerOfN/10; 
		//System.out.println("others="+hight*(bitsLen-1)*powerOfN/10);
		
		//�ݹ�����ߵ�����234
		count+=numberOf1Between1AndN2(remain);
		
		return count;
	}
}
