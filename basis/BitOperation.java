package basis;

public class BitOperation {
	public static void main(String[] args) {
		System.out.println(powerN(2,3));
		System.out.println(2<<3);
	}
	/**1.����λ����ʵ�ֳ˷�����
	 * ����nλ�൱�ڰѸ�������2��n�η�����˵��˷������е�ĳ��������������ص�ʱ��������λ����������˷�����
	 * @param m
	 * @param n
	 * @return
	 */
	public static int powerN(int m,int n){//m����2��n�η�
		if(n==0){
			return m;
		}
		for(int i=0;i<n;i++){//?Ϊʲô��ֱ������nλ
			m=m<<1;
		}
		return m;
	}
}
