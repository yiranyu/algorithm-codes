package nowcoder;
/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * @author lab2015
 *
 */
public class JumpFloorII {
	public static void main(String[] args) {
		System.out.println(jumpFloorII(5));
	}
	/**
	 * 每个台阶都有跳与不跳两种情况（除了最后一个台阶），最后一个台阶必须跳。所以共用2^(n-1)中情况
	 * 1级有1种，2级有2种，3级有4种，之后每多一级台阶都有之前的两种走法，n级有2的n-1种跳法
	 * f(n)=2^(n-1); 用"左移"实现 //具体分析如下：

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
