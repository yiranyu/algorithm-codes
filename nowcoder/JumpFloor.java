package nowcoder;
/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * @author lab2015
 *
 */
public class JumpFloor {
	public static void main(String[] args) {
		System.out.println(jumpFloor(4));
	}
	/**
	 * 对于第n个台阶来说，只能从n-1或者n-2的台阶跳上来，所以
		F(n) = F(n-1) + F(n-2)
		斐波拉契数序列，初始条件
		n=1:只能一种方法
		n=2:两种
		递归一下就好了
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
