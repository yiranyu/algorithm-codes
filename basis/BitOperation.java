package basis;

public class BitOperation {
	public static void main(String[] args) {
		System.out.println(powerN(2,3));
		System.out.println(2<<3);
	}
	/**1.用移位操作实现乘法运算
	 * 左移n位相当于把该数乘以2的n次方，因此当乘法运算中的某个数字满足这个特点时可以用移位操作来代替乘法操作
	 * @param m
	 * @param n
	 * @return
	 */
	public static int powerN(int m,int n){//m乘以2的n次方
		if(n==0){
			return m;
		}
		for(int i=0;i<n;i++){//?为什么不直接左移n位
			m=m<<1;
		}
		return m;
	}
}
