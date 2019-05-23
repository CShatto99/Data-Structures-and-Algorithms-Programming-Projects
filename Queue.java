// Solution at bottom
public class Queue {
	private int maxSize, nItems, front, rear;
	private long[] queArray;
	
	public Queue(int size) {
		maxSize = size;
		nItems = 0; 
		front = 0;
		rear = -1;
		queArray = new long[maxSize];
	}
	
	public void insert(long value) {
		if(rear == maxSize-1)
			rear = -1;
		queArray[++rear] = value;
		nItems++;
	}
	
	public int size() {
		return nItems;
	}
	
	public long remove() {
		long temp = queArray[front++];
		if(front == maxSize)
			front = 0;
		nItems--;
		return temp;
	}
	
	public long peekFront() {
		return queArray[front];
	}
	
	public boolean isEmpty() {
		return (nItems == 0);
	}
	
	public boolean isFull() {
		return (nItems == maxSize);
	}
	
	// Display the contents of a queue without using the underlying array
	public void display() {
		for(int i = 0; i < maxSize; i++) {
			long temp = peekFront();
			System.out.print(temp + " ");
			remove();
		}
	}
}
