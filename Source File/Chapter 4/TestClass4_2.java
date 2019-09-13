// TEST CLASS
public class TestClass4_2 {
	
	// DEQUE CLASS
	public static class Deque {
		
		private int maxSize, front, rear;
		private long[] arr;
		
		public Deque(int size) {
			
			maxSize = size;
			front = 0;
			rear = -1;
			arr = new long[maxSize];
			
		}
		
		public void insertRear(long value) { // inserts a value into the back of a queue
			
			if(rear == maxSize-1)
				rear = -1;
			
			arr[++rear] = value;
			
		}
		
		public void insertFront(long value) { // inserts a value into the front of a queue
			
			if(front == 0)
				front = maxSize;
			
			arr[--front] = value;
			
		}
		
		public long removeFront() { // removes the 'oldest' values of the queue first
			
			long currentFront = arr[front++];
			
			if(front == maxSize)
				front = 0;
			
			return currentFront;
			
		}
		
		public long removeRear() { // removes the 'youngest' values of the queue first
			
			long currentRear = arr[rear--];
			
			if(rear == -1)
				rear = maxSize;
			
			return currentRear;
			
		}
		
		public long peekFront() {
			
			return arr[front];
			
		}
		
	}
	// END DEQUE CLASS
	
}
// END TEST CLASS
