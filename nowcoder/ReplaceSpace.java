package nowcoder;
/**
 * ���⣺��ʵ��һ����������һ���ַ����еĿո��滻�ɡ�%20�������磬���ַ���ΪWe Are Happy.�򾭹��滻֮����ַ���ΪWe%20Are%20Happy��
 * @author lab2015
 *
 */
public class ReplaceSpace {
	public static void main(String[] args) {
		System.out.println(replaceSpace2(new StringBuffer("12 34 56")));
	}
	public static String replaceSpace(StringBuffer str) {
		String result=str.toString();
		result=result.replaceAll("\\s", "%20");
		return result; 	
	}
	public static String replaceSpace2(StringBuffer str) {
		int len=str.length();
		StringBuffer result=new StringBuffer(len);
		char c;
		for(int i=0;i<len;i++){
			c=str.charAt(i);
			if(String.valueOf(c).equals(" ")){
				result.append("%20");
			}else{
				result.append(String.valueOf(c));
			}
		}
		return result.toString(); 	
	}
}
