package nowcoder;

import java.util.Stack;

/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * @author lab2015
 *
 */
public class QueueByStack {
	Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    public static void main(String[] args) {
		QueueByStack s=new QueueByStack();
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		while(!s.stack1.isEmpty()){
			System.out.print(s.pop()+" ");
		}
		System.out.print(s.pop()+" ");
		
	}
    public void push(int node) {
        while(!stack1.isEmpty()){
        	stack2.push(stack1.pop());
        }
        stack1.push(node);
        while(!stack2.isEmpty()){
        	stack1.push(stack2.pop());
        }
    }
    
    public int pop() {
    	if(stack1.isEmpty()){
    		return 0;
    	}
    	return stack1.pop();
    }
}
