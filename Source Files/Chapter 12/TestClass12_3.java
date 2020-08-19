// This project implements a priority queue using a heap.
// TEST CLASS
public class TestClass12_3 {
	
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
		private Node[] heapArray;
		private int maxSize;
		private int currentSize;
		
		public Heap(int ms) {
			maxSize = ms;
			currentSize = 0;
			heapArray = new Node[maxSize];
		}
		
		public boolean isEmpty() {
			return (currentSize == 0);
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
				int leftChild = 2 * index + 1;
				int rightChild = leftChild + 1;
				
				if(rightChild < currentSize && heapArray[leftChild].getKey() < heapArray[rightChild].getKey())
					largerChild = rightChild;
				else
					largerChild = leftChild;
				
				if(top.getKey() >= heapArray[largerChild].getKey())
					break;
				
				heapArray[index] = heapArray[largerChild];
				index = largerChild;
			}
			heapArray[index] = top;
		}
		
		public boolean change(int index, int newValue) {
			if(index < 0 || index >= currentSize)
				return false;
			
			int oldValue = heapArray[index].getKey();
			heapArray[index].setKey(newValue);
			
			if(oldValue < newValue)
				trickleUp(index);
			else
				trickleDown(index);
			return true;
		}
	}
	// END HEAP CLASS
	
	// PRIORITY QUEUE CLASS
	public static class PriorityQ {
		private int maxSize, nItems;
		private Heap PQHeap;
		
		public PriorityQ(int s) {
			maxSize = s;
			nItems = 0;
			PQHeap = new Heap(maxSize);
		}
		
		public void insert(int key) {
			PQHeap.insert(key);
			nItems++;
		}
		
		public int remove() {
			nItems--;
			return PQHeap.remove().getKey();
		}
		
		public int peek() {
			return PQHeap.remove().getKey();
		}
		
		public boolean isEmpty() {
			return (nItems == 0);
		}
		
		public boolean isFull() {
			return (nItems == maxSize);
		}
	}
	// END PRIORITY QUEUE CLASS
	
	// TEST METHOD
	public static void main(String[] args) {
		int size = 10;
		PriorityQ pq = new PriorityQ(size);
		
		System.out.print("Inserted: ");
		for(int i = 0; i < size; i++) {
			int num = (int)(Math.random()*100);
			pq.insert(num);
			System.out.print(num + " ");
		}
		
		System.out.println();
		
		System.out.print("Priority Queue: ");
		for(int i = 0; i < size; i++) {
			System.out.print(pq.remove() + " ");
		}
	}
	// END TEST METHOD
}
// END TEST CLASS