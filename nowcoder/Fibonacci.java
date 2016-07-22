package nowcoder;
/**
 * 要求输入一个整数n，请你输出斐波那契数列的第n项。
 * 斐波那契数列（Fibonacci sequence），又称黄金分割数列、因数学家列昂纳多·斐波那契（Leonardoda Fibonacci[1]  ）以兔子繁殖为例子而引入，
 * 故又称为“兔子数列”，指的是这样一个数列：0、1、1、2、3、5、8、13、21、34、……
 * 在数学上，斐波纳契数列以如下被以递归的方法定义：F（0）=0，F（1）=1，F（n）=F(n-1)+F(n-2)（n≥2，n∈N*）
 * @author lab2015
 *
 */
public class Fibonacci {
	public static void main(String[] args) {
		System.out.println(fibonacci(7));
	}
	//递归，超时
	 public static int fibonacci1(int n) {
		 if(n==0){
			 return 0;
		 }else if(n==1){
			 return 1;
		 }
		 return fibonacci1(n-1)+fibonacci1(n-2);
	 }
	 //循环
	 public static int fibonacci(int n) {
		 if(n<=1){
			 return n;
		 }
		 int preNum=1;
		 int prePreNum=0;
		 int num=0;
		 for(int i=2;i<=n;i++){
			 num=preNum+prePreNum;
			 prePreNum=preNum;
			 preNum=num;
		 }
		 return num;
	 }
}
