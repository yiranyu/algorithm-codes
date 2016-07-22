package nowcoder;
/**
 * һֻ����һ�ο�������1��̨�ף�Ҳ��������2���������������һ��n����̨���ܹ��ж�����������
 * @author lab2015
 *
 */
public class JumpFloor {
	public static void main(String[] args) {
		System.out.println(jumpFloor(4));
	}
	/**
	 * ���ڵ�n��̨����˵��ֻ�ܴ�n-1����n-2��̨��������������
		F(n) = F(n-1) + F(n-2)
		쳲����������У���ʼ����
		n=1:ֻ��һ�ַ���
		n=2:����
		�ݹ�һ�¾ͺ���
	 * @param target
	 * @return
	 */
	 public static int jumpFloor(int target) {
		 if(target<=2){
			 return target;
		 }
		 int prePreSum=1;
		 int preSum=2;
		 int sum=0;
		 for(int i=3;i<=target;i++){
			 sum=preSum+prePreSum;
			 prePreSum=preSum;
			 preSum=sum;
		 }
		 return sum;
	 }
}
