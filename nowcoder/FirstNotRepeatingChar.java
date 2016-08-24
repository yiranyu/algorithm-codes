package nowcoder;

public class FirstNotRepeatingChar {
	public static void main(String[] args) {
		String str="1122ddd3345540";
		int index=firstNotRepeatingChar(str);
		System.out.println(index);
		if(index!=-1){
			System.out.println(str.charAt(index));
		}
	}
	/**
	 * �ҳ��ַ����е�һ��ֻ����һ�ε��ַ���λ��
	 * ����һ���ַ�,��Сд��ĸ���;���һ���ַ�
	 * ˼·���ַ���һ�����ݳ���Ϊ8�����ͣ��ܹ���256�ֿ��ܡ��½�һ���򵥵Ĺ�ϣ��洢�ַ����ֵĴ���
	 * ��һ��ɨ����¹�ϣ�����ַ����ֵĴ������ڶ���ɨ��Ѱ��Ŀ�ꡣ
	 */
	public static int firstNotRepeatingChar(String str){
		if ( str.length() == 0)
            return -1;
         
        int hash[] = new int[256]; //�򵥹�ϣ��
        for(int i =0;i<str.length();i++){
        	hash[str.charAt(i)]++; //�����ַ���ASCII�洢����ִ���
        }
        int index=-1;
        for(int i=0;i<str.length();i++){
            if(hash[str.charAt(i)] == 1){
                index=i;
                break;
            }	
        }
        return index;
    }
}
