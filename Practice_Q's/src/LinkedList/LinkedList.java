package LinkedList;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LinkedList {
	Node head = new Node();

	public LinkedList() {
		head = null;
	}

	public void display() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.getData() + " ");
			temp = temp.getNext();
		}
		System.out.println();
	}

	public boolean insert(int data) {
		Node newNode = new Node(data);
		if (newNode == null) {
			return false;
		}
		if (head == null) {
			head = newNode;
			return true;
		}
		Node last = head;
		while (last.getNext() != null) {
			last = last.getNext();
		}
		last.setNext(newNode);
		return true;
	}

	// Q.1) Write a function to count the number of nodes in a singly linked list.
	public int countNodes() {
		int count = 0;
		Node current = head;
		while (current != null) {
			count++;
			current = current.getNext();
		}
		return count;
	}

	// Q.2) Write a function to insert a node at the beginning of a singly linked
	// list.
	public boolean insertAtBeggning(int data) {
		Node temp = new Node(data);
		if (temp == null) {
			return false;
		}
		if (head == null) {
			head = temp;
			return true;
		} else {
			temp.setNext(head);
			head = temp;
			return true;
		}
	}

	// Q.3) Write a function to insert a node at the end of a singly linked list.
	public boolean insertAtEnd(int data) {
		Node temp = new Node(data);
		if (temp == null) {
			return false;
		}
		if (head == null) {
			head = temp;
			return true;
		}
		Node last = head;
		while (last != null) {
			last = last.getNext();
		}
		last.setNext(temp);
		return true;
	}

	// Q.4) Write a function to delete a node with a given value from a singly
	// linked list.
	public boolean deleteByVal(int data) {
		Node temp = new Node(data);

		if (temp == null) {
			return false;
		}
		if (head == null) {
			return true;
		}
		if (head.getData() == data) {
			head = head.getNext();
			return true;
		}
		Node current = head;
		Node prev = null;
		while (current != null && current.getData() != data) {
			prev = current;
			current = current.getNext();
		}
		if (current != null) {
			prev.setNext(current.getNext());
			return true;
		}
		return false;
	}

	// Q.5)Write a function to reverse a singly linked list.
	public boolean reverse() {
		if (head == null || head.getNext() == null) {
			return false;
		}
		Node current = head;
		Node prev = null;
		Node next = null;
		while (current != null) {
			next = current.getNext();
			current.setNext(prev);
			prev = current;
			current = next;
		}
		head = prev;
		return true;
	}

	// Q.6) Write a function to find the middle node of a singly linked list.
	public Node middleValue() {
		Node fast = head;
		Node slow = head;
		while (fast != null || fast.getNext() != null) {
			fast = fast.getNext().getNext();
			slow = slow.getNext();
		}
		return slow;
	}

	// Q.7) Write a function to check if a given linked list is a palindrome.
	public boolean isPalindrome() {
		if (head == null) {
			return false;
		}
		List<Integer> list = new ArrayList<>();
		Node current = head;
		while (current != null) {
			list.add(current.getData());
			current = current.getNext();
		}
		int left = 0;
		int right = list.size() - 1;

		while (left < right) {
			if (!list.get(left).equals(list.get(right))) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}

//	Q.8) Remove duplicate values
	public void removeDuplicate() {
		if (head == null) {
			return;
		}
		Set<Integer> set = new HashSet<>();
		Node current = head;
		Node prev = null;
		while (current != null) {
			int data = current.getData();
			if (set.contains(data)) {
				prev.setNext(current.getNext());
			} else {
				set.add(data);
				prev = current;
			}
			current = current.getNext();
		}
	}

//	Q.9) Merge 2 linked List
	public void merg(LinkedList l1, LinkedList l2) {
		if (l1.head == null) {
			head = l2.head;
		}
		if (l2.head == null) {
			head = l1.head;
		}
		Node cur1 = l1.head;
		Node cur2 = l2.head;
		Node temp = null;
		if (temp == null) {
			head = cur1;
			temp = cur1;
			cur1 = cur1.getNext();

		}
		while (cur1 != null && cur2 != null) {
			temp.setNext(cur2);
			temp = cur2;
			cur2 = cur2.getNext();
			Node dummy = cur1;
			cur1 = cur2;
			cur2 = dummy;
		}
		if (cur1 != null) {
			temp.setNext(cur1);
		}
		if (cur2 != null) {
			temp.setNext(cur2);
		}
	}

//	Q.10) How do you check if a given linked list contains a cycle? How do you find the starting node of the cycle?
	public boolean hasCycle() {
		if (head == null || head.getNext() == null) {
			return false;
		}
		Node fast = head;
		Node slow = head;

		while (fast != null && fast.getNext() != null) {
			slow = slow.getNext();
			fast = fast.getNext().getNext();
			if (slow == fast) {
				return true;
			}
		}
		return true;
	}

	public Node cycleStart() {
		if (!hasCycle()) {
			return null;
		}
		Node slow = head;
		Node fast = head;
		while (true) {
			slow = slow.getNext();
			fast = fast.getNext().getNext();
			if (slow == fast) {
				break;
			}
		}
		slow = head;

		while (slow != fast) {
			slow = slow.getNext();
			fast = fast.getNext();
		}

		return slow;
	}


//	Q.12) a singly linked list of integers such that all elements are inserted in ascending order.

	public boolean insertAsc(int data) {
		Node newNode = new Node(data);
		if (newNode == null) {
			return false;
		}
		if (head == null || head.getData() > data) {
			newNode.setNext(head);
			head = newNode;
			return true;
		}
		Node temp = head;
		while (temp.getNext() != null && data >= temp.getNext().getData()) {
			temp = temp.getNext();
		}
		newNode.setNext(temp.getNext());
		temp.setNext(newNode);
		return true;
	}

//	Q.13) Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
	public void partition(int data) {
		if (head == null || head.getNext() == null) {
			return;
		}
		Node smallLeft = head;
		Node smallRight = smallLeft;
		Node largeLeft = head;
		Node largeRigth = largeLeft;
		Node temp = head;
		while (temp != null) {
			if (temp.getData() < data) {
				smallRight.setNext(temp);
				smallRight = smallRight.getNext();
			} else {
				largeRigth.setNext(temp);
				largeRigth = largeRigth.getNext();
			}
			temp = temp.getNext();
		}
		largeRigth.setNext(null);
		smallRight.setNext(largeLeft.getNext());
		head = smallLeft.getNext();

	}

//	Q.14) Delete Middle of Linked List
	public boolean deleteMid() {
		if (head == null) {
			return false;
		}
		if (head.getNext() == null) {
			head.setNext(null);
			return true;
		}
		Node fast = head;
		Node slow = head;
		Node prev = null;
		while (fast != null && fast.getNext() != null) {
			fast = fast.getNext().getNext();
			prev = slow;
			slow = slow.getNext();
		}
		prev.setNext(slow.getNext());
		return true;
	}

	public void findAllDuplicates() {
		if (head == null) {
			return;
		}
		Node temp = head;
		Set<Integer> set = new HashSet<>();
		while (temp != null) {
			if (set.contains(temp.getData())) {
				System.out.print(temp.getData() + " ");
			} else {
				set.add(temp.getData());
			}
			temp = temp.getNext();
		}
	}

//	Q.15)You are given N numbers and a integer K. Your task is to reverse all the numbers before and after K. 
	public void reverseSublist(int k) {
		if (head == null || head.getNext() == null) {
			return;
		}
		Node current = head;
		Node prev = null;
		Node temp = null;

		while (current != null) {
			if (current.getData() == k) {
				temp = current;
				break;
			}
			prev = current;
			current = current.getNext();
		}
		Node prevNode = null;
		Node nextNode = null;
		current = head;
		while (current != temp) {
			nextNode = current.getNext();
			current.setNext(prevNode);
			prevNode = current;
			current = nextNode;
		}
		if (prev != null) {
			prev.setNext(prevNode);
		} else {
			head = prevNode;
		}
		prevNode = null;
		current = temp.getNext();
		while (current != null) {
			nextNode = current.getNext();
			current.setNext(prevNode);
			prevNode = current;
			current = nextNode;
		}
		temp.setNext(prevNode);
	}

//	Q16.)  Consider a singly linked list. Rotate the list from k   position from the last node.

	public Node rotateFromLast(int k) {
		if(head==null || k==0) {
			return head;
		}
		int size=0;
		Node temp=head;
		while(temp!=null) {
			size++;
			temp=temp.getNext();
		}
		
		int pos=size-k;
		if(pos==size || k<0) {
			return head;
		}
		Node first=head;
		Node second=head;
		for(int i=0;i<pos;i++) {
			second=second.getNext();		
			}
		
		while(second.getNext() !=null) {
			first=first.getNext();
			second=second.getNext();
		}
		Node dummy=first.getNext();
		first.setNext(null);
		second.setNext(head);
		return first.getNext();
	}
	
//	Q.17)Write a search operation in every LL to search an element passed by user
	public boolean search(int data) {
		if(head==null) {
			return false;
		}
		if(head.getData()==data) {
			return true;
		}
		Node temp=head;
		while(temp!=null || temp.getData()==data) {
			temp=temp.getNext();
			if(temp==null) {
				return false;
			}
		}
		return false;
	}
	
	

}








