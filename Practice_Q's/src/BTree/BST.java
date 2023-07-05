package BTree;

import java.util.Stack;

public class BST {
	private Node root;

	public BST() {
		this.root = null;
	}

	public void displayInOrder() {
		inOrder(root);
	}

	public void displayPostOrder() {
		postOrder(root);
	}

	public void displayPreOrder() {
		preOrder(root);
	}

	public boolean insert(int data) {
		Node newNode = new Node(data);
		if (newNode == null) {
			return false;
		}
		if (root == null) {
			root = newNode;
			return true;
		}
		Node temp = root;
		while (true) {
			if (data == temp.getData()) {
				return false;
			}
			if (temp.getData() > data) {
				if (temp.getLeft() == null) {
					temp.setLeft(newNode);
					return true;
				}
				temp = temp.getLeft();
			} else {
				if (temp.getRight() == null) {
					temp.setRight(newNode);
					return true;
				}
				temp = temp.getRight();
			}
		}
	}

	public void preOrder(Node node) {
		if (node == null) {
			return;
		}
		System.out.print(node.getData() + " ");
		preOrder(node.getLeft());
		preOrder(node.getRight());
	}

	public void inOrder(Node node) {
		if (node == null) {
			return;
		}
		inOrder(node.getLeft());
		System.out.print(node.getData() + " ");
		inOrder(node.getRight());
	}

	public void postOrder(Node node) {
		if (node == null) {
			return;
		}
		postOrder(node.getLeft());
		postOrder(node.getRight());
		System.out.print(node.getData() + " ");
	}

	public int getMax() {
		if (root == null) {
			return -1;
		}
		Node temp = root;
		while (temp.getRight() != null) {
			temp = temp.getRight();
		}
		return temp.getData();
	}

	public int getMin() {
		if (root == null) {
			return -1;
		}
		Node temp = root;
		while (temp.getLeft() != null) {
			temp = temp.getLeft();
		}
		return temp.getData();
	}

	public boolean find(int data) {
		if (root == null) {
			return false;
		}
		Node temp = root;
		while (temp != null) {
			if (temp.getData() == data) {
				return true;
			}
			if (temp.getData() > data) {
				temp = temp.getLeft();
			} else {
				temp = temp.getRight();
			}
		}
		return false;
	}

	public int displayCount() {
		return getCount(root);
	}

	public int getCount(Node node) {
		if (node == null) {
			return 0;
		}
		int leftCount = getCount(node.getLeft());
		int rightCount = getCount(node.getRight());
		return 1 + leftCount + rightCount;

	}

	public int count() {
		if (root == null) {
			return 0;
		}
		Stack<Node> stack = new Stack<>();
		stack.push(root);
		int count = 0;

		while (!stack.isEmpty()) {
			Node temp = stack.pop();
			count++;
			if (temp.getLeft() != null) {
				stack.push(temp.getLeft());
			}
			if (temp.getRight() != null) {
				stack.push(temp.getRight());
			}
		}
		return count;
	}

	public void inOrderStack() {
		if (root == null) {
			return;
		}
		Node temp = root;
		Stack<Node> stack = new Stack<>();
		while (temp != null || !stack.isEmpty()) {
			while (temp != null) {
				stack.push(temp);
				temp = temp.getLeft();
			}
			temp = stack.pop();
			System.out.print(temp.getData() + " ");
			temp = temp.getRight();
		}
		System.out.println();
	}

	public void preOrderStack() {
		if (root == null) {
			return;
		}
		Node temp = root;
		Stack<Node> stack = new Stack<>();
		while (temp != null || !stack.isEmpty()) {
			while (temp != null) {
				System.out.print(temp.getData() + " ");
				stack.push(temp);
				temp = temp.getLeft();
			}
			temp = stack.pop();
			temp = temp.getRight();
		}
		System.out.println();
	}
//	 public void preOrder() {
//	        Node temp = root;
//	        Stack<Node> stack = new Stack<>();
//
//	        System.out.print("PreOrder: ");
//	        while(temp != null || !stack.empty()) {
//	            while(temp != null) {
//	                System.out.print(temp.getData() + " ");
//	                stack.push(temp);
//	                temp = temp.getLeft();
//	            }
//
//	            temp = stack.pop().getRight();
//	        }
//
//	        System.out.println();
//	    }

