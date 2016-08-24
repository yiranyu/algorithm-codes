package nowcoder;

public class GetUglyNumber {
	public static void main(String[] args) {
		System.out.println(getUglyNumber1(16));
		System.out.println(getUglyNumber(16));
	}
	/**
	 * 丑数
	 * 把只包含因子2、3和5的数称作丑数（Ugly Number）。
	 * 例如6、8都是丑数，但14不是，因为它包含因子7。 
	 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
	 * 思路：
	 * 1. 判断每一个整数是不是丑数。效率
	 * 2. 保存已经找到的丑数，时间换空间。后面的丑数是有前面丑数乘以2，3，5中的一个得来。
	 */
	public static int getUglyNumber1(int index){
		if(index<=0){
			return 0;
		}
		if(index==1){
			return 1;
		}
		int num=1;
		int count=0;
		while(index>count){
			if(isUgly(num)){
				count++;
			}
			num++;
		}
		return num-1;
	}
	public static boolean isUgly(int num){
		while(num%2==0){
			num/=2;
		}
		while(num%3==0){
			num/=3;
		}
		while(num%5==0){
			num/=5;
		}
		return num==1?true:false;
	}
	public static int getUglyNumber(int index) {
        if(index<=0){
        	return 0;
        }
        if(index==1){
        	return 1;
        }
        int arr[]=new int[index];
        arr[0]=1;
        int num2=0,num3=0,num5=0;//2,3,5的指针
        for(int i=1;i<index;i++) {
        	//前一个丑数乘以2、3、5中的最小的一个
            arr[i]=Math.min(arr[num2]*2,Math.min(arr[num3]*3,arr[num5]*5));
            if(arr[i]==arr[num2]*2){
            	num2++;
            }
            if(arr[i]==arr[num3]*3){
            	num3++;
            }
            if (arr[i]==arr[num5]*5){
            	num5++;
            }
        }
        return arr[index-1];
    }
}
