package nowcoder;
/**
 * ���⣺����һ���������飬ʵ��һ�����������������������ֵ�˳��ʹ�����е�����λ�������ǰ�벿�֣����е�ż��λ��λ������ĺ�벿�֣�����֤������������ż����ż��֮������λ�ò��䡣
Ҫ�㣺����������ԡ�����
 * @author Administrator
 *
 */
public class ReOrderArray {
	public static void main(String[] args) {
		int[] array={1,2,3,4,5,6,7,8,9,10};
		reOrderArray(array);
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]+" ");
		}
	}
	/**
	 * 1.Ҫ�뱣֤ԭ�д�����ֻ��˳���ƶ������ڽ�����
	 * 2.even�������ұ������ҵ���һ��ż����
	 * 3.odd��even+1��ʼ����ң�ֱ���ҵ���һ��������
	 * 4.��[even,...,odd-1]��Ԫ���������һλ������ҵ�����������evenλ�ã�Ȼ��even++��
	 * 5.��ֹ������odd����������ʧ�ܡ�
	 */
	public static void reOrderArray(int [] array) {
	    if(array==null||array.length==0)
	        return;
	    int even = 0,odd;
	    int len=array.length;
	    while(even<len){
	        while(even<len&&array[even]%2==1){//���ұ������ҵ���һ��ż��
	        	even++;
	        }
	            
	        odd = even+1;//���ұ����ҵ���һ��ż����ĵ�һ������
	        while(odd<len&&array[odd]%2==0){
	        	odd++;
	        }
	            
	        if(odd<len){
	            int temp = array[odd];
	            for (int i = odd; i >even; i--) {
	            	array[i] = array[i-1];
	            }
	            array[even++] = temp;
	        }else{
	            return;
	        }
	    }
	}

}
