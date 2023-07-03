package stacks;

public class DoubleStackLL<T> {
	private Node <T> top1;
	private Node <T> top2;
	
	public DoubleStackLL() {
		this.top1=null;
		this.top2=null;
	}
	public boolean isEmpty1() {
		return top1==null;
	}
	public boolean isEmpty2() {
		return top2==null;
	}
	public T peek1() {
		if(isEmpty1()) {
			return null;
		}
		return top1.getData();
	}
	public T peek2() {
		if(isEmpty2()) {
			return null;
		}
		return top2.getData();
	}
	public void push1(T data) {
		Node <T> newNode=new Node<>(data);
		newNode.setNext(top1);
		top1=newNode;
	}
	public void push2(T data) {
		Node <T> newNode=new Node<>(data);
		newNode.setNext(top2);
		top2=newNode;
	}
	public T pop1() {
		if(isEmpty1()) {
			return null;
		}
		T data= top1.getData();
		top1=top1.getNext();
		return data;
	}
	public T pop2() {
		if(isEmpty2()) {
			return null;
		}
		T data=top2.getData();
		top2=top2.getNext();
		return data;
	}
}
