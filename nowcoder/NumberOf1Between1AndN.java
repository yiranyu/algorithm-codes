package nowcoder;

/**
 * 整数中1出现的次数（从1到n整数中1出现的次数）
 * 输入一个整数n，求从1到n这n个整数的十进制表示中1出现的次数。例如输入12，从1到12这些整数中包含1的数字有 1,10,11,12,1一共出现了5次。
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
	 * （1）直观算法：求余数 时间复杂度为O(n*logn)
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
			// 每个数中1的个数用余数求
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
	 * （2）数字规律：分别求每一个位上的1出现的次数，个位、十位、百位、。。。
	 * 
	 * @param n
	 * @return
	 */
	public static int numberOf1Between1AndN2(int n) {
		if (n <= 0) {
			return 0;
		}
		//假设n=1234
		int count=0;
		int bitsLen=String.valueOf(n).length(); //n总共的位数，4
		if(bitsLen==1){
			return 1;
		}
		int powerOfN=(int) Math.pow(10, bitsLen-1); //保存bitsLen-1个10的积，避免多次计算，也就是1000
		int hight=(int) (n/powerOfN); //最高位数，为1
		int remain=n-hight*powerOfN; //去掉高位剩下的数
		
		if(hight==1){ //最高位为1，则这个位上的1的个数为234+1
			count=remain+1;
		}else{ //比如n=2234,则最高位上的1的个数为1000
			count=powerOfN;
		}
		
		//计算235~1234中的1的个数，除了第一位之外。235~1234中共有1000个数，
		//选定其中一位是1，其余两位上的数在0~9十个数中任意选择，排列组合得到1*3*10^2=200
		count+=hight*(bitsLen-1)*powerOfN/10; 
		//System.out.println("others="+hight*(bitsLen-1)*powerOfN/10);
		
		//递归求解后边的数字234
		count+=numberOf1Between1AndN2(remain);
		
		return count;
	}
}
