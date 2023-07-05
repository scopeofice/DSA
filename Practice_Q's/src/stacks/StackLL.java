package stacks;
import java.util.Stack;


public class StackLL<T> {
	private Node<T> top;
	private int size;
	
	public StackLL() {
		top=null;
		size=0;
	}
	public boolean isEmpty() {
		return top==null;
	}
	public void push(T data) {
		Node<T> newNode=new Node<>(data);
		newNode.setNext(top);
		top=newNode;
		size++;
	}
	public T pop() {
		if(isEmpty()) {
			return null;
		}
		T data=top.getData();
		top=top.getNext();
		size--;
		return data;
	}
	public T peek() {
		if(isEmpty()) {
			return null;
		}
		return top.getData();
	}
	public int getSize() {
		return size;
	}
	public boolean isOperator(char ch) {
		return ch=='+'||ch=='-'||ch=='*'||ch=='/';
	}
	public int precedence(char ch) {
		switch(ch) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		}
		return -1;
	}
	
//	Q.1)Given an expression in its infix form, convert it into postfix form.
	public String infixToPostfix(String infix) {
		StringBuilder postfix=new StringBuilder();
		Stack<Character> stack = new Stack<>();
		for(int i=0;i<infix.length();i++) {
			char ch=infix.charAt(i);
			if(Character.isLetterOrDigit(ch)) {
				postfix.append(ch);
			}else if (ch=='(') {
				stack.push(ch);
			}else if (ch==')') {
				while(!stack.isEmpty() && stack.peek()!='(') {
					postfix.append(stack.pop());
				}
				if(!stack.isEmpty() && stack.peek()!='(') {
					return "Invalid expression";
				}else {
					stack.pop();
				}
			}else if (isOperator(ch)) {
				while(!stack.isEmpty()&&precedence(ch)<=precedence(stack.peek())) {
					postfix.append(stack.pop());
				}
				stack.push(ch);
			}
		}
		while(!stack.isEmpty()) {
			if(stack.peek()=='(') {
				return "invalid expression";
			}
			postfix.append(stack.pop());
		}
		return postfix.toString();
	}
	
}











