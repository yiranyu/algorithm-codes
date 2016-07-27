package nowcoder;

import java.util.Stack;

/**
 * ����ջ�����ݽṹ�����ڸ�������ʵ��һ���ܹ��õ�ջ��СԪ�ص�min������
 * ����һ������ջ�������Сֵ
 * ջ  3��4��2��5��1
 * ����ջ 3��3��2��2��1
 * ÿ��ջһ�Σ����븨��ջ���Ƚϴ�С�����С����ջ��
 * ��������ջ��ǰ�ĸ���ջ��������ջʱ������ջҲҪ��ջ
 * 
 * @author lab2015
 *
 */
public class MinStack {
	private Stack<Integer> stack=new Stack<Integer>();
	private Stack<Integer> assist=new Stack<Integer>();//����ջ

    public void push(int node) {
    	
        if(stack.isEmpty()){ //ջΪ��ʱ��ֱ��push
        	stack.push(node);
        	assist.push(node);
        }else{ //ջ��Ϊ�գ�node�븨��ջ��ջ��Ԫ�����Ա�
        	int min=assist.peek();
        	if(node<min){ //С����push node
        		assist.push(node);
        	}else{ //����push����ջ��ջ��Ԫ��
        		assist.push(min);
        	}
        	stack.push(node);
        }
        
    }
    
    public void pop() {
    	if(!stack.isEmpty()){
    		stack.pop();
    		assist.pop();//����ջҲҪ��ջ
    	}
    }
    
    public int top() {
        return stack.peek();//��ǰջ�Ķ���Ԫ��
    }
    
    public int min() {
        if(stack.isEmpty()){ 
        	return 0;
        }
        //ջ��Ϊ��ʱ���ظ���ջ�Ķ���Ԫ��
    	return assist.peek();
    }
    
    public static void main(String[] args) {
		MinStack minStack=new MinStack();
		minStack.push(4);
		minStack.push(3);
		minStack.push(6);
		minStack.push(2);
		//ջ��4,3,6,2   ����ջ��4,3,3,2
		System.out.println(minStack.min()); //2
		minStack.pop();
		System.out.println(minStack.min()); //3
		minStack.pop();
		System.out.println(minStack.min()); //3
		minStack.pop();
		System.out.println(minStack.min()); //4
	}
}
