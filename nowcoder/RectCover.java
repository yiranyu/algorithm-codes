package nowcoder;
/**
 *  ���⣺���ǿ�����2*1��С���κ��Ż�������ȥ���Ǹ���ľ��Ρ�������n��2*1��С�������ص��ظ���һ��2*n�Ĵ���Σ��ܹ��ж����ַ�����
	Ҫ�㣺�������С�
	˼·�����Ժ��ŷŻ����ŷţ�����F(n)������2*(n-1)�ľ��μ�һ�����ŷŵ�2*1�ľ��λ�2*(n-2)�ľ��μ�2�����ŷŵ�2*1�ľ��Σ���F(n)=F(n-1)+F(n-2)
 * @author lab2015
 *
 */
public class RectCover {
	public static void main(String[] args) {
		System.out.println(rectCover(4));
	}
	public static int rectCover(int target) {
		if(target<=2){
			return target;
		}
		int preNum=2;
		int prePreNum=1;
		int num=0;
		for(int i=3;i<=target;i++){
			num=preNum+prePreNum;
			prePreNum=preNum;
			preNum=num;
		}
		return num;	
	}
}
