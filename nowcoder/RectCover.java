package nowcoder;
/**
 *  问题：我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
	要点：规律数列。
	思路：可以横着放或竖着放，所以F(n)可以是2*(n-1)的矩形加一个竖着放的2*1的矩形或2*(n-2)的矩形加2个横着放的2*1的矩形，即F(n)=F(n-1)+F(n-2)
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
