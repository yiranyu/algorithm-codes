package nowcoder;

public class GetUglyNumber {
	public static void main(String[] args) {
		System.out.println(getUglyNumber1(16));
		System.out.println(getUglyNumber(16));
	}
	/**
	 * ����
	 * ��ֻ��������2��3��5��������������Ugly Number����
	 * ����6��8���ǳ�������14���ǣ���Ϊ����������7�� 
	 * ϰ�������ǰ�1�����ǵ�һ���������󰴴�С�����˳��ĵ�N��������
	 * ˼·��
	 * 1. �ж�ÿһ�������ǲ��ǳ�����Ч��
	 * 2. �����Ѿ��ҵ��ĳ�����ʱ�任�ռ䡣����ĳ�������ǰ���������2��3��5�е�һ��������
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
        int num2=0,num3=0,num5=0;//2,3,5��ָ��
        for(int i=1;i<index;i++) {
        	//ǰһ����������2��3��5�е���С��һ��
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
