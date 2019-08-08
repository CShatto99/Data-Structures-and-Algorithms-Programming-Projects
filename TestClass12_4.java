// This project implements a priority queue using a binary search tree.
// TEST CLASS
public class TestClass12_4 {
	
	// NODE CLASS
	public static class Node {
		public int data;
		public Node left;
		public Node right;
		
		public Node(int d) {
			data = d;
			left = null;
			right = null;
		}
		
		public void displayNode() {
			System.out.print(data + " ");
		}
	}
	// END NODE CLASS
	
	// BINARY TREE CLASS
	public static class BinaryTree {
		public Node root;
		
		public BinaryTree() {
			root = null;
		}
		
		public void insert(int data) {
			Node newNode = new Node(data);
			if(root == null)
				root = newNode;
			else {
				Node current = root;
				Node parent;
				while(true) {
					parent = current;
					if(data < current.data) {
						current = current.left;
						if(current == null) {
							parent.left = newNode;
							return;
						}
					}
					else {
						current = current.right;
						if(current == null) {
							parent.right = newNode;
							return;
						}
					}
				}
			}
		}
		
		public boolean delete(int key) {
			Node parent = root;
			Node current = root;
			boolean isLeftChild = true;
			
			while(current.data != key) {
				parent = current;
				if(key < current.data) {
					isLeftChild = true;
					current = current.left;
				}
				else {
					isLeftChild = false;
					current = current.right;
				}
				if(current == null)
					return false;
			}
			
			if(current.left == null && current.right == null) {
				if(current == root)
					root = null;
				else if(isLeftChild)
					parent.left = null;
				else
					parent.right = null;
			}
			
			else if(current.right == null) {
				if(current == root)
					root = current.left;
				else if(isLeftChild)
					parent.left = current.left;
				else
					parent.right = current.left;
			}
			else if(current.left == null) {
				if(current == root) 
					root = current.right;
				else if(isLeftChild)
					parent.left = current.right;
				else
					parent.right = current.right;
			}
			
			else {
				Node successor = getSuccessor(current);
				if(current == root)
					root = successor;
				else if(isLeftChild)
					parent.left = successor;
				else
					parent.right = successor;
				successor.left = current.left;
			}
			return true;
		}
		
		private Node getSuccessor(Node delNode) {
			Node successorParent = delNode;
			Node successor = delNode;
			Node current = delNode.right;
			
			while(current != null) {
				successorParent = successor;
				successor = current;
				current = current.left;
			}
			
			if(successor != delNode.right) {
				successorParent.left = successor.right;
				successor.right = delNode.right;
			}
			return successor;
		}
		
		public int findMax() {
			Node last = null;
			Node current = root;
			
			while(current != null) {
				last = current;
				current = current.right;
			}
			return last.data;
		}
		
		public int removeMax() {
			Node current = root;
			Node last = null;
			while(current != null) {
				last = current;
				current = current.right;
			}
			delete(last.data);
			return last.data;
		}
		
		public void printInOrder() {
			inOrderTraversal(root);
		}
		private void inOrderTraversal(Node current) {
			if(current != null) {
				inOrderTraversal(current.left);
				System.out.print(current.data + " ");
				inOrderTraversal(current.right);
			}
		}
	}
	// END BINARY TREE CLASS
	
	// PRIORTY QUEUE CLASS
	public static class PriorityQ {
		public int currentSize, nItems;
		public BinaryTree BST;
		
		public PriorityQ() {
			currentSize = 0;
			BST = new BinaryTree();
		}
		
		public void insert(int data) {
			nItems++;
			BST.insert(data);
		}
		
		public int remove() {
			nItems--;
			return BST.removeMax();
		}
		
		public int peek() {
			return BST.findMax();
		}
		
		public boolean isEmpty() {
			return (nItems == 0);
		}
	}
	// END PRIORITY QUEUE CLASS
	
	// TEST METHOD
	public static void main(String[] args) {
		int size = 10;
		PriorityQ pq = new PriorityQ();
		
		System.out.print("Inserted: ");
		for(int i = 0; i < size; i++) {
			int num = (int)(Math.random()*100);
			pq.insert(num);
			System.out.print(num + " ");
		}
		System.out.println();
		
		System.out.print("Queue Removal: ");
		for(int i = 0; i < size; i++) {
			System.out.print(pq.remove() + " ");
		}
		
	}
	// END TEST METHOD
}
// END TEST CLASS