package nowcoder;
/**
 * 	问题：输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
	要点：位运算。
	思路：。
 * @author Administrator
 *
 */
public class NumberOf1 {
	public static void main(String[] args) {
		System.out.println(numberOf1(-1));
		System.out.println( Integer.bitCount(-1) );
	}
	/**
	 * 把一个整数减去1，再和原整数做与运算，会把该整数最右边一个1变成0.那么一个整数的二进制有多少个1，就可以进行多少次这样的操作。
	 * java中负数本身就用补码表示
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
