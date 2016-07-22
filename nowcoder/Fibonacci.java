package nowcoder;
/**
 * Ҫ������һ������n���������쳲��������еĵ�n�
 * 쳲��������У�Fibonacci sequence�����ֳƻƽ�ָ����С�����ѧ���а��ɶࡤ쳲�������Leonardoda Fibonacci[1]  �������ӷ�ֳΪ���Ӷ����룬
 * ���ֳ�Ϊ���������С���ָ��������һ�����У�0��1��1��2��3��5��8��13��21��34������
 * ����ѧ�ϣ�쳲��������������±��Եݹ�ķ������壺F��0��=0��F��1��=1��F��n��=F(n-1)+F(n-2)��n��2��n��N*��
 * @author lab2015
 *
 */
public class Fibonacci {
	public static void main(String[] args) {
		System.out.println(fibonacci(7));
	}
	//�ݹ飬��ʱ
	 public static int fibonacci1(int n) {
		 if(n==0){
			 return 0;
		 }else if(n==1){
			 return 1;
		 }
		 return fibonacci1(n-1)+fibonacci1(n-2);
	 }
	 //ѭ��
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
