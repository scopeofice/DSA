package circularLL;

public class CircularLL {
	private Node head;

	public CircularLL() {
		head = null;
	}

	public boolean insert(int data) {
		Node newNode = new Node(data);
		if (newNode == null) {
			return false;
		}

		if (head == null) {
			head.setNext(newNode);
			return true;
		}
		Node last = head;
		while (last.getNext() != head) {
			last = last.getNext();
		}
		last.setNext(newNode);
		newNode.setNext(head);

		return true;
	}

	public boolean insert(int data, int pos) {
		Node newNode = new Node(data);
		if (newNode == null) {
			return false;
		}
		if (pos == 1) {
			// if list is empty
			if (head == null) {
				head = newNode;
				newNode.setNext(head);
				return true;
			}
//		if list is not empty
			newNode.setNext(head);
			Node last = head;
			while (last.getNext() != head) {
				last = last.getNext();
			}
			last.setNext(newNode);
			head = newNode;
			return true;
		}
		Node prev = head;
		for (int i = 1; i < pos - 1; i++) {
			prev = prev.getNext();
			if (prev == head) {
				return false;
			}
			newNode.setNext(prev.getNext());
			prev.setNext(newNode);
		}
		return true;
	}

	public void display() {
		if (head == null) {
			return;
		}
		Node temp = head;
		while(temp!=head) {
			System.out.print(temp.getData()+ " ");
			temp=temp.getNext();			
		}
		System.out.println();
	}
	public boolean deleteByVal(int data) {
		if(head==null) {
			return false;
		}
		if(data==head.getData()) {
			if(head.getNext()==head) {
				head=null;
				return true;
			}
			Node last=head;
			while(last.getNext()!=head) {
				last=last.getNext();
			}
			last.setNext(head.getNext());
			head=head.getNext();
		}
		Node prev=head;
		Node del=head;
		while(del.getData()!=data) {
			prev=del;
			del=del.getNext();
			if(del==head) {
				return false;
			}
		}
		prev.setNext(del.getNext());		
		return true;
	}
	
	public boolean deleteByPos(int pos) {
		if(pos<=0 || head==null) {
			return false;
		}
		if(pos==1) {
			if(head.getNext()==head) {
				head=null;
				return true;
			}
			Node last=head;
			while(last.getNext()!=head) {
				last=last.getNext();
			}
			last.setNext(head.getNext());
			head=head.getNext();
		}
		Node prev=head;
		Node del=head;
		for(int i=0;i<pos;i++) {
			prev=del;
			del=del.getNext();
		}
		prev.setNext(del.getNext());
		return true;
	}
}



