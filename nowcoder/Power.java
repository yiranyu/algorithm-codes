package nowcoder;
/**
 * ����һ��double���͵ĸ�����base��int���͵�����exponent����base��exponent�η���
 * @author Administrator
 *
 */
public class Power {
	public static void main(String[] args) {
		System.out.println(power(0,0));
	}
	/**
	 * 1.ȫ�濼��ָ���������������Ƿ�Ϊ��������
	 * 2.д��ָ���Ķ����Ʊ�����13���Ϊ������1101��
	 * 3.����:10^1101 = 10^0001*10^0100*10^1000��
	 * 4.ͨ��&1��>>1����λ��ȡ1101��Ϊ1ʱ����λ����ĳ����۳˵����ս����
	 */
	public double power1(double base, int n) {
	    double res = 1,curr = base;
	    int exponent;
	    if(n>0){
	        exponent = n;
	    }else if(n<0){
	        if(base==0)
	            throw new RuntimeException("��ĸ����Ϊ0"); 
	        exponent = -n;
	    }else{// n==0
	        return 1;// 0��0�η�
	    }
	    while(exponent!=0){
	        if((exponent&1)==1)
	            res*=curr;
	        curr*=curr;// ����
	        exponent>>=1;// ����һλ
	    }
	    return n>=0?res:(1/res);       
	}
	public static double power(double base, int exponent) {
		if(exponent==0){
			return 1;
		}
		boolean isNegative=false;
		double sum=base;
		if(exponent<0){
			isNegative=true;
			exponent*=-1;
		}
		for(int i=1;i<exponent;i++){
			sum*=base;
		}
		if(isNegative){
			sum=1/sum;
		}
		
		return sum;
	}
}
