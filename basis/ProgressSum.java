package testing;

import java.text.DecimalFormat;
import java.util.Scanner;
/**求数列的和
数列的第一项为n，以后各项为前一项的平方根，求数列的前m项的和。
 输入
输入数据有多组，每组占一行，由两个整数n（n<10000）和m(m<1000)组成，n和m的含义如前所述。
输出
对于每组输入数据，输出该数列的和，每个测试实例占一行，要求精度保留2位小数。

 */
public class ProgressSum {
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 int n,m;
		 while(sc.hasNext()){
			 n=sc.nextInt();
			 m=sc.nextInt();
			 System.out.println(handle(n,m));
		 }
		 sc.close();
	}
	
	
	public static String handle(int n,int m){
		DecimalFormat df=new DecimalFormat("#.00");
		double sum=n,cur=n;
		while(m>1){
			cur=Math.sqrt(cur);
			sum+=cur;
			m--;
		}
		return df.format(sum);
	}
}
