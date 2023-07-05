package stacks;

public class Tester {

	public static void main(String[] args) {
		
		StackLL<?> stack=new StackLL<>();
		String str="(20+(4-2)+15/5)5";
		String st="a+b*(c-d)/e";
		System.out.println(stack.infixToPostfix(st));
		System.out.println(stack.infixToPostfix(str));
		
	}

}
