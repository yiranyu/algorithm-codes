package nowcoder;
/**
 * 	���⣺����һ��������������������Ʊ�ʾ��1�ĸ��������и����ò����ʾ��
	Ҫ�㣺λ���㡣
	˼·����
 * @author Administrator
 *
 */
public class NumberOf1 {
	public static void main(String[] args) {
		System.out.println(numberOf1(-1));
		System.out.println( Integer.bitCount(-1) );
	}
	/**
	 * ��һ��������ȥ1���ٺ�ԭ�����������㣬��Ѹ��������ұ�һ��1���0.��ôһ�������Ķ������ж��ٸ�1���Ϳ��Խ��ж��ٴ������Ĳ�����
	 * java�и���������ò����ʾ
	 * @param n
	 * @return
	 */
	public static int  numberOf1(int n) {
//        if(n<0){
//        	n*=-1;
//        }
		int count=0;
        for(count=0;n!=0;count++){
        	n=n&(n-1);
        }
		return count;
    }
}
