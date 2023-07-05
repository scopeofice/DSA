package BTree;

public class Tester {

	public static void main(String[] args) {
		
		BST bst=new BST();
		
		 	bst.insert(50);
	        bst.insert(20);
	        bst.insert(10);
	        bst.insert(30);
	        bst.insert(40);
	        bst.insert(25);
	        bst.insert(90);
	        bst.insert(60);
	        bst.insert(100);
	        bst.insert(55);
	        bst.insert(80);
	        
	        System.out.println("search: "+bst.search(100));
//		bst.insert(80);
		System.out.println("InOrder : ");
		bst.displayInOrder();
		System.out.println();
		bst.delete(100);
		bst.inOrderStack();
		System.out.println();
		System.out.println("PostOrder : ");
		bst.displayPostOrder();
		System.out.println();
		bst.delete(10);
		bst.postOrderStack();
		System.out.println();
		System.out.println("PreOrder : ");
		bst.displayPreOrder();
		bst.delete(50);
		System.out.println();
		bst.preOrderStack();
		System.out.println();
		System.out.println("Find :");
		System.out.println(bst.find(100));
		System.out.println(bst.findElem(100));
		System.out.println();
		
		System.out.println(bst.count());
		System.out.println(bst.displayCount());

	}

}