	public void postOrderStack() {
		Stack<Node> stack = new Stack<>();
		if (root == null) {
			return;
		}
		Node temp = root;
		Node prev = null;
		while (temp != null || !stack.isEmpty()) {
			while (temp != null) {
				stack.push(temp);
				temp = temp.getLeft();
			}
			Node dummy = stack.peek();
			if (dummy.getRight() != null && dummy.getRight() != prev) {
				temp = dummy.getRight();
			} else {
				prev = stack.pop();
				System.out.print(prev.getData() + " ");
			}
		}
		System.out.println();
	}

	public boolean findElem(int data) {
		if (root == null) {
			return false;
		}
		Node temp = root;
		while (temp != null) {
			if (temp.getData() == data) {
				return true;
			}
			if (data < temp.getData()) {
				temp = temp.getLeft();
			}
			if (data > temp.getData()) {
				temp = temp.getRight();
			}
		}
		return false;
	}

	
	public boolean add(int data) {
		Node newNode=new Node(data);
		if(newNode==null) {
			return false;
		}
		if(root==null) {
			root= newNode;
			return true;
		}
		Node temp=root;
		while(true) {
			if(temp.getData()==data){
			return false;
		}
		if(data<temp.getData()) {
			if(temp.getLeft()==null) {
				temp.setLeft(newNode);
				return true;
			}
			temp=temp.getLeft();
		}else {
			if(temp.getRight()==null){
				temp.setRight(newNode);
				return true;
			}
			temp=temp.getRight();
		}
		
		}
	}
	public void inor() {
		Node temp=root;
		Stack<Node> stack=new Stack<>();
		while(temp!=null || !stack.isEmpty()) {
			while(temp!=null) {
				stack.push(temp);
				temp=temp.getLeft();
			}
			temp=stack.pop();
			System.out.print(temp.getData()+" ");
			temp=temp.getRight();
		}
		System.out.println();
	}
	public void pre() {
		Node temp=root;
		Stack<Node> stack=new Stack<>();
		while(temp!=null||!stack.isEmpty()) {
			while(temp!=null) {
				System.out.print(temp.getData()+" ");
				stack.push(temp);
				temp=temp.getLeft();
			}
			temp=stack.pop().getRight();
		}
	System.out.println();	
	}
	public void post() {
		Node temp=root;
		Node prev=null;
		Stack<Node> stack=new Stack<>();
		while(temp!=null||!stack.isEmpty()) {
			while(temp!=null) {
				stack.push(temp);
				temp=temp.getLeft();
			}
			Node dummy=stack.peek();
			if(dummy.getRight()!=null && dummy.getRight()!=prev) {
				temp=dummy.getRight();
			}else {
				prev=stack.pop();
				System.out.print(prev.getData()+" ");
			}
		}
		System.out.println();
	}
	public boolean search(int data) {
		if(root==null) {
			return false;
		}
		Node temp=root;
		while(temp!=null) {
			if(data==temp.getData()) {
				return true;
			}
			if(data<temp.getData()) {
				temp=temp.getLeft();
			}
			if(data>temp.getData()) {
				temp=temp.getRight();
			}
		}
		return false;
	}
	
	public boolean delete(int data) {
		if(root==null) {
			return false;
		}
		Node del=root;
		Node prev=root;
		
		while(del.getData()!=data) {
			if(data<del.getData()) {
				prev=del;
				del=del.getLeft();
			}else {
				prev=del;
				del=del.getRight();
			}
			if(del==null) {
				return false;
			}
		}
		while(true) {
			if(del.getLeft()==null && del.getRight()==null) {
				if(del==root) {
					root=null;
					return true;
				}
				if(prev.getLeft()==del) {
					prev.setLeft(null);
				}else {
					prev.setRight(null);
				}
				return true;
			}
			if(del.getLeft()!=null) {
				prev=del;
				Node max=del.getLeft();
				while(max.getRight()!=null) {
					prev=max;
					max=max.getRight();
				}
				//swap
				int temp=del.getData();
				del.setData(max.getData());
				max.setData(temp);
				del=max;
			}
			else {
				prev=del;
				Node min=del.getRight();
				while(min.getLeft()!=null) {
					prev=min;
					min=min.getLeft();
				}
				int temp=del.getData();
				del.setData(min.getData());
				min.setData(temp);
				del=min;
			}
			
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
}







