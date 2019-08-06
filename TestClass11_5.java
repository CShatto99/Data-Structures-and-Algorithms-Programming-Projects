// This project uses a binary search tree to resolve collisions in a chaining hash table.
// TEST CLASS
public class TestClass11_5 {
	// NODE CLASS
	public static class Node {
		public int data;
		public Node root;
		public Node left;
		public Node right;
		
		public Node(int d) {
			data = d;
			root = null;
			left = null;
			right = null;
		}
		
		public int getKey() {
			return data;
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
		
		public void insert(Node newNode) {
			
			if(root == null)
				root = newNode;
			
			else {
				Node current = root;
				Node parent;
				while(true) {
					parent = current;
					if(newNode.data < current.data) {
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
		
		public Node find(int key) {
			Node current = root;
			
			while(current.data != key) {
				if(key < current.data)
					current = current.left;
				else
					current = current.right;
				if(current == null)
					return null;
			}
			return current;
		}
		
		public void printInOrder() {
			inOrderTraversal(root);
		}
		private void inOrderTraversal(Node localRoot) {
			if(localRoot != null) {
				inOrderTraversal(localRoot.left);
				System.out.print(localRoot.data + " ");
				inOrderTraversal(localRoot.right);
			}
		}
	}
	// END BINARY TREE CLASS
	
	// HASH TABLE CLASS
	public static class ChainingHashTable {
		private int arraySize;
		private BinaryTree[] hashArray;
		
		public ChainingHashTable(int size) {
			arraySize = size;
			hashArray = new BinaryTree[arraySize];
			for(int i = 0; i < arraySize; i++)
				hashArray[i] = new BinaryTree();
		}
		
		public void displayTable() {
			for(int i = 0; i < arraySize; i++) {
				System.out.println("Tree #" + i + ": ");
				hashArray[i].printInOrder();
				System.out.println();
			}
		}
		
		public int hashFunc(int key) {
			return (key % arraySize);
		}
		
		public void insert(Node newNode) {
			int key = newNode.getKey();
			int hashVal = hashFunc(key);
			hashArray[hashVal].insert(newNode);
		}
		
		public Node find(int key) {
			int hashVal = hashFunc(key);
			Node l = hashArray[hashVal].find(key);
			return l;
		}
	}
	// END HASH TABLE CLASS
	
	// TEST METHOD
	public static void main(String[] args) {
		ChainingHashTable ht = new ChainingHashTable(3);
		int numItems = 15;
		for(int i = 0; i < numItems; i++) {
			int num = (int)(Math.random()*99);
			Node newNode = new Node(num);
			ht.insert(newNode);
		}
		ht.displayTable();
	}
	// END TEST METHOD
}
// END TEST CLASS