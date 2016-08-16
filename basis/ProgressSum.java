package testing;

import java.text.DecimalFormat;
import java.util.Scanner;
/**�����еĺ�
���еĵ�һ��Ϊn���Ժ����Ϊǰһ���ƽ�����������е�ǰm��ĺ͡�
 ����
���������ж��飬ÿ��ռһ�У�����������n��n<10000����m(m<1000)��ɣ�n��m�ĺ�����ǰ������
���
����ÿ���������ݣ���������еĺͣ�ÿ������ʵ��ռһ�У�Ҫ�󾫶ȱ���2λС����

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
