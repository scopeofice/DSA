package stacks;

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
}
