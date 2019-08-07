// This project implements a minimum Heap.
// TEST CLASS
public class TestClass12_1 {
	
	// NODE CLASS
	public static class Node {
		private int data;
		
		public Node(int d) {
			data = d;
		}
		
		public int getKey() {
			return data;
		}
		
		public void setKey(int key) {
			data = key;
		}
	}
	// END NODE CLASS
	
	// MINIMUM HEAP CLASS
	public static class MinHeap {
		private int maxSize;
		private int currentSize;
		private Node[] heapArray;
		
		public MinHeap(int size) {
			maxSize = size;
			currentSize = 0;
			heapArray = new Node[maxSize];
		}
		
		public boolean isEmpty() {
			return (currentSize == maxSize);
		}
		
		public boolean insert(int key) {
			if(currentSize == maxSize)
				return false;
			Node newNode = new Node(key);
			heapArray[currentSize] = newNode;
			trickleUp(currentSize++);
			return true;
		}
		
		public void trickleUp(int index) {
			int parent = (index - 1) / 2;
			Node bottom = heapArray[index];
			
			while(index > 0 && heapArray[parent].getKey() > bottom.getKey()) {
				heapArray[index] = heapArray[parent];
				index = parent;
				parent = (parent - 1) / 2;
			}
			heapArray[index] = bottom;
		}
		
		public Node remove() {
			Node root = heapArray[0];
			heapArray[0] = heapArray[--currentSize];
			trickleDown(0);
			return root;
		}
		
		public void trickleDown(int index) {
			int smallerChild;
			Node top = heapArray[index];
			
			while(index < currentSize / 2) {
				int leftChild = 2 * index + 1;
				int rightChild = leftChild + 1;
				
				if(rightChild < currentSize && heapArray[leftChild].getKey() > heapArray[rightChild].getKey())
					smallerChild = rightChild;
				else
					smallerChild = leftChild;
				
				if(top.getKey() <= heapArray[smallerChild].getKey())
					break;
				
				heapArray[index] = heapArray[smallerChild];
				index = smallerChild;
			}
			
			heapArray[index] = top;
		}
		
		public void displayArray() {
			for(int i = 0; i < maxSize; i++) {
				System.out.print(heapArray[i].getKey() + " ");
			}
			System.out.println();
		}
		
		public void displayHeap() {
			int nBlanks = 32,
				itemsPerRow = 1,
				column = 0,
				i = 0;
			String dots = "...............................";
			System.out.println(dots + dots);
			
			while(currentSize > 0) {
				if(column == 0)
					for(int j = 0; j < nBlanks; j++)
						System.out.print(' ');
				System.out.print(heapArray[i].getKey());
				
				if(++i == currentSize)
					break;
				
				if(++column == itemsPerRow) {
					nBlanks /= 2;
					itemsPerRow *= 2;
					column = 0;
					System.out.println();
				}
				else
					for(int j = 0; j < nBlanks*2-2; j++)
						System.out.print(' ');
			}
			System.out.println("\n"+ dots + dots);
		}
	}
	// END MINIMUM HEAP CLASS
	
	// TEST METHOD
	public static void main(String[] args) {
		int size = 10;
		
		MinHeap newHeap = new MinHeap(size);
		
		for(int i = 0; i < size; i++) {
			int num = (int)(Math.random()*100);
			newHeap.insert(num);
		}
		
		System.out.print("Inserted: ");
		newHeap.displayArray();
		System.out.println("Visualized Heap:");
		newHeap.displayHeap();

	}
	// END TEST METHOD
}
// END TEST CLASS