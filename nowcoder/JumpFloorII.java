package nowcoder;
/**
 * һֻ����һ�ο�������1��̨�ף�Ҳ��������2��������Ҳ��������n���������������һ��n����̨���ܹ��ж�����������
 * @author lab2015
 *
 */
public class JumpFloorII {
	public static void main(String[] args) {
		System.out.println(jumpFloorII(5));
	}
	/**
	 * ÿ��̨�׶������벻������������������һ��̨�ף������һ��̨�ױ����������Թ���2^(n-1)�����
	 * 1����1�֣�2����2�֣�3����4�֣�֮��ÿ��һ��̨�׶���֮ǰ�������߷���n����2��n-1������
	 * f(n)=2^(n-1); ��"����"ʵ�� //����������£�

		f(n)=f(n-1)+f(n-2)+...+f(1)+1
		f(n-1)=f(n-2)+...+f(1)+1
		...
		f(1) = 1
		 
		so:
		f(n)=2*f(n-1)
		f(n-1)=2*f(n-2)
		f(n-2)=2*f(n-3)
	 * @param target
	 * @return
	 */
	public static int jumpFloorII(int target) {
		if(target<=2){
			return target;
		}
		int sum=1;
		for(int i=1;i<target;i++){
			sum=sum*2;
		}
		return sum;
		//return 1<<(target-1);
    }
}
