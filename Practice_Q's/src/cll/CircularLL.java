package cll;

public class CircularLL {
	private Node head;
	public CircularLL() {
		head=null;
	}
	public void display() {
		if(head==null) {
			return;
		}
		Node last=head;
		do {
			System.out.print(last.getData()+" ");
			last=last.getNext();
		}while(last!=head);
		System.out.println();
	}
	public boolean insert(int data) {
		Node newNode=new Node(data);
		if(newNode==null) {
			return false;
		}
		if(head==null) {
			head=newNode;
			newNode.setNext(newNode);
			return true;			
		}
		Node last =head;
		while(last.getNext()!=head) {
			last=last.getNext();
		}
		last.setNext(newNode);
		newNode.setNext(head);
		return true;
	}
	public boolean delete(int data) {
		if(head==null) {
			return false;
		}
		if(data==head.getData()) {
			if(head.getNext()==head) {
				head=null;
				return true;
			}
			Node temp=head; 
			while(temp.getNext()!=head) {
				temp=temp.getNext();
			}
			temp.setNext(head.getNext());
				head=head.getNext();
				return true;
		}
		Node prev=head;
		Node del=head;
		while(del.getData()!=data) {
			prev=del;
			del=del.getNext();
			if(del==null) {
				return false;
			}
		}
		prev.setNext(del.getNext());
		return true;
	}
}







