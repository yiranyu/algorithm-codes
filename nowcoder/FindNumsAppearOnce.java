package nowcoder;

public class FindNumsAppearOnce {
	public static void main(String[] args) {
		int a[]={1,2,3,3,4,4},num1[]=new int[1],num2[]=new int[1];
		findNumsAppearOnce(a,num1,num2);
		System.out.println(num1[0]+" "+num2[0]);
	}
	/**
	 * 数组中只出现一次的数字
	 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
	 *num1,num2分别为长度为1的数组。传出参数
	 *将num1[0],num2[0]设置为返回结果
	 */
    public static void findNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(array==null||array.length<2){
        	return;
        }
        int len=array.length;
        int resultOfOR=0;
        for(int i=0;i<len;i++){
        	resultOfOR^=array[i]; //任何一个数异或操作本身为0，最终得到的结果是两个只出现一次的数的异或结果
        }
        int indexof1=findFirstBitIs1(resultOfOR);
        num1[0]=num2[0]=0;
        for(int j=0;j<len;j++){
        	if(isBit1(array[j],indexof1)){
        		num1[0]^=array[j];
        	}else{
        		num2[0]^=array[j];
        	}
        }
    }
    //寻找整数num的二进制表示中最右边是1的位
	public static int findFirstBitIs1(int num) {
		int index=0;
		while((num&1)==0&&index<32){
			num=num>>1;//无符号右移一位，相当于去掉右边的一个位
			index++;
		}
		return index;
	}
	//num的二进制表示中从右边数起的index位是不是1
	public static boolean isBit1(int num,int index){
		num=num>>index;
		return (num&1)==1?true:false;
	}

}
