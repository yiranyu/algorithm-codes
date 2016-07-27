package nowcoder;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 * 利用一个辅助栈来存放最小值
 * 栈  3，4，2，5，1
 * 辅助栈 3，3，2，2，1
 * 每入栈一次，就与辅助栈顶比较大小，如果小就入栈，
 * 如果大就入栈当前的辅助栈顶，当出栈时，辅助栈也要出栈
 * 
 * @author lab2015
 *
 */
public class MinStack {
	private Stack<Integer> stack=new Stack<Integer>();
	private Stack<Integer> assist=new Stack<Integer>();//辅助栈

    public void push(int node) {
    	
        if(stack.isEmpty()){ //栈为空时，直接push
        	stack.push(node);
        	assist.push(node);
        }else{ //栈不为空，node与辅助栈的栈顶元素做对比
        	int min=assist.peek();
        	if(node<min){ //小于则push node
        		assist.push(node);
        	}else{ //大于push辅助栈的栈顶元素
        		assist.push(min);
        	}
        	stack.push(node);
        }
        
    }
    
    public void pop() {
    	if(!stack.isEmpty()){
    		stack.pop();
    		assist.pop();//辅助栈也要出栈
    	}
    }
    
    public int top() {
        return stack.peek();//当前栈的顶部元素
    }
    
    public int min() {
        if(stack.isEmpty()){ 
        	return 0;
        }
        //栈不为空时返回辅助栈的顶部元素
    	return assist.peek();
    }
    
    public static void main(String[] args) {
		MinStack minStack=new MinStack();
		minStack.push(4);
		minStack.push(3);
		minStack.push(6);
		minStack.push(2);
		//栈：4,3,6,2   辅助栈：4,3,3,2
		System.out.println(minStack.min()); //2
		minStack.pop();
		System.out.println(minStack.min()); //3
		minStack.pop();
		System.out.println(minStack.min()); //3
		minStack.pop();
		System.out.println(minStack.min()); //4
	}
}
