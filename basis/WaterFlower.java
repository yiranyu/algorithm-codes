package testing;

import java.text.DecimalFormat;
import java.util.Scanner;
/**ˮ�ɻ���
�������ʻ��ļ��ڣ�ˮ�ɻ��������������˵Ĵ�����ѧ���и�ˮ�ɻ�����������������ģ�
��ˮ�ɻ�������ָһ����λ�������ĸ�λ���ֵ������͵����䱾�����磺153=1^3+5^3+3^3��
����Ҫ�����������m��n��Χ�ڵ�ˮ�ɻ�����
����
���������ж��飬ÿ��ռһ�У�������������m��n��100<=m<=n<=999����
���
����ÿ������ʵ����Ҫ����������ڸ�����Χ�ڵ�ˮ�ɻ���������˵�������ˮ�ɻ���������ڵ���m,����С�ڵ���n������ж������Ҫ���С����������һ���������֮����һ���ո����;
��������ķ�Χ�ڲ�����ˮ�ɻ����������no;
ÿ������ʵ�������ռһ�С�

 */
public class WaterFlower {
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 int n,m;
		 while(sc.hasNext()){
			 m=sc.nextInt();
			 n=sc.nextInt();
			 if(m>=100&&m<n&&n<=999){
				  handle(m,n);
			 }
			
		 }
		 sc.close();
	}
	
	
	public static void handle(int m,int n){
		int num1,num2,num3;
		boolean flag=false;
		for(int i=m;i<=n;i++){
			num1=i/100;
			num2=(i-num1*100)/10;
			num3=i%10;
			if(num1*num1*num1+num2*num2*num2+num3*num3*num3==i){
				System.out.print(i+" ");
				flag=true;
			}
		}
		if(!flag){
			System.out.print("no");
		}
		System.out.println();	
	}
}
