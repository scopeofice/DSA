package Queues;

public class Queue {
	private int [] arr;
	private int front;
	private int rear;
	private int size;
	public Queue(int size) {
		this.front=-1;
		this.rear=-1;
		this.size=size;
		this.arr=new int[size];
	}
	public boolean isEmpty() {
		return ((front==-1 && rear==-1)||(front>rear));
	}
	public boolean isFull() {
		return rear==size-1;
	}
	public boolean insert(int data) {
		if(isFull()) {
			return false;
		}
		arr[++rear]=data;
		if(front==-1) {
			front=0;
		}
		return true;
	}
	public int delete() {
		if(isFull()) {
			return -1;
		}
		return arr[front++];
	}
	public void display() {
		if(isEmpty()) {
			return;
		}else {
			for(int i=front;i<=rear;i++) {
				System.out.print(arr[i]+" ");
			}
			System.out.println();
		}
	}	
}
