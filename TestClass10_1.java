// This project implements a method that finds the minimum value in a 2-3-4 tree.
// SOLUTION AT BOTTOM OF TREE234 CLASS
public class TestClass10_1 {
	
	// BEGIN DATA ITEM CLASS
	public static class DataItem {
		public int data;
		
		public DataItem(int d) {
			data = d;
		}
		
		public void displayItem() {
			System.out.print("/" + data);
		}
	}
	// END DATA ITEM CLASS
	
	// BEGIN NODE CLASS
	public static class Node {
		private final int ORDER = 4;
		private int numItems;
		private Node parent;
		private Node childArray[] = new Node[ORDER];
		private DataItem itemArray[] = new DataItem[ORDER-1];
		
		public void connectChild(int childNum, Node child) {
			childArray[childNum] = child;
			if(child != null)
				child.parent = this;
		}
		
		public Node disconnectChild(int childNum) {
			Node tempNode = childArray[childNum];
			childArray[childNum] = null;
			return tempNode;
		}
		
		public Node getChild(int childNum) {
			return childArray[childNum];
		}
		
		public Node getParent() {
			return parent;
		}
		
		public boolean isLeaf() {
			return (childArray[0] == null) ? true : false;
		}
		
		public int getNumItems() {
			return numItems;
		}
		
		public DataItem getItem(int index) {
			return itemArray[index];
		}
		
		public boolean isFull() {
			return (numItems == ORDER-1) ? true : false;
		}
		
		public int findItem(int key) {
			for(int i = 0; i < ORDER-1; i++) {
				if(itemArray[i] == null)
					break;
				else if(itemArray[i].data == key)
					return i;
			}
			return -1;
		}
		
		public int insertItem(DataItem newItem) {
			numItems++;
			int newKey = newItem.data;
			
			for(int i = ORDER-2; i >= 0; i--) {
				if(itemArray[i] == null)
					continue;
				else  {
					int itsKey = itemArray[i].data;
					if(newKey < itsKey) {
						itemArray[i+1] = itemArray[i];
					}
					else {
						itemArray[i+1] = newItem;
						return i+1;
					}
				}
			}
			itemArray[0] = newItem;
			return 0;
		}
		
		public DataItem removeItem() {
			DataItem tempItem = itemArray[numItems-1];
			itemArray[numItems-1] = null;
			numItems--;
			return tempItem;
		}
		
		public void displayNode() {
			for(int i = 0; i < numItems; i++) {
				itemArray[i].displayItem();
			}
			System.out.println("/");
		}
	}
	// END NODE CLASS
	
	// BEGIN 2-3-4 TREE CLASS
	public static class Tree234 {
		public Node root = new Node();
		
		public int find(int key) {
			Node current = root;
			int childNumber;
			while(true) {
				// set the new int value equal to the return value of the find item method
				if((childNumber = current.findItem(key)) != -1)
					return childNumber;
				// if the current node is a leaf to begin with and no match was found, return -1
				else if(current.isLeaf())
					return -1;
					// updates current to next child
				else
					current = getNextChild(current, key);
			}
		}
		
		public void insert(int value) {
			Node current = root;
			DataItem newItem = new DataItem(value);
			
			while(true) {
				if(current.isFull()) {
					split(current);
					current = current.getParent();
					current = getNextChild(current, value);
				}
				else if(current.isLeaf())
					break;
				else
					current = getNextChild(current, value);

			}
			current.insertItem(newItem);
		}

		public void split(Node thisNode) {
			DataItem itemB, itemC;
			Node parent, child2, child3;
			int itemIndex;
			
			itemC = thisNode.removeItem();
			itemB = thisNode.removeItem();
			child2 = thisNode.disconnectChild(2);
			child3 = thisNode.disconnectChild(3);
			
			Node newRight = new Node();
			
			// if true, create a new root
			if(thisNode == root) {
				root = new Node();
				parent = root;
				root.connectChild(0, thisNode);
			}
			// otherwise, just get the parent
			else
				parent = thisNode.getParent();
			
			// set up parent by inserting item b
			itemIndex = parent.insertItem(itemB);
			
			// move parent's connections one child to the right
			int n = parent.getNumItems();
			for(int i = n-1; i > itemIndex; i--) {
				Node temp = parent.disconnectChild(i);
				parent.connectChild(i+1, temp);
			}
			
			// make connection between new parent and new right node
			parent.connectChild(itemIndex+1, newRight);
			
			// set up new right node by inserting item c and connecting original node's children to the new right node
			newRight.insertItem(itemC);
			newRight.connectChild(0, child2);
			newRight.connectChild(1, child3);
		}
		
		public Node getNextChild(Node thisNode, int value) {
			int i;
			
			int n = thisNode.getNumItems();
			for(i = 0; i < n; i++) {
				if(value < thisNode.getItem(i).data)
					return thisNode.getChild(i);
			}
			return thisNode.getChild(i);
		}
		
		public void displayTree() {
			recDisplayTree(root, 0, 0);
		}
		
		public void recDisplayTree(Node current, int level, int childNum) {
			System.out.print("level=" + level + " child=" + childNum + " | ");
			
			int n = current.getNumItems();
			current.displayNode();
			for(int i = 0; i < n+1; i++) {
				Node nextNode = current.getChild(i);
				if(nextNode != null) {
					//nextNode.displayNode();
					recDisplayTree(nextNode, level+1, i);
				}
				else
					return;
			}
		}
		
		// PROJECT SOLUTION
		public int minimum() {
			Node current = root;
			Node last = null;
			while(current != null) {
				last = current;
				current = current.getChild(0);
			}
			return last.getItem(0).data;
		}
	}
	// END 2-3-4 TREE CLASS
	
	// BEGIN TEST METHOD
	public static void main(String[] args) {
		Tree234 tree = new Tree234();
		tree.insert(50);
		tree.insert(20);
		tree.insert(60);
		tree.insert(40);
		tree.insert(80);
		tree.insert(10);
		tree.insert(90);
		
		tree.displayTree();
		int min = tree.minimum();
		System.out.println("Minimum value in the tree: " + min);
	}
	// END TEST METHOD
}
