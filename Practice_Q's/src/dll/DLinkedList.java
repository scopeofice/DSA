package dll;

public class DLinkedList {
	private Node head;
	public DLinkedList() {
		head=null;
	}
	public void display() {
		if(head==null) {
			return;
		}
		Node temp=head;
		while(temp!=null) {
			System.out.println(temp.getData()+" ");
			temp=temp.getNext();
		}
		System.out.println();
	}
	public boolean insert(int data) {
		Node newNode=new Node(data);
		if(newNode==null) {
			return false;
		}
		if(head==null) {
			head=newNode;
		}
		Node last=head;
		while(last.getNext()!=null) {
			last=last.getNext();
		}
		last.setNext(newNode);
		newNode.setPrev(last);
		return true;
	}
	
	public boolean insertAtPos(int data,int pos) {
		Node newNode=new Node(data);
		if(newNode==null) {
			return false;
		}
		Node prev=head;
		for(int i=0;i<pos-1;i++) {
			prev=prev.getNext();
			if(prev==null) {
				return false;
			}
		}
		Node next=prev.getNext();
		newNode.setPrev(prev);
		prev.setNext(newNode);
		if(next!=null) {
			next.setPrev(newNode);
			newNode.setNext(next);
		}
		return true;
	}
	public boolean deleteByVal(int data) {
		
		if(head==null) {
			return false;
		}
//		delete at first
		if(head.getData()==data) {
			head=head.getNext();
			if(head!=null) {
				head.setPrev(null);
			}
		}
//		delete anywhere in the list
		Node del=head;
		while(del.getData()!=data) {
			del=del.getNext();
			if(del==null) {
				return false;
			}
		}
		Node next=del.getNext();
		Node prev=del.getPrev();
		prev.setNext(next);
		if(prev!=null) {			
			next.setPrev(prev);
		}		
		return true;
	}
	public boolean deleteByPos(int pos) {
		
		if(head==null  ||pos<=0) {
			return false;
		}
		//at first position
		if(pos==1) {
			head=head.getNext();
			if(head!=null) {
				head.setPrev(null);
			}
			return true;
		}
		// at any pos
		Node del=head;
		for(int i=0;i<pos;i++) {
			del=del.getNext();
			if(del==null) {
				return false;
			}
		}
		Node prev=del.getPrev();
		Node next=del.getNext();
		prev.setNext(next);
		if(next!=null) {
			next.setPrev(prev);
		}		
		return true;
	}
}









