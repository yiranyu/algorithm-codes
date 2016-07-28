package nowcoder;

import java.util.ArrayList;
import java.util.Collections;

/**
 * �ַ��������� ����һ���ַ���,���ֵ����ӡ�����ַ������ַ����������С����������ַ���abc,
 * ���ӡ�����ַ�a,b,c�������г����������ַ���abc,acb,bac,bca,cab��cba�� ����밴��ĸ˳�������
 * ��������:����һ���ַ���,���Ȳ�����9(�������ַ��ظ�),�ַ�ֻ������Сд��ĸ��
 * 
 * @author lab2015
 * 
 */
public class CharRank {
	public static void main(String[] args) {
		String str="abc";
		ArrayList<String> list=permutation(str);
		System.out.println(list.size());
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
	}
	public static ArrayList<String> permutation(String str) {
		ArrayList<String> list = new ArrayList<String>();
		int length = str.length();
		char[] array = str.toCharArray();
		if (str == null || str.length() == 0) {
			return list;
		}

		permutation(list, array, 0, length);
		Collections.sort(list); // ����ĸ˳�����
		return list;
	}
	/**
	 * ���ַ�����Ϊ�������֣�һ�������ַ����ĵ�һ���ַ�����һ�������ǵ�һ���ַ��Ժ�������ַ���
	 * ��ڶ������ַ��������У�
	 * �õ�һ���ַ�������ߵ��ַ������������
	 */
	public static void permutation(ArrayList<String> list, char[] array,
			int begin, int end) {
		//���ֻʣ�����һ���ַ�
		if (begin == end - 1) {
			String result = new String(array);
			if (!list.contains(result)) {
				list.add(result);
				System.out.println(result);
			}
		} else {
			//��һ���ַ�������ߵ��ַ��������
			char temp = array[begin];
			for (int i = begin; i < end; i++) {
				// begin <-> i
				array[begin] = array[i];
				array[i] = temp;
				//����������
				permutation(list, array, begin + 1, end);
				//��λ
				temp = array[i];
				array[i] = array[begin];
				array[begin] = temp;
			}
		}
	}
}
