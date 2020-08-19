// This project implements a heap that can temporarily place new values at the end of a heap array
// until a "restoreHeap" method is called and places the values in their correct positions.
// TEST CLASS
public class TestClass12_2 {
	
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
	
	// HEAP CLASS
	public static class Heap {
		
		private int maxSize;
		private int currentSize;
		private int numTosses;
		private Node[] heapArray;
		
		
		public Heap(int mx) {
			maxSize = mx;
			currentSize = 0;
			numTosses = 0;
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
			Node bottom = heapArray[index];
			int parent = (index - 1) / 2;
			
			while(index > 0 && heapArray[parent].getKey() < bottom.getKey()) {
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
			int largerChild;
			Node top = heapArray[index];
			
			while(index < currentSize / 2) {
				int left = 2 * index + 1;
				int right = left + 1;
				
				if(right < currentSize && heapArray[left].getKey() < heapArray[right].getKey())
					largerChild = left;
				else
					largerChild = right;
				
				if(top.getKey() >= heapArray[largerChild].getKey())
					break;
				
				heapArray[index] = heapArray[largerChild];
				index = largerChild;
			}
			heapArray[index] = top;
		}
		
		// SOLUTION METHODS
		// This method inserts a value at the next available position in the heap array.
		public boolean toss(int key) {
			numTosses++;
			// Check if array is full.
			if(currentSize == maxSize)
				return false;
			// Insert new value and increment size.
			Node newNode = new Node(key);
			heapArray[currentSize++] = newNode;
			return true;
		}
		
		// This method moves the newly inserted values to their correct positions.
		public void restoreHeap() {
			// Move every value that was "tossed" starting from the end of the heap array 
			// to the number of times the tossed method was called.
			for(int i = currentSize - 1; i >= numTosses; i--) {
				trickleUp(i);
			}
		}
		// END SOLUTION METHODS
		
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
	// END HEAP CLASS
	
	// TEST METHOD
	public static void main(String[] args) {
		int size = 10;
		Heap h = new Heap(size);
		
		for(int i = 0; i < size/2; i++) {
			int num = (int)(Math.random()*100);
			h.insert(num);
		}
		
		for(int i = 0; i < size/2; i++) {
			int num = (int)(Math.random()*100);
			h.toss(num);
		}
		System.out.println("Heap before restoration:");
		h.displayHeap();
		
		h.restoreHeap();
		System.out.println("Heap after restoration:");
		h.displayHeap();
	}
	// END TEST METHOD
}
// END TEST CLASS