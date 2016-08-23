package nowcoder;

public class FindNumsAppearOnce {
	public static void main(String[] args) {
		int a[]={1,2,3,3,4,4},num1[]=new int[1],num2[]=new int[1];
		findNumsAppearOnce(a,num1,num2);
		System.out.println(num1[0]+" "+num2[0]);
	}
	/**
	 * ������ֻ����һ�ε�����
	 * һ�����������������������֮�⣬���������ֶ����������Ρ���д�����ҳ�������ֻ����һ�ε����֡�
	 *num1,num2�ֱ�Ϊ����Ϊ1�����顣��������
	 *��num1[0],num2[0]����Ϊ���ؽ��
	 */
    public static void findNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(array==null||array.length<2){
        	return;
        }
        int len=array.length;
        int resultOfOR=0;
        for(int i=0;i<len;i++){
        	resultOfOR^=array[i]; //�κ�һ��������������Ϊ0�����յõ��Ľ��������ֻ����һ�ε����������
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
    //Ѱ������num�Ķ����Ʊ�ʾ�����ұ���1��λ
	public static int findFirstBitIs1(int num) {
		int index=0;
		while((num&1)==0&&index<32){
			num=num>>1;//�޷�������һλ���൱��ȥ���ұߵ�һ��λ
			index++;
		}
		return index;
	}
	//num�Ķ����Ʊ�ʾ�д��ұ������indexλ�ǲ���1
	public static boolean isBit1(int num,int index){
		num=num>>index;
		return (num&1)==1?true:false;
	}

}
