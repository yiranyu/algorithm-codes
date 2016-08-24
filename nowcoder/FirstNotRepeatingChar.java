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
	 * 找出字符串中第一个只出现一次的字符的位置
	 * 输入一串字符,由小写字母组成;输出一个字符
	 * 思路：字符是一种数据长度为8的类型，总共了256种可能。新建一个简单的哈希表存储字符出现的次数
	 * 第一次扫描更新哈希表中字符出现的次数，第二次扫描寻找目标。
	 */
	public static int firstNotRepeatingChar(String str){
		if ( str.length() == 0)
            return -1;
         
        int hash[] = new int[256]; //简单哈希表
        for(int i =0;i<str.length();i++){
        	hash[str.charAt(i)]++; //根据字符的ASCII存储其出现次数
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
